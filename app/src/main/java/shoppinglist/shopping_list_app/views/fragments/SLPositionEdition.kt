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
import shoppinglist.shopping_list_app.model.dataModels.SLPosition
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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        SLPositionOperationsBinding.inflate(inflater, container, false).also { binding ->
            viewModel.currentPosition.observe(viewLifecycleOwner,{position ->
                binding.PositionName.setText(position.productName)
                binding.Amount.setText(position.productAmount.toString())
                binding.creationConfirmation.setOnClickListener {
                    SLPosition(ID = args.PositionID, productName = binding.PositionName.text.toString(),
                    productAmount = binding.Amount.text.toString().toDouble()).also { viewModel.updatePosition(it) }
                    SLPositionEditionDirections.backToSLFragment().also { findNavController().navigate(it) }
                }
            })
            viewModel.getPosition(args.PositionID)
            return binding.root
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }
}