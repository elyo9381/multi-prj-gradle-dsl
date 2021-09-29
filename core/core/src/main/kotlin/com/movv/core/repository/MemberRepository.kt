package com.movv.core.repository

import com.movv.core.entity.MemberEntity
import org.springframework.data.repository.CrudRepository

interface MemberRepository : CrudRepository<MemberEntity,Int> {
}