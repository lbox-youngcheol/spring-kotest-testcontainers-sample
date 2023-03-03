package sample.mysql

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "mysql_entity")
class MySQLEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @Column
    val name: String

    constructor(name: String) {
        this.name = name
    }

    override fun toString(): String {
        return "MyEntity(id=$id, name='$name')"
    }
}