package com.example.basetemplate.ui.main.addresses

import com.example.basetemplate.data.model.Address
import com.example.basetemplate.data.model.AddressX
import com.example.basetemplate.ui.base.BaseItemViewModel
import com.example.basetemplate.ui.base.BaseViewModel
import com.mindorks.bootcamp.instagram.utils.network.NetworkHelper
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class AddressViewModel @Inject constructor(compositeDisposable: CompositeDisposable,networkHelper: NetworkHelper) :
    BaseItemViewModel<AddressX>(networkHelper,compositeDisposable){
    override fun onCreate() {
    }

}