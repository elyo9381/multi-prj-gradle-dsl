package com.movv.core.entity

import com.movv.core.CoreCoreApplication
import com.movv.core.dto.MemberDTO
import com.movv.core.mapstruct.MemberMapStruct
import com.movv.core.repository.MemberRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mapstruct.factory.Mappers
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DataJpaTest
internal class MemberEntityTest(){

    val memberMapStruct = Mappers.getMapper(MemberMapStruct::class.java)


    @Autowired
    private lateinit var memberRepository: MemberRepository

    @Test
    fun createMemberEntity(){

        val memberDTO = MemberDTO().apply {
            this.userId = "testId"
            this.userPw = "testpw"
            this.name = "testwon"
            this.email = "test@mail.com"
            this.gender = "M"
            this.tel = "00011112222"
        }

        val toEntity = memberMapStruct.toEntity(memberDTO)

        assertNotNull(toEntity)

        val save = memberRepository.save(toEntity)

        assertNotNull(save)
        assertEquals("testId",save.userId)
    }
}