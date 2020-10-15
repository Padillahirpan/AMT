package com.irpn.alodok.core.base


/**
 * Created by irpn on 14/10/20.
 * Email : padillahirpan8@gmail.com
 */

sealed class BaseViewState<out R> {
    object Loading: BaseViewState<Nothing>()
    data class Error(val errorMessage: String?): BaseViewState<Nothing>()
    data class Success<T>(val data: T?, val isLast: Boolean? = false): BaseViewState<T>()
}