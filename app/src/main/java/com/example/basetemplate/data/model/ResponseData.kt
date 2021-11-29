package com.example.basetemplate.data.model

data class ResponseData(
    val addressList: List<AddressX>?,
    val autoCompleteRequestString: String,
    val focusWord: String,
    val totalFindByRSUHits: Int,
    val totalNoRSUReturned: Int
)