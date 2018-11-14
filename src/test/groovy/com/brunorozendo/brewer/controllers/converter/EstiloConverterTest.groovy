package com.brunorozendo.brewer.controllers.converter

import spock.lang.Specification

class EstiloConverterTest extends Specification {

    def "Convert"() {
        given:
        def a = new EstiloConverter()

        when:
        def o = a.convert("10")


        then:
        o.id == 10

    }
}
