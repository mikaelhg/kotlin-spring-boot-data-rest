package io.mikael.app

import java.time.LocalDate
import jakarta.persistence.*
import jakarta.persistence.GenerationType.IDENTITY

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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Menu

        if (id != other.id) return false
        if (date != other.date) return false
        if (title != other.title) return false
        if (text != other.text) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (restaurant?.id?.hashCode() ?: 0)
        result = 31 * result + (date?.hashCode() ?: 0)
        result = 31 * result + (title?.hashCode() ?: 0)
        result = 31 * result + (text?.hashCode() ?: 0)
        return result
    }

}

