package io.mikael.app

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import java.time.LocalDate
import javax.persistence.*
import javax.persistence.GenerationType.IDENTITY

@Entity
@Table(name = "restaurants")
class Restaurant {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    var id: Long? = null

    var name: String? = null

    var location: String? = null

    var lat: Double? = null

    var lng: Double? = null

    @OneToMany(mappedBy = "restaurant")
    var menus: List<Menu>? = null

    override fun toString() = "Restaurant($id, $name, $location, $lat, $lng, ${menus?.map { it.id }})"

    override fun hashCode() = if (id == null) -999 else id!!.toInt()
}

@Entity
@Table(name = "menus")
class Menu {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    var id: Long? = null

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    var restaurant: Restaurant? = null

    @Column(name = "menu_date", columnDefinition = "DATE")
    var date: LocalDate? = null

    var title: String? = null

    @Column(name = "menu_text")
    var text: String? = null

    override fun toString() = "Menu($id, ${restaurant?.id}, $date, $title, $text)"

    override fun hashCode() = if (id == null) -999 else id!!.toInt()
}

@RepositoryRestResource
interface RestaurantRepository : JpaRepository<Restaurant, Long>

@RepositoryRestResource
interface MenuRepository : JpaRepository<Menu, Long>
