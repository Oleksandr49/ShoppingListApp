package shoppinglist.shopping_list_app.views.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import shoppinglist.shopping_list_app.application.SLApp
import shoppinglist.shopping_list_app.viewmodels.ProductsViewModel
import shoppinglist.shopping_list_app.views.adapters.ProductsAdapter
import shoppinglist.shopping_list_app.views.base.BaseFragment
import shoppinglist.shopping_list_app.views.base.BaseItemDecoration
import shoppinglist.shoppinglistapp.databinding.ProductsListFragmentBinding
import javax.inject.Inject

class ProductsListFragment: BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<ProductsViewModel> {viewModelFactory}
    private var viewBinding: ProductsListFragmentBinding? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as SLApp).appComponent.productsComponent()
                .create().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBinding = ProductsListFragmentBinding.inflate(inflater, container, false)
        viewBinding?.let {binding ->
            binding.productsFAB.setOnClickListener{navigateTo(ProductsListFragmentDirections.goToProductCreation())}
            binding.productsRecView.adapter = getAdapter()
            binding.productsRecView.layoutManager = LinearLayoutManager(activity)
            binding.productsRecView.addItemDecoration(BaseItemDecoration())
            viewModel.updateList()
            return binding.root
        }
        return null
    }

    override fun onResume() {
        super.onResume()
        viewModel.updateList()
    }

    private fun getAdapter(): ProductsAdapter {
        val adapter = ProductsAdapter()
        viewModel.currentList.observe(viewLifecycleOwner, {list -> adapter.updateList(list)})
        return adapter
    }
}