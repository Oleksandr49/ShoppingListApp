package shoppinglist.shopping_list_app.views.fragments

import android.R
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import shoppinglist.shopping_list_app.application.SLApp
import shoppinglist.shopping_list_app.model.dataModels.AmountType
import shoppinglist.shopping_list_app.viewmodels.ProductCreationViewModel
import shoppinglist.shopping_list_app.views.base.BaseFragment
import shoppinglist.shoppinglistapp.databinding.ProductCreationFragmentBinding
import javax.inject.Inject

class ProductCreationFragment: BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<ProductCreationViewModel> {viewModelFactory}
    var viewBinding:ProductCreationFragmentBinding? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as SLApp).appComponent.productCreationComponent().create().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBinding = ProductCreationFragmentBinding.inflate(inflater, container, false)
        viewBinding?.let { binding ->
            val productNamesList = ArrayList<String>()
            viewModel.productList.observe(viewLifecycleOwner, { list ->
                Log.i("ProcessTag", "${list.size} existing products loaded")
                for(item in list) productNamesList.add(item.name)})
            viewModel.loadProducts()
            activity?.let {
                binding.ProductNameInput.setAdapter(ArrayAdapter(it.applicationContext, R.layout.simple_dropdown_item_1line, productNamesList))
            }
            binding.creationConfirmation.setOnClickListener{
                val checkedButton = binding.productType.checkedRadioButtonId
                val productName = binding.ProductNameInput.text.toString()
                val amountType = when(checkedButton){
                    binding.Liter.id -> AmountType.L
                    binding.Kilogram.id -> AmountType.KG
                    binding.Package.id -> AmountType.PACK
                    binding.Item.id -> AmountType.ITEM
                    else -> null
                }
                viewModel.create(productName, amountType)
                navigateTo(ProductCreationFragmentDirections.backToProductList())}
            return binding.root
        }
        return null
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.dispose()
    }
}