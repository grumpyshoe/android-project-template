package de.grumpyshoe.projecttemplate.core.dagger

import dagger.Module
import dagger.Provides
import de.grumpyshoe.projecttemplate.core.repository.RepositoryManager
import de.grumpyshoe.projecttemplate.core.repository.src.database.DatabaseManager
import de.grumpyshoe.projecttemplate.core.repository.src.database.impl.sqlite.SQliteService
import de.grumpyshoe.projecttemplate.core.repository.src.network.NetworkManager
import de.grumpyshoe.projecttemplate.core.repository.src.network.impl.retrofit.GithubService
import javax.inject.Singleton

/**
 * Created by grumpyshoe on 13.11.17.
 *
 * Module containing RepositoryManager
 *
 */
@Module
class RepositoryModule {


    /**
     * this method is just a placeholder to show how
     * a dependency should be implemented
     */
    @Provides
    @Singleton
    fun provideRepositoryManager(): RepositoryManager {
        return RepositoryManager()
    }

    /**
     * this method is just a placeholder to show how
     * a dependency should be implemented
     */
    @Provides
    @Singleton
    fun provideDatabaseManager(): DatabaseManager {
        return SQliteService()
    }

    /**
     * this method is just a placeholder to show how
     * a dependency should be implemented
     */
    @Provides
    @Singleton
    fun provideNetworkManager() : NetworkManager {
        return GithubService()
    }
}