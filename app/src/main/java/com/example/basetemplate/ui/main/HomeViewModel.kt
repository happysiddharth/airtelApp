package com.example.basetemplate.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.basetemplate.data.model.ResponseData
import com.example.basetemplate.data.repository.HomeRepository
import com.example.basetemplate.ui.base.BaseViewModel
import com.example.basetemplate.util.common.Event
import com.example.basetemplate.util.log.Logger
import com.mindorks.bootcamp.instagram.utils.network.NetworkHelper
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit

class HomeViewModel (networkHelper: NetworkHelper,
                     val homeRepository: HomeRepository,
                    val compositeDisposable: CompositeDisposable)
    : BaseViewModel(networkHelper,compositeDisposable) {


    val address :MutableLiveData<ResponseData> = MutableLiveData()
    private val searchObserver :PublishSubject<String> =  PublishSubject.create()

    override fun onCreate() {
        compositeDisposable.addAll(
            searchObserver
                .skip(1)
                .filter {
                    it.isNotEmpty()
                }
                .debounce(500,TimeUnit.MILLISECONDS)
                .distinctUntilChanged()
                .switchMap {name->
                    homeRepository
                        .getAddresses(name)
                }
                .subscribeOn(Schedulers.io())
                .subscribe ({
                        Logger.e("Androd",it.requestId)
                        address.postValue(it.data)
                },{
                    Logger.e("Android",it.fillInStackTrace().toString())
                })
        )

    }

    fun pushCity(city:String){
        searchObserver.onNext(city)
    }




}