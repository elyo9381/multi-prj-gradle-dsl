package com.movv.core.mapstruct

import com.movv.core.dto.MemberDTO
import com.movv.core.entity.MemberEntity
import org.mapstruct.*
import org.springframework.stereotype.Component

@Mapper(componentModel = "spring") @Component
interface MemberMapStruct : EntityMapper<MemberEntity, MemberDTO> {

    override fun toEntity(dto: MemberDTO): MemberEntity

    @InheritInverseConfiguration
    override fun toDTO(entity: MemberEntity): MemberDTO

}