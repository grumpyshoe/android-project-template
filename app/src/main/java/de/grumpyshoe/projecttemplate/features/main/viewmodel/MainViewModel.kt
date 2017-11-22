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
    val owner = ObservableField<String>("grumpyshoe")
    val repo = ObservableField<String>("android-project-template")
    val isLoading = ObservableBoolean(false)

    /**
     * init
     *
     */
    init {
        Injector.INSTANCE.get().inject(this)

        loadContributors()
    }


    /**
     * just a dummy method to show how to use RepositoryManager
     *
     */
    private fun loadContributors(isRefresh : Boolean = false) {

        isLoading.set(true)

        repositoryManager.getContributors(owner.get(), repo.get(), isRefresh, object : Callback<List<Contributor>> {

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

        loadContributors(true)

    }


    /**
     * just a dummy method to show how to bind a action to onClick in xml
     *
     */
    fun onBtnClick() {

        loadContributors(true)
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
        contributors.set("HTTP CODE : " + code.toString() + " - " + errorBody?.string())
        isLoading.set(false)
        Log.e("RESULT", "ERROR:  HTTP_CODE:" + code.toString() + " " + contributors.get())
    }


}