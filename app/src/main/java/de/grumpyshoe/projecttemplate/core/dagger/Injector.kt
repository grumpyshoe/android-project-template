package de.grumpyshoe.projecttemplate.core.dagger

import android.app.Application

/**
 * Created by grumpyshoe on 13.11.17.
 */
enum class Injector {

    INSTANCE;

    /**
     * get generated app component
     *
     * @return
     */
    internal var appComponent: AppComponent? = null


    /**
     * init method
     *
     */
    fun init(application: Application) {
        appComponent = DaggerAppComponent.builder()
                .androidModule(AndroidModule(application))
                .repositoryModule(RepositoryModule())
                .build()
    }



    /**
     * get app component
     *
     */
    fun get() : AppComponent {
        return appComponent!!
    }


    /**
     * set app component
     *
     * @param appComponent
     */
    fun set(appComponent: AppComponent) {
        this.appComponent = appComponent
    }


}