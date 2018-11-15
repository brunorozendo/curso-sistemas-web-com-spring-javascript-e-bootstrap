package com.brunorozendo.brewer.controllers.converter

import spock.lang.Specification

import java.util.function.Predicate

class EstiloConverterTest extends Specification {

    def "test convert usando pelo spring"() {
        given: "criar object de Estilo"
        def a = new EstiloConverter()

        when: "executar metodo de conversao"
        def o = a.convert("10")

        then:" validar resultado da conversao"
        o.id == 10

    }

    def "test convert methodo interno retornado false"() {
        Predicate<String> validarValor = {
            false
        }
        given:
        def a = new EstiloConverter()

        when:
        def o = a.getEstilo(validarValor, null )

        then:
        o == null
    }

    def "test convert methodo interno retornado valido"() {
        Predicate<String> validarValor = {
            true
        }
        given:
        def a = new EstiloConverter()

        when:
        def o = a.getEstilo(validarValor, "10" )

        then:
        o.id == 10
    }

}
