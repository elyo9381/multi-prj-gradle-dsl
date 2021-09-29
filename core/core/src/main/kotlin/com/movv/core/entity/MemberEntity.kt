package com.movv.core.entity

import javax.persistence.*

@Entity
@Table(name = "members")
data class MemberEntity(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var mbno:Int? = null) {
    @Column(name="user_id", length = 200, nullable = false)var userId:String = ""
    @Column(name="user_pw", length = 100, nullable = false)var userPw:String? = null
    @Column(length = 50)var name:String? = null
    @Column(length = 5)var gender:String? = null
    @Column(length = 200)var email:String? = null
    @Column(length = 20)var tel:String? = null
}