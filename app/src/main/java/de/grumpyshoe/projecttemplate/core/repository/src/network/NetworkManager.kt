package de.grumpyshoe.projecttemplate.core.repository.src.network

import de.grumpyshoe.projecttemplate.core.repository.src.network.dto.ContributorDto
import de.grumpyshoe.projecttemplate.core.repository.Callback as RepoCallback

/**
 * Created by grumpyshoe on 13.11.17.
 *
 * Interfave for NetworkManager
 */
interface NetworkManager {

    fun getRepoContributors(owner: String, repo: String, callback: RepoCallback<List<ContributorDto>>)

}