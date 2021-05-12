package shoppinglist.shopping_list_app.views.base

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment

abstract class BaseFragment: Fragment() {

    fun showDialog(dialog: DialogFragment){
        parentFragmentManager.let { dialog.show(it, "anyTag") }
    }
}