package de.grumpyshoe.projecttemplate.core.repository.src.database.impl.sqlite.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import de.grumpyshoe.projecttemplate.core.repository.src.database.impl.sqlite.room.dao.ContributorDao
import de.grumpyshoe.projecttemplate.core.repository.src.database.impl.sqlite.room.entities.ContributorEntity

/**
 * Created by grumpyshoe on 14.11.17.
 *
 * Room database definition
 */
@Database(entities = arrayOf(ContributorEntity::class), version = 1, exportSchema = false)
abstract class Database : RoomDatabase() {

    abstract fun contributorDao(): ContributorDao

}