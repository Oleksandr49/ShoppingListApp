package shoppinglist.shopping_list_app.views.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import shoppinglist.shopping_list_app.application.SLApp
import shoppinglist.shopping_list_app.viewmodels.CartDetailsViewModel
import shoppinglist.shopping_list_app.views.adapters.CartListAdapter
import shoppinglist.shopping_list_app.views.base.BaseFragment
import shoppinglist.shopping_list_app.views.base.BaseItemDecoration
import shoppinglist.shoppinglistapp.databinding.CartDetailsFragmentBinding
import javax.inject.Inject

class CartDetailsFragment: BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<CartDetailsViewModel> {viewModelFactory}
    private var viewBinding: CartDetailsFragmentBinding? = null

    val args: CartDetailsFragmentArgs by navArgs()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as SLApp).appComponent.carteDetailsComponent()
            .create().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBinding = CartDetailsFragmentBinding.inflate(inflater, container, false)
        viewBinding?.let { binding ->
            binding.cartDetailsRecyclerView.adapter = getAdapter()
            binding.cartDetailsRecyclerView.layoutManager = LinearLayoutManager(activity)
            binding.cartDetailsRecyclerView.addItemDecoration(BaseItemDecoration())
            return binding.root
        }
        return null
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

    private fun getAdapter(): CartListAdapter {
        val adapter = CartListAdapter()
        viewModel.cartItems.observe(viewLifecycleOwner, {adapter.updateList(it)})
        viewModel.loadCart(args.cartID)
        return adapter
    }
}