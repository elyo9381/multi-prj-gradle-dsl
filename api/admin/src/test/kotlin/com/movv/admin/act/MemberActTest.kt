package com.movv.admin.act

import com.google.gson.JsonObject
import com.movv.admin.biz.MemberBiz
import com.movv.core.mapstruct.MemberMapStruct
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mapstruct.factory.Mappers
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@AutoConfigureMockMvc
@ExtendWith(MockKExtension::class)
internal class MemberActTest{


    val memberMapStruct = Mappers.getMapper(MemberMapStruct::class.java)

    @TestConfiguration
    class ControllerTestConfig {
        @Bean
        fun memberBiz() = mockk<MemberBiz>()
    }

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private  lateinit var memberBiz: MemberBiz


    @Test
    fun `Spring context loaded`() {
    }


    @Test
    fun `test`() {

        mockMvc.perform(
            MockMvcRequestBuilders.post("/admin/member/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
//                    JsonObject().apply {
//                        this.addProperty("userId", "testId")
//                        this.addProperty("userPw", "testpw")
//                        this.addProperty("name", "testwon")
//                        this.addProperty("email", "test@mail.com")
//                        this.addProperty("gender", "M")
//                        this.addProperty("tel", "00011112222")
//                    }.toString()
                )
        ).andExpect(MockMvcResultMatchers.status().isOk)
            .andReturn()

    }
}