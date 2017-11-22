package de.grumpyshoe.projecttemplate.core.repository.src.database.impl.sqlite.room.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import de.grumpyshoe.projecttemplate.core.repository.src.database.impl.sqlite.room.entities.ContributorEntity

/**
 * Created by grumpyshoe on 14.11.17.
 *
 * Dao interface for interacting on Room Data object for 'Contributor'
 */
@Dao
interface ContributorDao {

    @Query("select * from contributors")
    fun getAllContributors(): List<ContributorEntity>

//    @Query("select * from repositories where id = :id")
//    fun findContributorById(id: Long): ContributorEntity

    @Insert(onConflict = REPLACE)
    fun insertContributor(contributor: ContributorEntity)

//    @Update(onConflict = REPLACE)
//    fun updateContributor(contributor: ContributorEntity)
//
//    @Delete
//    fun deleteTContributor(contributor: ContributorEntity)

    @Query("delete from contributors ")
    fun deleteAll()

}