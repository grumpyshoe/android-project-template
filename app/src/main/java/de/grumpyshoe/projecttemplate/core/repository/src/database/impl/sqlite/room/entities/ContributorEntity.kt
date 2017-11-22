package de.grumpyshoe.projecttemplate.core.repository.src.database.impl.sqlite.room.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import de.grumpyshoe.projecttemplate.core.repository.model.Contributor

/**
 * Created by grumpyshoe on 14.11.17.
 *
 * Contributor Entity customized for handling with room
 */
@Entity(tableName = "contributors")
data class ContributorEntity(val repo: String?, val login: String, val html_url: String, val contributions: Int) {

    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0


    /**
     * create Contributor from ContributorEntity
     *
     */
    fun toContributor(): Contributor {
        return Contributor(repo, login, html_url, contributions)
    }


    /**
     * create DTO from Contributor
     *
     */
    companion object {
        fun fromContributor(contributor: Contributor): ContributorEntity {
            return ContributorEntity(contributor.repo, contributor.login, contributor.html_url, contributor.contributions)
        }
    }
}