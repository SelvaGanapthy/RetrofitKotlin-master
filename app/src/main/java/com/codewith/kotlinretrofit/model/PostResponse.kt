package com.codewith.kotlinretrofit.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


//data class PostResponse(val name: String, val salary: String, val age: String, val id: String)



data class PostResponse(var status: String, var data: Data)


//class PostResponse{

//@SerializedName("status")
//@Expose
//private var status: String? = null
//@SerializedName("data")
//@Expose
//private var data: Data? = null
//
//fun getStatus(): String? {
//    return status
//}
//
//fun setStatus(status: String) {
//    this.status = status
//}
//
//fun getData(): Data? {
//    return data
//}
//
//fun setData(data: Data) {
//    this.data = data
//}
//}