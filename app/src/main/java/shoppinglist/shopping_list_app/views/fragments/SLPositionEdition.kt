package shoppinglist.shopping_list_app.views.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import shoppinglist.shopping_list_app.application.SLApp
import shoppinglist.shopping_list_app.model.dataModels.ListItem
import shoppinglist.shopping_list_app.viewmodels.SLPositionEditionViewModel
import shoppinglist.shoppinglistapp.databinding.SLPositionOperationsBinding
import javax.inject.Inject

class SLPositionEdition: Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<SLPositionEditionViewModel> {viewModelFactory}
    private var viewBinding: SLPositionOperationsBinding? = null

    val args: SLPositionEditionArgs by navArgs()


    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as SLApp).appComponent.slPositionEditionComponent()
            .create().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBinding = SLPositionOperationsBinding.inflate(inflater, container, false)
        val positionID = args.positionID
        viewBinding?.let { binding ->
            viewModel.currentPosition.observe(viewLifecycleOwner,{position ->
                binding.PositionName.setText(position.name)
                binding.Amount.setText(position.amount.toString())
                binding.creationConfirmation.setOnClickListener {
                    val item = ListItem(id = positionID, name = binding.PositionName.text.toString(),
                        amount = binding.Amount.text.toString().toDouble(), productId = 1L)
                    viewModel.updatePosition(item)
                    SLPositionEditionDirections.backToSLFragment().also { findNavController().navigate(it) }
                }
            })
            viewModel.getPosition(positionID)
            return binding.root
        }
        return null
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }
}