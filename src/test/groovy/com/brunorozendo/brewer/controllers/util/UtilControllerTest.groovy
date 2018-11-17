package com.brunorozendo.brewer.controllers.util

import spock.lang.Specification

class UtilControllerTest extends Specification {

    def "teste modelAndView()"() {

        when:
        def util = new UtilController()

        then:
        util.modelAndView().viewName == "layout"
    }

    def "teste modelAndView(String)"() {
        given:
        def obj = "simpleText"
        def util = new UtilController()

        when:
        def result = util.modelAndView(obj)

        then:
        result.model['view'] == obj

    }

    def "teste redirect(String url)"() {
        given:
        def obj = "simpleText"
        def util = new UtilController()

        when:
        def result = util.redirect(obj)

        then:
        result.viewName == "redirect:${obj}"
    }

    def "teste addModel(String, Object)"() {
        given:
        def obj = "simpleText"
        def key = "sample"
        def util = new UtilController()

        when:
        util.addModel(key, obj)

        then:
        util.data[key] == obj

    }

}