package com.movv.admin.act

import com.google.gson.JsonObject
import com.movv.core.entity.MemberEntity
import com.movv.core.repository.MemberRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers


@AutoConfigureMockMvc
@SpringBootTest
internal class MemberActTest{



    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired()
    private  lateinit var memberRepository: MemberRepository


    @Test
    fun voidTest() {

        val toEntity = MemberEntity().apply {
            this.userId = "testId"
            this.userPw = "testpw"
            this.name = "testwon"
            this.email = "test@mail.com"
            this.gender = "M"
            this.tel = "00011112222"
        }


        val save = memberRepository.save(toEntity)

        Assertions.assertNotNull(save)
        Assertions.assertEquals("testId", save.userId)

    }


    @Test
    fun `test`() {

        mockMvc.perform(
            MockMvcRequestBuilders.post("/admin/member/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    JsonObject().apply {
                        this.addProperty("userId", "testId2")
                        this.addProperty("userPw", "testpw")
                        this.addProperty("name", "testwon")
                        this.addProperty("email", "test@mail.com")
                        this.addProperty("gender", "M")
                        this.addProperty("tel", "00011112222")
                    }.toString()
                )
        ).andExpect(MockMvcResultMatchers.status().isOk)
            .andReturn()

    }
}