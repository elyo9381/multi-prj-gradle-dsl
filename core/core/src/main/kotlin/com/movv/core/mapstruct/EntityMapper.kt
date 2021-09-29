package com.movv.core.mapstruct

interface EntityMapper<E, D> {
    fun toDTO(entity:E):D
    fun toEntity(dto:D):E
}