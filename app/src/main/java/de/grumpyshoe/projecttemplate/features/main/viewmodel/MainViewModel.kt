package de.grumpyshoe.projecttemplate.features.main.viewmodel

import android.databinding.BaseObservable
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.support.v4.widget.SwipeRefreshLayout
import android.util.Log
import de.grumpyshoe.projecttemplate.core.dagger.Injector
import de.grumpyshoe.projecttemplate.core.repository.Callback
import de.grumpyshoe.projecttemplate.core.repository.RepositoryManager
import de.grumpyshoe.projecttemplate.core.repository.model.Contributor
import okhttp3.ResponseBody
import javax.inject.Inject

/**
 * Created by grumpyshoe on 13.11.17.
 *
 * MainViewModel contains all logic for interacting with or during the UI
 */
class MainViewModel : BaseObservable() {

    @Inject lateinit var repositoryManager: RepositoryManager
    val contributors = ObservableField<String>()
    val isLoading = ObservableBoolean(false)

    /**
     * init
     *
     */
    init {
        Injector.INSTANCE.get().inject(this)

        dummyMethod()

    }


    /**
     * just a dummy method to show how to use RepositoryManager
     *
     */
    private fun dummyMethod() {

        isLoading.set(true)

        repositoryManager.geContributors(object : Callback<List<Contributor>> {

            override fun onResult(result: List<Contributor>) {
                onSuccessResult(result)
            }

            override fun onError(throwable: Throwable?, code: Int, errorBody: ResponseBody?) {
                onErrorResult(throwable, code, errorBody)
            }

        })
    }


    /**
     * load data from webservice and refresh database
     *
     */
    val onRefreshListener = SwipeRefreshLayout.OnRefreshListener {

        isLoading.set(true)

        repositoryManager.refreshContributors(object : Callback<List<Contributor>> {

            override fun onResult(result: List<Contributor>) {
                onSuccessResult(result)
            }

            override fun onError(throwable: Throwable?, code: Int, errorBody: ResponseBody?) {
                onErrorResult(throwable, code, errorBody)
            }

        })
    }


    /**
     * handle success
     *
     */
    internal fun onSuccessResult(result: List<Contributor>) {
        contributors.set(result.toString())
        isLoading.set(false)
        Log.d("RESULT", "SUCCESS: MainThread: " + result.toString())
    }


    /**
     * handle error
     *
     */
    internal fun onErrorResult(throwable: Throwable?, code: Int, errorBody: ResponseBody?) {
        contributors.set(errorBody?.string())
        isLoading.set(false)
        Log.e("RESULT", "ERROR:  HTTP_CODE:" + code.toString() + " " + contributors.get())
    }


}