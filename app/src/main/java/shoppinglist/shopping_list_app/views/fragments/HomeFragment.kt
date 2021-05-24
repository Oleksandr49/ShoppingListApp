package shoppinglist.shopping_list_app.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import shoppinglist.shopping_list_app.views.base.BaseFragment
import shoppinglist.shoppinglistapp.databinding.HomeFragmentBinding

class HomeFragment: BaseFragment() {

    private var viewBinding: HomeFragmentBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBinding = HomeFragmentBinding. inflate(inflater, container, false)
        viewBinding?.let { binding ->
            binding.shoppingListBtn.setOnClickListener {navigateTo(HomeFragmentDirections.goToSLFragment())}
            binding.productsListBtn.setOnClickListener {navigateTo(HomeFragmentDirections.goToProductsListFragment())}
            binding.historyBtn.setOnClickListener {navigateTo(HomeFragmentDirections.goToShoppingHistoryFragment())}
            binding.statisticsBtn.setOnClickListener {navigateTo(HomeFragmentDirections.goToShoppingStatisticsFragment())}
            return binding.root
        }
        return null
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }
}