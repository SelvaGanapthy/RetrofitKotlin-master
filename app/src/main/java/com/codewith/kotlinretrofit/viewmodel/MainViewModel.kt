package com.codewith.kotlinretrofit.viewmodel

import android.util.Log
import androidx.databinding.ObservableField
import com.codewith.kotlinretrofit.api.ApiServices
import com.codewith.kotlinretrofit.listener.ApiResponseListener
import com.codewith.kotlinretrofit.model.Data
import com.codewith.kotlinretrofit.model.Datas
import com.codewith.kotlinretrofit.model.GetResponse
import com.codewith.kotlinretrofit.model.PostResponse
import com.codewith.kotlinretrofit.util.ApiUtils
import com.codewith.kotlinretrofit.util.RetrofitClient
import com.codewith.kotlinretrofit.util.UrlRequest
import com.google.gson.JsonObject
import org.json.JSONObject
import retrofit2.Call
import java.util.*

class MainViewModel : Observable(), ApiResponseListener {

    private var retrofitClient: RetrofitClient
    private var apiService: ApiServices
    private lateinit var apiType: String
    val observablePostResponse = ObservableField<Any>()

    init {
        retrofitClient = RetrofitClient()
        apiService = retrofitClient.getRetrofitApiService(ApiUtils.BASE_URL)
        Log.i("apiservice", apiService.toString())
    }

    fun postEmployeeDetails(employee: JSONObject) {
        val postRes: Call<PostResponse> = apiService.empDetails(UrlRequest.EMPDETAILS_URL, employee)
        retrofitClient.addRetrofitCalls(postRes, this, UrlRequest.EMPDETAILS_URL)
    }


    fun postStatus(status: JSONObject): Unit {

        val postRes: Call<Data> = apiService.appStatus(UrlRequest.STATUS_URL, status)
        retrofitClient.addRetrofitCalls(postRes, this, UrlRequest.STATUS_URL)

    }


    fun getEmployees() {
        val postRes: Call<List<GetResponse>> = apiService.getEmployee(UrlRequest.EMPDETAILS_GET)
        retrofitClient.addRetrofitCalls(postRes, this, UrlRequest.EMPDETAILS_GET)
    }

    override fun onReceiveResult(request: String, response: retrofit2.Response<*>) {

        when (request) {

            UrlRequest.EMPDETAILS_URL -> {
                Log.i("MainActivity", "API response:" + response.isSuccessful)
                Log.i("MainActivity", "API response: " + response.body() as PostResponse)
                val postResponse: PostResponse = response.body() as PostResponse
                apiType = "POST"
                observablePostResponse.set(postResponse)
                setChanged()
                notifyObservers(postResponse)
            }

            UrlRequest.EMPDETAILS_GET -> {

                val empListData: List<GetResponse>? = response.body() as List<GetResponse>
                apiType = "GET"
                observablePostResponse.set(empListData)
                setChanged()
                notifyObservers(empListData)
            }

            UrlRequest.STATUS_URL -> {

                val statusData: List<Data>? = response.body() as List<Data>
                apiType = "POST"
                observablePostResponse.set(statusData)
                setChanged()
                notifyObservers(statusData)
            }


            else -> Log.i("MainActivity", "API condition Failes")

        }
    }

    fun getApiType() = apiType

    override fun onReceiveError(request: String, error: String) {
        Log.i("MainActivity", "API Error:" + error)
    }
}