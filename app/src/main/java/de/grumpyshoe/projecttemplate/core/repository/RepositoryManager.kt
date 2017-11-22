package de.grumpyshoe.projecttemplate.core.repository

import de.grumpyshoe.projecttemplate.core.dagger.Injector
import de.grumpyshoe.projecttemplate.core.repository.model.Contributor
import de.grumpyshoe.projecttemplate.core.repository.src.database.DatabaseManager
import de.grumpyshoe.projecttemplate.core.repository.src.network.NetworkManager
import de.grumpyshoe.projecttemplate.core.repository.src.network.dto.ContributorDto
import okhttp3.ResponseBody
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import javax.inject.Inject
import de.grumpyshoe.projecttemplate.core.repository.Callback as RepoCallback

/**
 * Created by grumpyshoe on 13.11.17.
 *
 * RepositoryManager contains all logic for getting data from a webservice
 * and storing it to a local database.
 */
class RepositoryManager {

    @Inject protected lateinit var databaseManager: DatabaseManager
    @Inject protected lateinit var networkManager: NetworkManager

    val owner = "grumpyshoe"
    val repo = "android-project-template"

    init {
        Injector.INSTANCE.get().inject(this)
    }


    fun geContributors(callback: RepoCallback<List<Contributor>>) {

        doAsync {

            // 1. try to find data in database
            var result: List<Contributor> = databaseManager.getAllContributor()
                    .map { it.toContributor() }

            // 2. check if value is available
            if (result.isNotEmpty()) {

                // if yes, return data
                uiThread {

                    // 2.1. return result
                    callback.onResult(result)

                }

            } else {

                // 2.2. if not, try to request data from api
                networkManager.getRepoContributors(owner, repo, object : RepoCallback<List<ContributorDto>> {

                    override fun onResult(result: List<ContributorDto>) {

                        doAsync {
                            // 4. save result in database (add repo 'retrofit' before)
                            result.forEach {

                                it.repo = repo

                            }

                            // 3. return result
                            uiThread {
                                callback.onResult(result.map { it.toContributor() })
                            }
                        }


                        doAsync {
                            // 4. save result in database (add repo 'retrofit' before)
                            result.forEach {

                                databaseManager.insertContributor(it.toContributor())
                            }

                        }

                    }

                    override fun onError(throwable: Throwable?, code: Int, errorBody: ResponseBody?) {
                        uiThread {
                            callback.onError(throwable, code, errorBody)
                        }
                    }

                })

            }

        }

    }


    /**
     * refresh database if network request is successfull
     *
     */
    fun refreshContributors(callback: RepoCallback<List<Contributor>>) {

        doAsync {

            // 1. get entries from network
            networkManager.getRepoContributors(owner, repo, object : RepoCallback<List<ContributorDto>> {

                override fun onResult(result: List<ContributorDto>) {

                    doAsync {

                        // 2. remove database entries
                        databaseManager.removeContributors()

                        // 3. save result in database (add repo 'retrofit' before)
                        result.forEach {

                            it.repo = repo

                        }

                        // 4. return result
                        uiThread {
                            callback.onResult(result.map { it.toContributor() })
                        }
                    }


                    doAsync {
                        // 4. save result in database (add repo 'retrofit' before)
                        result.forEach {

                            databaseManager.insertContributor(it.toContributor())
                        }

                    }

                }

                override fun onError(throwable: Throwable?, code: Int, errorBody: ResponseBody?) {
                    uiThread {
                        callback.onError(throwable, code, errorBody)
                    }
                }

            })
        }
    }

}