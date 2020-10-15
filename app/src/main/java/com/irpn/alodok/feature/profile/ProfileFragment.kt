package com.irpn.alodok.feature.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.irpn.alodok.R
import com.irpn.alodok.core.base.loadCornerImage
import com.irpn.alodok.core.helper.PrefHelper
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.item_content.view.*
import org.koin.android.ext.android.inject


/**
 * Created by irpn on 14/10/20.
 * Email : padillahirpan8@gmail.com
 */

class ProfileFragment : Fragment() {

    val prefHelper: PrefHelper by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupContent()
    }

    private fun setupContent() {
        val user = prefHelper.getUser()
        user?.let{item ->
            activity?.let { Glide.with(it).load(item.phoneNumber).into(iv_profile) }
            tv_name.text = item.userName
            if (item.gender == 1) {
                tv_gender.text = resources.getText(R.string.text_male)
            } else {
                tv_gender.text = resources.getText(R.string.text_female)
            }
            tv_phone.text = item.phoneNumber
            context?.let {
                iv_profile.loadCornerImage("https://www.vets4pets.com/siteassets/species/cat/close-up-of-cat-looking-up.jpg?w=585&scale=down", radius = 16)
            }
        }
    }
}