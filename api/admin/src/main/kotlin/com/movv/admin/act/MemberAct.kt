package com.movv.admin.act

import com.movv.admin.biz.MemberBiz
import com.movv.core.dto.MemberDTO
import com.movv.core.dto.MemberSearchDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageImpl
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/admin/member")
class MemberAct {
    @Autowired
    private lateinit var memberBiz: MemberBiz

    @PostMapping("/list")
    fun list(@RequestBody search: MemberSearchDTO): PageImpl<MemberDTO> {
        return memberBiz.lists(search)
    }

    @PostMapping("/save")
    fun save(@RequestBody member: MemberDTO): ResponseEntity<Any> {
        val save = memberBiz.save(member)
        return save
    }

    @PostMapping("/delete")
    fun delete(@RequestBody member: MemberDTO): ResponseEntity<Any> {
        return memberBiz.delete(member)
    }

}