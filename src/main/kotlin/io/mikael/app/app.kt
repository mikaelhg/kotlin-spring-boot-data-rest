package io.mikael.app

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
open class Application {

}

@RestController
class HelloController
    @Autowired constructor(val helloService: HelloService)
{

    @RequestMapping("/hello")
    fun index() = helloService.hello()

    @RequestMapping("/count")
    fun count() = helloService.count()

}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}
