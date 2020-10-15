package com.irpn.alodok.core.di

import com.irpn.alodok.core.helper.PrefHelper
import org.koin.dsl.module

/**
 * Created by irpn on 14/10/20.
 * Email : padillahirpan8@gmail.com
 */

val coreModule = module {
    single {
        PrefHelper(context = get())
    }
}