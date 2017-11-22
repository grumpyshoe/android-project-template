package de.grumpyshoe.projecttemplate.core.repository.src.network.impl.retrofit

import de.grumpyshoe.projecttemplate.core.repository.src.network.NetworkManager
import de.grumpyshoe.projecttemplate.core.repository.src.network.dto.ContributorDto
import de.grumpyshoe.projecttemplate.core.repository.src.network.impl.retrofit.api.GithubServiceApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import de.grumpyshoe.projecttemplate.core.repository.Callback as RepoCallback

/**
 * Created by grumpyshoe on 14.11.17.
 *
 * NetworkManager using retrofit
 */
class GithubService : NetworkManager {

    private val githubDummyServiceApi: GithubServiceApi

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

        githubDummyServiceApi = retrofit.create(GithubServiceApi::class.java)
    }


    /**
     * get contributors from repo
     *
     */
    override fun getRepoContributors(owner: String, repo: String, callback: RepoCallback<List<ContributorDto>>) {

        // request contributors
        githubDummyServiceApi.repoContributors(owner, repo).enqueue(object : Callback<List<ContributorDto>> {

            override fun onResponse(call: Call<List<ContributorDto>>, response: Response<List<ContributorDto>>?) {

                if(response != null) {
                    if (response.isSuccessful && response.body() != null) {
                        callback.onResult(response.body())
                    } else {
                        callback.onError(code = response.code(), errorBody = response.errorBody())
                    }
                }
                else{
                    callback.onError(code = 404)
                }

            }


            override fun onFailure(call: Call<List<ContributorDto>>?, t: Throwable) {
                callback.onError(t)
            }

        })
    }

}