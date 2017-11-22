package de.grumpyshoe.projecttemplate.core.repository.src.database.impl.sqlite

import android.arch.persistence.room.Room
import android.content.Context
import de.grumpyshoe.projecttemplate.core.dagger.Injector
import de.grumpyshoe.projecttemplate.core.repository.model.Contributor
import de.grumpyshoe.projecttemplate.core.repository.src.database.DatabaseManager
import de.grumpyshoe.projecttemplate.core.repository.src.database.impl.sqlite.room.Database
import de.grumpyshoe.projecttemplate.core.repository.src.database.impl.sqlite.room.entities.ContributorEntity
import javax.inject.Inject

/**
 * Created by grumpyshoe on 13.11.17.
 *
 * DatabaseManager for SQlite DB
 */
class SQliteService : DatabaseManager {

    private val database : Database

    @Inject lateinit var context : Context

    init {

        Injector.INSTANCE.get().inject(this)

        database = Room
                .databaseBuilder(context, Database::class.java, "my-todo-db")
                .fallbackToDestructiveMigration()
                .build()
    }

    /**
     * get all contributors
     *
     */
    override  fun getAllContributor() : List<ContributorEntity> {
        return database.contributorDao().getAllContributors()
    }


    /**
     * insert new contributor
     *
     */
    override  fun insertContributor(contributor: Contributor) {
        return database.contributorDao().insertContributor(ContributorEntity.fromContributor(contributor))
    }

    /**
     * remove all stored contributors
     *
     */
    override fun removeContributors() {
        database.contributorDao().deleteAll()
    }

}