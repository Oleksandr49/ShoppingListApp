package shoppinglist.shopping_list_app.views.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import shoppinglist.shopping_list_app.application.SLApp
import shoppinglist.shopping_list_app.viewmodels.ProductsViewModel
import shoppinglist.shopping_list_app.viewmodels.SLViewModel
import shoppinglist.shoppinglistapp.databinding.ProductsListFragmentBinding
import javax.inject.Inject

class ProductsListFragment: Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<ProductsViewModel> {viewModelFactory}

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as SLApp).appComponent.productsComponent()
                .create().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        ProductsListFragmentBinding.inflate(inflater, container, false).also { binding ->
            return binding.root
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}