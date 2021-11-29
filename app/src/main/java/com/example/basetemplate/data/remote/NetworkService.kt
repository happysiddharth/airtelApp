package com.example.basetemplate.data.remote

import com.example.basetemplate.data.model.Address
import com.example.basetemplate.data.model.ResponseData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {
    @GET(EndPoints.getAddress)
    fun getAddress(@Query("queryString") query: String,@Query("city")city:String):
            Observable<Address>
}