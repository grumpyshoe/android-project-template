package de.grumpyshoe.projecttemplate.core.repository.src.network.impl.retrofit.api

import de.grumpyshoe.projecttemplate.core.repository.src.network.dto.ContributorDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path



/**
 * Created by grumpyshoe on 14.11.17.
 *
 * Retrofit Github API
 */
interface GithubServiceApi {


    /**
     * get all contributors
     *
     */
    @GET("repos/{owner}/{repo}/contributors")
    fun repoContributors(@Path("owner") owner: String,
                         @Path("repo") repo: String): Call<List<ContributorDto>>;
}