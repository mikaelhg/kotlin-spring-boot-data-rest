package io.mikael.app

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
open class HelloService
    @Autowired constructor(val restaurantRepository: RestaurantRepository)
{

    fun hello() = "Hello!"

    fun count() = restaurantRepository.count()

}
