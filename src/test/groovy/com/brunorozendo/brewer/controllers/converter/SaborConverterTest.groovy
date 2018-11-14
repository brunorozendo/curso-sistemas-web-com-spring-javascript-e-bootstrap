package com.brunorozendo.brewer.controllers.converter

import com.brunorozendo.brewer.model.entity.Sabor
import spock.lang.Specification

class SaborConverterTest extends Specification {

    def "teste convert valido"(){
        given:
        def a = new SaborConverter()

        when:
        def o = a.convert("FORTE")

        then:
        o == Sabor.FORTE
    }

    def "teste convert invalido"(){
        given:
        def a = new SaborConverter()

        when:
        a.convert("na")

        then:
        thrown IllegalArgumentException
    }

}
