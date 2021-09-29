package com.movv.admin.mapper

import com.movv.core.dto.MemberDTO
import com.movv.core.dto.MemberSearchDTO
import org.apache.ibatis.annotations.Mapper
import org.springframework.stereotype.Repository

@Mapper @Repository
interface AdminMemberMapper {
    fun getList(search: MemberSearchDTO):MutableList<MemberDTO>
    fun getCount(search:MemberSearchDTO):Long
}