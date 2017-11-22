package de.grumpyshoe.projecttemplate.core.dagger

import dagger.Component
import de.grumpyshoe.projecttemplate.core.repository.RepositoryManager
import de.grumpyshoe.projecttemplate.core.repository.src.database.impl.sqlite.SQliteService
import de.grumpyshoe.projecttemplate.core.repository.src.network.impl.retrofit.GithubService
import de.grumpyshoe.projecttemplate.features.main.viewmodel.MainViewModel
import javax.inject.Singleton

/**
 * Created by grumpyshoe on 13.11.17.
 */
@Singleton
@Component(modules = arrayOf(AndroidModule::class, RepositoryModule::class))
interface AppComponent {

    // base
    fun inject(view: GithubService)
    fun inject(view: SQliteService)
    fun inject(view: RepositoryManager)

    // viewmodel
    fun inject(view: MainViewModel)

}