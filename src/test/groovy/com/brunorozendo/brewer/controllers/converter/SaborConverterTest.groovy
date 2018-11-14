package com.brunorozendo.brewer.controllers.converter

import com.brunorozendo.brewer.model.entity.Sabor
import spock.lang.Specification

import java.util.function.Predicate

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

    def "teste convert descricao"(){
        given:
        def a = new SaborConverter()

        when:
        def r = a.convert("FORTE")

        then:
        r.getDescricao() == "Forte"
    }


    def "test convert methodo interno false"() {
        Predicate<String> validarValor = {
            false
        }
        given:
        def a = new SaborConverter()

        when:
        def o = a.getSabor(validarValor, null )

        then:
        o == null
    }

    def "test convert methodo interno valido"() {
        Predicate<String> validarValor = {
            true
        }
        given:
        def a = new SaborConverter()

        when:
        def o = a.getSabor(validarValor, "FORTE" )

        then:
        o == Sabor.FORTE
    }

}
