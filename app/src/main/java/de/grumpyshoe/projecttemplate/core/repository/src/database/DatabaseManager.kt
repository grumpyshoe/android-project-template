package de.grumpyshoe.projecttemplate.core.repository.src.database

import de.grumpyshoe.projecttemplate.core.repository.model.Contributor
import de.grumpyshoe.projecttemplate.core.repository.src.database.impl.sqlite.room.entities.ContributorEntity

/**
 * Created by grumpyshoe on 13.11.17.
 *
 * Interface for DatabaseManager
 */
interface DatabaseManager {

    /**
     * get all contributors
     *
     */
    fun getAllContributor() : List<ContributorEntity>


    /**
     * insert new contributor
     *
     */
    fun insertContributor(contributor: Contributor)


    /**
     * insert new contributor
     *
     */
    fun removeContributors()
}