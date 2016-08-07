package io.mikael.app

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
open class Application {

}

@RestController
class HelloController
    @Autowired constructor(val helloService: HelloService)
{

    @GetMapping("/hello")
    fun hello() = helloService.hello()

    @GetMapping("/count")
    fun count() = helloService.count()

}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}
