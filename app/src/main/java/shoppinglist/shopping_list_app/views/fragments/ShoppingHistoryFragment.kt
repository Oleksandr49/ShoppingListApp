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
import shoppinglist.shopping_list_app.viewmodels.CartFragmentViewModel
import shoppinglist.shopping_list_app.viewmodels.HistoryViewModel
import shoppinglist.shopping_list_app.views.adapters.HistoryAdapter
import shoppinglist.shopping_list_app.views.adapters.HistoryAdapterCallback
import shoppinglist.shopping_list_app.views.adapters.SLAdapter
import shoppinglist.shopping_list_app.views.adapters.SLAdapterCallback
import shoppinglist.shopping_list_app.views.base.BaseFragment
import shoppinglist.shopping_list_app.views.base.BaseItemDecoration
import shoppinglist.shoppinglistapp.databinding.ShoppingHistoryFragmentBinding
import javax.inject.Inject

class ShoppingHistoryFragment: BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<HistoryViewModel> {viewModelFactory}
    private var viewBinding: ShoppingHistoryFragmentBinding? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as SLApp).appComponent.historyComponent()
            .create().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBinding = ShoppingHistoryFragmentBinding.inflate(inflater, container, false)
        viewBinding?.let {binding ->
            binding.historyRecView.adapter = getAdapter()
            binding.historyRecView.layoutManager = LinearLayoutManager(activity)
            binding.historyRecView.addItemDecoration(BaseItemDecoration())
            return binding.root }
        return null
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.dispose()
        viewBinding = null
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadCarts()
    }


    private fun getAdapter(): HistoryAdapter {
        val adapter = HistoryAdapter()
        adapter.viewCallback = object : HistoryAdapterCallback{
            override fun goToDetails(cartID: Long) {
                navigateTo(ShoppingHistoryFragmentDirections.goToDetailsFragment(cartID))
            }
        }
        viewModel.allCarts.observe(viewLifecycleOwner, {adapter.updateList(it)})
        viewModel.loadCarts()
        return adapter
    }
}