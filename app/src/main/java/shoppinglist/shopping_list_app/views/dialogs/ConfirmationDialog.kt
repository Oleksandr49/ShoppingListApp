package shoppinglist.shopping_list_app.views.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class ConfirmationDialog(val callback: ()-> Unit): DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
         AlertDialog.Builder(activity).also {
             it.setMessage("Confirm please")
                 .setPositiveButton("Confirm") { _: DialogInterface?, _: Int -> callback() }
                 .setNegativeButton("Cancel") { dialog: DialogInterface, _: Int -> dialog.dismiss() }
             return it.create()
         }
    }
}