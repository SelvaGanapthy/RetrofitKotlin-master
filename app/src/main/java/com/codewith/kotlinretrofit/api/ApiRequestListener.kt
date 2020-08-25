package com.codewith.kotlinretrofit.api

import okhttp3.Response

interface ApiRequestListener {
    fun onReceiveResult(ReqType: Int, response: Response): Unit
    fun onReceiveError(ReqType: Int, Error: String): Unit
}