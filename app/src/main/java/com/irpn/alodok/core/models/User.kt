package com.irpn.alodok.core.models

import java.io.Serializable

/**
 * Created by irpn on 14/10/20.
 * Email : padillahirpan8@gmail.com
 */

data class User(val userName: String, val phoneNumber: String, val gender: Int=0): Serializable