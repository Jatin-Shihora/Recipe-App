package com.example.reciepe_app_kt.domain.util

interface DomainMapper <T,DomainModel>{

    //takes domain or an entity object as input and output a domain model
    fun mapToDomainModel(model: T) : DomainModel

    //takes in a domain model and return an entity
    fun mapFromDomainModel(domainModel: DomainModel) : T


}