package com.irpn.alodok

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.irpn.alodok.core.base.BaseActivity
/**
 * Created by irpn on 14/10/20.
 * Email : padillahirpan8@gmail.com
 */
class MainActivity : BaseActivity() {

    companion object{
        const val EXTRA_ITEM_MAIN = "item"
        fun startThisActivity(context: Context, isShowPurchased: String) {
            val intent  = Intent(context, MainActivity::class.java)
            intent.putExtra(EXTRA_ITEM_MAIN, isShowPurchased)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_main)
        val navController = findNavController(R.id.nav_host_fragment)

        navView.setupWithNavController(navController)
    }
}