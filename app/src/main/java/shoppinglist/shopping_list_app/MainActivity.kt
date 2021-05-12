package shoppinglist.shopping_list_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import shoppinglist.shoppinglistapp.R

class MainActivity: AppCompatActivity() {

     var navHostFragment: NavHostFragment? = null
     var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentPlaceHolder) as NavHostFragment
        navController = navHostFragment?.navController
        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction().also {
                navController?.navigate(R.id.homeFragment)
            }
        }
    }
}