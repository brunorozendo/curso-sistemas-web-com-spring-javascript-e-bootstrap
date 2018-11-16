package com.brunorozendo.brewer.controllers.converter

import spock.lang.Specification

import java.util.function.Predicate

class EstiloConverterTest extends Specification {

    def "testa o metodo convert usado pelo spring"() {
        given: "criar object de Estilo"
        def a = new EstiloConverter()

        when: "executar metodo de conversao"
        def o = a.convert("10")

        then:" validar resultado da conversao: deve ser um objeto válido"
        o.id == 10

    }

    def "testa convert methodo interno:  retornado false"() {
        Predicate<String> validarValor = {
            false
        }
        given: "criar uma instância do 'EstiloConverter'"
        def a = new EstiloConverter()

        when: 'executar methodo de interno que faz a conversao'
        def o = a.getEstilo(validarValor, null )

        then: "restuldado deve ser nulll"
        o == null
    }

    def "test convert methodo interno retornado true"() {
        Predicate<String> validarValor = {
            true
        }
        given: "criar uma instância do 'EstiloConverter'"
        def a = new EstiloConverter()

        when:'executar methodo de interno que faz a conversao'
        def o = a.getEstilo(validarValor, "10" )

        then: "restuldado deve ser deve ser um objeto válido"
        o.id == 10
    }


    def "testando a lambda"() {
        given: "criar uma instância do 'EstiloConverter'"
        def a = new EstiloConverter()

        when: "recupera a lamda que faz a validação"
        def o = a.getStringPredicate()

        then:" tests usando a lambda"
        !o.test(null)
        o.test("10")
        !o.test("")
        !o.test("z")
    }

}
