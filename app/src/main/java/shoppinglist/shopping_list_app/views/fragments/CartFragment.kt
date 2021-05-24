package shoppinglist.shopping_list_app.views.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import shoppinglist.shopping_list_app.application.SLApp
import shoppinglist.shopping_list_app.viewmodels.CartFragmentViewModel
import shoppinglist.shopping_list_app.views.adapters.CartListAdapter
import shoppinglist.shopping_list_app.views.base.BaseFragment
import shoppinglist.shopping_list_app.views.base.BaseItemDecoration
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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBinding = CartListFragmentBinding.inflate(inflater, container, false)
        viewBinding?.let { binding ->
            binding.cartListRecyclerView.adapter = getAdapter()
            binding.cartListRecyclerView.layoutManager = LinearLayoutManager(activity)
            binding.cartListRecyclerView.addItemDecoration(BaseItemDecoration())
            binding.cartConfirmationBtn.setOnClickListener{
                viewModel.confirmCart()
                navigateTo(CartFragmentDirections.backToSLFragment())
            }
            return binding.root
        }
        return null
    }

    override fun onResume() {
        super.onResume()
        viewModel.updateList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

    private fun getAdapter(): CartListAdapter {
        val adapter = CartListAdapter()
        viewModel.currentList.observe(viewLifecycleOwner, {adapter.updateList(it)})
        return adapter
    }
}