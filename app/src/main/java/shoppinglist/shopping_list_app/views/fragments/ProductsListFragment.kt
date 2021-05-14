package shoppinglist.shopping_list_app.views.fragments

import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import shoppinglist.shopping_list_app.application.SLApp
import shoppinglist.shopping_list_app.viewmodels.ProductsViewModel
import shoppinglist.shopping_list_app.views.adapters.ProductsAdapter
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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        ProductsListFragmentBinding.inflate(inflater, container, false).also { binding ->
            binding.productsRecView.adapter = ProductsAdapter().also { adapter ->
                viewModel.currentList.observe(viewLifecycleOwner, {adapter.updateList(it)})
            }
            binding.productsRecView.layoutManager = LinearLayoutManager(activity)
            binding.productsRecView.addItemDecoration(object : RecyclerView.ItemDecoration() {
                override fun getItemOffsets(
                        outRect: Rect,
                        view: View,
                        parent: RecyclerView,
                        state: RecyclerView.State
                ) {
                    super.getItemOffsets(outRect, view, parent, state)
                    outRect.left = 10
                    outRect.right = 10
                    outRect.bottom = 15
                    outRect.top = 15
                }
            })
            viewModel.updateList()
            return binding.root
        }
    }
}