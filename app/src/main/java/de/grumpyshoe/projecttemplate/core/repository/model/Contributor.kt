package de.grumpyshoe.projecttemplate.core.repository.model

/**
 * Created by grumpyshoe on 14.11.17.
 *
 * Internal used model
 */
data class Contributor(val repo: String?, val login: String, val html_url: String, val contributions: Int)