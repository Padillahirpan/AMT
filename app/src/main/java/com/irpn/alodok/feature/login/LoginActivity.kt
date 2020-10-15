package com.irpn.alodok.feature.login

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.irpn.alodok.MainActivity
import com.irpn.alodok.R
import com.irpn.alodok.core.base.BaseActivity
import com.irpn.alodok.core.helper.PrefHelper
import com.irpn.alodok.core.models.User
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.ext.android.inject


/**
 * Created by irpn on 14/10/20.
 * Email : padillahirpan8@gmail.com
 */

class LoginActivity: BaseActivity() {

    val prefHelper: PrefHelper by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        if (prefHelper.getUser() == null) {
            ct_form_login.visibility = View.VISIBLE
        } else {
            MainActivity.startThisActivity(this, "");
        }

        bt_submit?.setOnClickListener{
            val username = et_username.text.toString()
            val phone = et_phone.text.toString()
            if (username.isEmpty()) {
                Toast.makeText(this, "Please insert username", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if (phone.isEmpty()) {
                Toast.makeText(this, "Please insert phone", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            prefHelper.saveUser(User(username, phone, 1))
            MainActivity.startThisActivity(this, "");
        }
    }
}