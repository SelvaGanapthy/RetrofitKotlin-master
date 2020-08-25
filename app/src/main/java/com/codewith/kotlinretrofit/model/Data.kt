package com.codewith.kotlinretrofit.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Datas(
    var name: String,
    var salary: String,
    var age: String,
    var id: Int
)

class Data1 {

    @SerializedName("name")
    @Expose
    private var name: String? = null
    @SerializedName("salary")
    @Expose
    private var salary: String? = null
    @SerializedName("age")
    @Expose
    private var age: String? = null
    @SerializedName("id")
    @Expose
    private var id: Int? = null

    fun getName(): String? {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getSalary(): String? {
        return salary
    }

    fun setSalary(salary: String) {
        this.salary = salary
    }

    fun getAge(): String? {
        return age
    }

    fun setAge(age: String) {
        this.age = age
    }

    fun getId(): Int? {
        return id
    }

    fun setId(id: Int?) {
        this.id = id
    }


}

data class Data(var Status: String, var userId: String, var appversion: String)