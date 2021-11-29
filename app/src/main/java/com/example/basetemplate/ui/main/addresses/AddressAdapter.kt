package com.example.basetemplate.ui.main.addresses

import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import com.example.basetemplate.R
import com.example.basetemplate.data.model.AddressX
import com.example.basetemplate.ui.base.BaseAdapter

class AddressAdapter(val list:ArrayList<AddressX>,lifecycle:Lifecycle) : BaseAdapter<AddressX,AddressViewHolder>(list,lifecycle){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_list,parent,false)
        return AddressViewHolder(view)
    }
}