package com.movv.core.dto

data class MemberSearchDTO(var type:String? = null):SearchDTO() {
    var name:String? = null
    var userId:String? = null
    var role:String? = null
    var tel:String? = null
    var mbno:Int? = null
}