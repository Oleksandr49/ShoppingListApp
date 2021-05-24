package shoppinglist.shopping_list_app.views.base

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView

abstract class BaseFragment: Fragment() {

    fun showDialog(dialog: DialogFragment){
        parentFragmentManager.let { dialog.show(it, "anyTag") }
    }

    protected fun navigateTo(direction: NavDirections) = findNavController().navigate(direction)
}