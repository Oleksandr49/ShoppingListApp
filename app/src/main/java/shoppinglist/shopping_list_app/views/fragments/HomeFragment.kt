package shoppinglist.shopping_list_app.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import shoppinglist.shoppinglistapp.databinding.HomeFragmentBinding

class HomeFragment: Fragment() {

    private var viewBinding: HomeFragmentBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBinding = HomeFragmentBinding. inflate(inflater, container, false)
        viewBinding?.let { binding ->
            binding.shoppingListBtn.setOnClickListener { HomeFragmentDirections.goToSLFragment().also { findNavController().navigate(it) } }
            binding.productsListBtn.setOnClickListener { HomeFragmentDirections.goToProductsListFragment()
                .also { findNavController().navigate(it) } }
            binding.historyBtn.setOnClickListener { HomeFragmentDirections.goToShoppingHistoryFragment()
                .also { findNavController().navigate(it) } }
            binding.statisticsBtn.setOnClickListener { HomeFragmentDirections.goToShoppingStatisticsFragment()
                .also { findNavController().navigate(it) } }
        }
        return viewBinding?.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }
}