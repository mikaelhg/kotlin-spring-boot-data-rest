package io.mikael.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.annotation.Import

@SpringBootApplication
@Import(RepoConfiguration::class)
open public class Application {

    companion object Runner {
        @JvmStatic
        public fun main(args: Array<String>) {
            SpringApplicationBuilder(Application::class.java)
                    .registerShutdownHook(true).build().run(*args)
        }
    }

}
