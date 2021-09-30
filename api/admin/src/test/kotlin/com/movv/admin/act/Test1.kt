//package com.movv.admin.act
//
//import com.google.gson.JsonObject
//import com.movv.admin.biz.MemberBiz
//import com.movv.core.dto.MemberDTO
//import com.movv.core.mapstruct.MemberMapStruct
//import com.movv.core.repository.MemberRepository
//import io.mockk.MockKException
//import io.mockk.every
//import io.mockk.impl.annotations.InjectMockKs
//import io.mockk.impl.annotations.MockK
//import io.mockk.junit5.MockKExtension
//import io.mockk.mockk
//import org.junit.jupiter.api.Assertions.assertEquals
//import org.junit.jupiter.api.Assertions.assertNull
//import org.junit.jupiter.api.BeforeEach
//import org.junit.jupiter.api.Test
//import org.junit.jupiter.api.extension.ExtendWith
//import org.mapstruct.factory.Mappers
//import org.mockito.junit.jupiter.MockitoExtension
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
//import org.springframework.boot.test.context.TestConfiguration
//import org.springframework.context.annotation.Bean
//import org.springframework.http.MediaType
//import org.springframework.http.ResponseEntity
//import org.springframework.test.context.junit.jupiter.SpringExtension
//import org.springframework.test.web.servlet.MockMvc
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers
//import org.springframework.test.web.servlet.setup.MockMvcBuilders
//
////@SpringBootTest
//@ExtendWith(SpringExtension::class)
//@WebMvcTest(MemberAct::class)
//internal class MemberActTest1 {
////
//    val memberMapStruct = Mappers.getMapper(MemberMapStruct::class.java)
//
//
//    @TestConfiguration
//    class ControllerTestConfig {
//        @Bean
//        fun memberBiz() = mockk<MemberBiz>()
//    }
//
//    @Autowired
//    private lateinit var mockMvc: MockMvc
//
//    @Autowired
//    private  lateinit var memberBiz: MemberBiz
//
//
//    @Test
//    fun `Spring context loaded`() {
//    }
//
////
////    @Test
////    fun testMemberAct() {
////
//        val memberDTO = MemberDTO().apply {
//            this.userId = "testId"
//            this.userPw = "testpw"
//            this.name = "testwon"
//            this.email = "test@mail.com"
//            this.gender = "M"
//            this.tel = "00011112222"
//        }
////
//
//
////
////        val toEntity = memberMapStruct.toEntity(memberDTO)
//////        every { memberRepository.save(toEntity) } returns toEntity
////        every { memberBiz.save(memberDTO) } returns ResponseEntity.ok(
////            hashMapOf(
////                "mode" to true,
////                "data" to memberDTO
////            )
////        )
////
////
//
//
//
////
////        mvc.perform(
////            MockMvcRequestBuilders.post("/admin/member/save")
////                .contentType(MediaType.APPLICATION_JSON)
////                .content(
////                    JsonObject().apply {
////                        this.addProperty("userId", "testId")
////                        this.addProperty("userPw", "testpw")
////                        this.addProperty("name", "testwon")
////                        this.addProperty("email", "test@mail.com")
////                        this.addProperty("gender", "M")
////                        this.addProperty("tel", "00011112222")
////                    }.toString()
////                )
////        ).andExpect(MockMvcResultMatchers.status().isOk)
////            .andReturn()
////    }
//}
