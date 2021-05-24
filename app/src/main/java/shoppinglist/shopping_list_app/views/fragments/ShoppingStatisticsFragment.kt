package shoppinglist.shopping_list_app.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import shoppinglist.shoppinglistapp.databinding.ShoppingStatisticsFragmentBinding

class ShoppingStatisticsFragment: Fragment() {

    private var viewBinding: ShoppingStatisticsFragmentBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBinding = ShoppingStatisticsFragmentBinding.inflate(inflater, container, false)
        viewBinding?.let {binding ->  return binding.root }
        return null
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }
}