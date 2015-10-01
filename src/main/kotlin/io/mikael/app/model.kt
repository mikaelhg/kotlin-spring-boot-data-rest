package io.mikael.app

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import java.time.LocalDate
import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity @Table(name = "restaurants")
data class Restaurant(@EmbeddedId var id: Key?,
                      var name: String?,
                      var location: String?,
                      var lat: Double?,
                      var lng: Double?)
{
    constructor() : this(null, null, null, null, null)
}

@Entity @Table(name = "menus")
data class Menu(@EmbeddedId var id: Key?,
                @ManyToOne var restaurant: Restaurant?,
                var date: LocalDate?,
                var text: String?)
{
    constructor() : this(null, null, null, null)
}

@RepositoryRestResource(path = "restaurants")
public interface RestaurantRepository : JpaRepository<Restaurant, Key>

@RepositoryRestResource(path = "menus")
public interface MenuRepository : JpaRepository<Menu, Key>
