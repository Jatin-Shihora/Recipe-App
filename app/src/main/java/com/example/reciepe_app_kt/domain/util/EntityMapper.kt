package com.example.reciepe_app_kt.domain.util

interface EntityMapper <Entity,DomainModel>{

    //takes domain or an entity object as input and output a domain model
    fun mapFromEntity(entity: Entity) : DomainModel

    //takes in a domain model and return an entity
    fun mapToEntity(domainModel: DomainModel) : Entity


}