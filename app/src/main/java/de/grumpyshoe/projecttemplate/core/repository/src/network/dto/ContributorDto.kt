package de.grumpyshoe.projecttemplate.core.repository.src.network.dto

import de.grumpyshoe.projecttemplate.core.repository.model.Contributor

/**
 * Created by grumpyshoe on 14.11.17.
 *
 * Contributor Data Transfer Object (DTO)
 *
 */
data class ContributorDto(var repo: String?, val login: String, val html_url: String, val contributions: Int) {

    /**
     * create Contributor from ContributorDto
     *
     */
    fun toContributor() : Contributor {
        return Contributor(repo, login, html_url, contributions)
    }

}