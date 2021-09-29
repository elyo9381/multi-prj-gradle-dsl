package com.movv.core.dto

open class SearchDTO(var page:Int = 1, var limit:Int = 20) {

    constructor() : this(1, 20)
    var locale:String? = null
    val start get() = (page-1)*limit
    val startPage get() = (page-1)
}