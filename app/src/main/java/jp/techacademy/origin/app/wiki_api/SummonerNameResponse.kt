package jp.techacademy.origin.app.wiki_api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SNResponse(
    @Json(name = "accountId")
    val accountId: String,
    @Json(name = "id")
    val id: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "profileIconId")
    val profileIconId: Int,
    @Json(name = "puuid")
    val puuid: String,
    @Json(name = "revisionDate")
    val revisionDate: Long,
    @Json(name = "summonerLevel")
    val summonerLevel: Int
)
