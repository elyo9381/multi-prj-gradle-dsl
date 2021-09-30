package com.movv.admin.biz

import com.movv.admin.mapper.AdminMemberMapper
import com.movv.core.dto.MemberDTO
import com.movv.core.dto.MemberSearchDTO
import com.movv.core.mapstruct.MemberMapStruct
import com.movv.core.repository.MemberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class MemberBiz {


    @Autowired private lateinit var memberRepository: MemberRepository
    @Autowired private lateinit var memberMapStruct: MemberMapStruct
    @Autowired private lateinit var adminMemberMapper: AdminMemberMapper

    fun save(memberDTO: MemberDTO): ResponseEntity<Any> {
        val toEntity = memberMapStruct.toEntity(memberDTO)
        val save = memberRepository.save(toEntity)
        val toDTO = memberMapStruct.toDTO(save)
        return ResponseEntity.ok(hashMapOf("mode" to true, "data" to toDTO))
    }


    fun lists(search: MemberSearchDTO) : PageImpl<MemberDTO>{
        val pageRequest = PageRequest.of(search.startPage, search.limit)
        val list = adminMemberMapper.getList(search)
        val count = adminMemberMapper.getCount(search)
        return PageImpl(list, pageRequest, count)
    }

    fun delete(member:MemberDTO): ResponseEntity<Any> {
        val entity = memberMapStruct.toEntity(member)
        if( entity.mbno == null ) return ResponseEntity.ok( hashMapOf("mode" to false) )
        return try {
            entity.mbno?.let {
                memberRepository.deleteById(it)
            }
            ResponseEntity.ok(hashMapOf("mode" to true))
        }catch (e:Exception) {
            ResponseEntity.ok( hashMapOf("mode" to false, "msg" to e.message) )
        }
    }

}