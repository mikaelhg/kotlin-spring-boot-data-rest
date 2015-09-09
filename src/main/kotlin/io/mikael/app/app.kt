package io.mikael.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.annotation.Import
import kotlin.platform.platformStatic as static

@SpringBootApplication
@Import(RepoConfiguration::class)
open public class Application {

    companion object Runner {
        static public fun main(args: Array<String>) {
            // Can't use Application::class because: Invalid source type class kotlin.reflect.jvm.internal.KClassImpl
            SpringApplicationBuilder(javaClass<Application>())
                    .registerShutdownHook(true)
                    .build()
                    .run(*args)
        }
    }

}
