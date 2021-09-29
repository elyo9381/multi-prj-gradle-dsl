package com.movv.core.dto


data class MemberDTO(var mbno:Int? = null) {
    var userId:String = ""
    var userPw:String? = null
    var name:String? = null
    var gender:String? = null
    var email:String? = null
    var tel:String? = null
}