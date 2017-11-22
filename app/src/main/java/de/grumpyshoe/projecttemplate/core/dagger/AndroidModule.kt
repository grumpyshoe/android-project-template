package de.grumpyshoe.projecttemplate.core.dagger

import android.content.Context
import android.content.pm.PackageManager
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by grumpyshoe on 13.11.17.
 *
 * Module containing all parts of the Android framework
 *
 */
@Module
class AndroidModule(internal val context: Context)  {

    /**
     * method providing context
     *
     */
    @Provides
    @Singleton
    fun provideContext() : Context {
        return context
    }


    /**
     * method providing PackageManager
     *
     */
    @Provides
    @Singleton
    fun providePackageManager() : PackageManager {
        return context.packageManager
     }


    /**
     * method providing Resources
     *
     */
    @Provides
    @Singleton
    fun provideResources() : Resources {
        return context.resources
    }


}