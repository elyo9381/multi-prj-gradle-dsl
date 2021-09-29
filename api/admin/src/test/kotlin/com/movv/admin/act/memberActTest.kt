package com.movv.admin.act

import com.google.gson.JsonObject
import com.movv.admin.biz.memberBiz
import com.movv.core.dto.MemberDTO
import com.movv.core.repository.MemberRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.ComponentScan
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@WebMvcTest(memberAct::class)
internal class memberActTest {


    @Autowired
    private lateinit var mvc: MockMvc


    @InjectMocks
    private lateinit var memberBiz: memberBiz

    @Mock
    private lateinit var memberRepository: MemberRepository

    @BeforeEach
    fun setUp() {
        val memberDTO = MemberDTO().apply {
            this.userId = "testId"
            this.userPw = "testpw"
            this.name = "testwon"
            this.email = "test@mail.com"
            this.gender = "M"
            this.tel = "00011112222"
        }
    }

    @Test
    fun testMemberAct() {

        val memberDTO = MemberDTO().apply {
            this.userId = "testId"
            this.userPw = "testpw"
            this.name = "testwon"
            this.email = "test@mail.com"
            this.gender = "M"
            this.tel = "00011112222"
        }

        val save = memberBiz.save(memberDTO)


//        when (memberBiz.save(memberDTO)).thenReturn(memberDTO)


        mvc.perform(
            MockMvcRequestBuilders.post("/admin/member/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    JsonObject().apply {
                        this.addProperty("userId", "testId")
                        this.addProperty("userPw", "testpw")
                        this.addProperty("name", "testwon")
                        this.addProperty("email", "test@mail.com")
                        this.addProperty("gender", "M")
                        this.addProperty("tel", "00011112222")
                    }.toString()
                )
        ).andExpect(MockMvcResultMatchers.status().isOk)
    }
}
