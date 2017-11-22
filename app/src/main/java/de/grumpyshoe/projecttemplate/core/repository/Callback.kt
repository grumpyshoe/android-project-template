package de.grumpyshoe.projecttemplate.core.repository

import okhttp3.ResponseBody

/**
 * Created by grumpyshoe on 14.11.17.
 *
 * Callback used on async network tasks
 */
interface Callback<T> {

    fun onResult(result : T)
    fun onError(throwable: Throwable? = null, code: Int = -1, errorBody: ResponseBody? = null)

}