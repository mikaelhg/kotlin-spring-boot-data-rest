package io.mikael.app

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController(val helloService: HelloService) {

    @GetMapping("/hello")
    fun hello() = helloService.hello()

    @GetMapping("/count")
    fun count() = helloService.count()

}