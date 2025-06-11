package io.mikael.app

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource
interface RestaurantRepository : JpaRepository<Restaurant, Long>