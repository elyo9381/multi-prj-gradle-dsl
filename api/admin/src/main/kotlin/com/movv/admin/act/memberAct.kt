package com.movv.admin.act

import com.movv.admin.biz.memberBiz
import com.movv.core.dto.MemberDTO
import com.movv.core.dto.MemberSearchDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageImpl
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/admin/member/")
class memberAct {


    @Autowired private lateinit var memberBiz: memberBiz

    @PostMapping("/list")
    fun list(@RequestBody search: MemberSearchDTO): PageImpl<MemberDTO> {
        return memberBiz.lists(search)
    }
    @PostMapping("/save")
    fun save(@RequestBody member: MemberDTO) = memberBiz.save(member)

    @PostMapping("/delete")
    fun delete(@RequestBody member: MemberDTO) = memberBiz.delete(member)

}