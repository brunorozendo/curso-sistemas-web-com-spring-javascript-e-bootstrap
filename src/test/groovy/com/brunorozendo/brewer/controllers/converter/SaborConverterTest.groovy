package com.brunorozendo.brewer.controllers.converter

import com.brunorozendo.brewer.model.entity.Sabor
import spock.lang.Specification

import java.util.function.Predicate

class SaborConverterTest extends Specification {

    def "teste do converter retornado objeto válido valido"(){
        given:  "criar uma instância do 'SaborConverter'"
        def a = new SaborConverter()

        when: "executar metodo de conversao"
        def o = a.convert("FORTE")

        then: "o resultado é um objero valido"
        o == Sabor.FORTE
        o.getDescricao() == "Forte"
    }

    def "teste convert invalido"(){
        given:  "criar uma instância do 'SaborConverter'"
        def a = new SaborConverter()

        when: "executar metodo de conversao"
        def f = a.convert("na")

        then: "resultado deve ser null"
        f == null
    }


    def "test convert methodo interno false"() {
        Predicate<String> validarValor = {
            false
        }
        given:  "criar uma instância do 'SaborConverter'"
        def a = new SaborConverter()

        when:'executar methodo de interno que faz a conversao'
        def o = a.getSabor(validarValor, null )

        then: "resultado deve ser null"
        o == null
    }

    def "test convert methodo interno valido"() {
        Predicate<String> validarValor = {
            true
        }
        given:  "criar uma instância do 'SaborConverter'"
        def a = new SaborConverter()

        when:'executar methodo de interno que faz a conversao'
        def o = a.getSabor(validarValor, "FORTE" )

        then: "o resultado é um objero valido"
        o == Sabor.FORTE
    }

    def "test labmda"() {
        given:  "criar uma instância do 'SaborConverter'"
        SaborConverter a = new SaborConverter()

        when: "recupera a lambda que faz a validação"
        Predicate<String> o = a.getStringPredicate()

        then: "validação da lambda"
        o.test("FORTE")
        !o.test("")
        !o.test("vaiFalhar")
    }



    def "teste convert invalido lambda"(){
        given:  "criar uma instância do 'SaborConverter'"
        def a = new SaborConverter()
        Predicate<String> o = a.getStringPredicate()

        when: "Predicate<String> NÃO PODEM receber null como parametro"
        o.test(null)

        then: "resultado deve ser NullPointerException"
        notThrown()
    }


}
