package io.mikael.app

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import java.time.LocalDate
import javax.persistence.*
import javax.persistence.GenerationType.IDENTITY

@Entity @Table(name = "restaurants")
data class Restaurant(

    @Id @GeneratedValue(strategy = IDENTITY)
    var id: Long? = null,

    var name: String? = null,

    var location: String? = null,

    var lat: Double? = null,

    var lng: Double? = null,

    @OneToMany(mappedBy = "restaurant")
    var menus: List<Menu>? = null
)

@Entity @Table(name = "menus")
data class Menu(

    @Id @GeneratedValue(strategy = IDENTITY)
    var id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    var restaurant: Restaurant? = null,

    @Column(columnDefinition = "DATE")
    var date: LocalDate? = null,

    var title: String? = null,

    var text: String? = null
)

@RepositoryRestResource(path = "restaurants")
interface RestaurantRepository : JpaRepository<Restaurant, Long>

@RepositoryRestResource(path = "menus")
interface MenuRepository : JpaRepository<Menu, Long>
