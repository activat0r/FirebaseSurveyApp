package com.activator.survey.Utilities.Interfaces

import com.activator.survey.models.Projects
import org.json.JSONObject
import retrofit2.Response
import retrofit2.http.GET

const val BASE_URL:String = "https://gagile.syntelinc.com/"

interface NetworkInterface {

    @GET("getProjects/")
    fun getProjects():List<Projects>

    fun post(url: String): Response<JSONObject>

    fun put(url: String): Response<JSONObject>
    
}