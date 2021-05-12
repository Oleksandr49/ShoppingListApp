package shoppinglist.shopping_list_app.views.fragments

import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import shoppinglist.shopping_list_app.application.SLApp
import shoppinglist.shopping_list_app.viewmodels.CartFragmentViewModel
import shoppinglist.shopping_list_app.views.adapters.CartListAdapter
import shoppinglist.shopping_list_app.views.base.BaseFragment
import shoppinglist.shoppinglistapp.databinding.CartListFragmentBinding
import javax.inject.Inject

class CartFragment: BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<CartFragmentViewModel> {viewModelFactory}
    private var viewBinding: CartListFragmentBinding? = null


    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as SLApp).appComponent.cartComponent()
            .create().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        CartListFragmentBinding.inflate(inflater, container, false).also { binding ->
            binding.cartListRecyclerView.adapter = CartListAdapter().also { adapter ->
                viewModel.currentList.observe(viewLifecycleOwner, {
                    adapter.updateList(it)})
            }
            binding.cartListRecyclerView.layoutManager = LinearLayoutManager(activity)
            binding.cartListRecyclerView.addItemDecoration(object : RecyclerView.ItemDecoration() {
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
            binding.cartConfirmationBtn.setOnClickListener{
                viewModel.confirmCart()
                CartFragmentDirections.backToSLFragment().also { findNavController().navigate(it) }
            }
            return binding.root
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.updateList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }
}