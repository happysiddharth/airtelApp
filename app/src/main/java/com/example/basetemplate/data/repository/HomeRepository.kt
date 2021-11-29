package com.example.basetemplate.data.repository

import android.annotation.SuppressLint
import com.example.basetemplate.data.model.Address
import com.example.basetemplate.data.model.ResponseData
import com.example.basetemplate.data.remote.NetworkService
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomeRepository @Inject constructor(val networkService: NetworkService) {

    @SuppressLint("CheckResult")
    fun getAddresses(city:String): Observable<Address> {
        return networkService.getAddress("airtel",city)
    }
}