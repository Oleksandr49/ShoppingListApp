package shoppinglist.shopping_list_app.views.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import shoppinglist.shopping_list_app.application.SLApp
import shoppinglist.shopping_list_app.model.dataModels.BaseProduct
import shoppinglist.shopping_list_app.viewmodels.SLPositionCreationViewModel
import shoppinglist.shopping_list_app.views.base.BaseFragment
import shoppinglist.shopping_list_app.views.dialogs.ConfirmationDialog
import shoppinglist.shoppinglistapp.databinding.SLPositionOperationsBinding
import javax.inject.Inject

class SLPositionCreation: BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<SLPositionCreationViewModel> {viewModelFactory}

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as SLApp).appComponent.slPositionCreationComponent().create().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        SLPositionOperationsBinding.inflate(inflater, container, false).also {binding ->
            val productList = ArrayList<String>()
            viewModel.productList.observe(viewLifecycleOwner, { list -> for(item in list) productList.add(item.name)})
            viewModel.loadProducts()
            activity?.let {
                binding.PositionName.setAdapter(ArrayAdapter(it.applicationContext, android.R.layout.simple_dropdown_item_1line, productList))
            }
            binding.creationConfirmation.setOnClickListener {
                showDialog(ConfirmationDialog {
                    viewModel.create(binding.PositionName.text.toString(), binding.Amount.text.toString().toDouble())
                    SLPositionCreationDirections.backToSLFragment().also { findNavController().navigate(it) }
                })
            }
            return binding.root
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.dispose()
    }

}