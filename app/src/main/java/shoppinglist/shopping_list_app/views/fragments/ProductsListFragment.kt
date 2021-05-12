package shoppinglist.shopping_list_app.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import shoppinglist.shoppinglistapp.databinding.ProductsListFragmentBinding

class ProductsListFragment: Fragment() {

    private var viewBinding: ProductsListFragmentBinding? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBinding = ProductsListFragmentBinding.inflate(inflater, container, false)
        return viewBinding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }
}