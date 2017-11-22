package de.grumpyshoe.projecttemplate.core

import android.app.Application
import de.grumpyshoe.projecttemplate.core.dagger.Injector

/**
 * Created by grumpyshoe on 13.11.17.
 *
 * The App Application class
 */
class AppApplication : Application() {

    /**
     * onCreate
     *
     */
    override fun onCreate() {
        super.onCreate()

        // init dependency injection
        Injector.INSTANCE.init(this)
    }

}