package io.mikael.app

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity @Table(name = "restaurants")
data class Restaurant(@Id @GeneratedValue var id: Long?,
                      var name: String?, var location: String?, var lat: Double?, var lng: Double?) {

    constructor() : this(null, null, null, null, null)

}

@Entity @Table(name = "menus")
data class Menu(@Id @GeneratedValue var id: Long?,
                var restaurantId: Long?, var date: LocalDate?, var text: String?) {

    constructor() : this(null, null, null, null)

}

@RepositoryRestResource(path = "restaurants")
public interface RestaurantRepository : JpaRepository<Restaurant, Long>

@RepositoryRestResource(path = "menus")
public interface MenuRepository : JpaRepository<Menu, Long>

