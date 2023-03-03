package sample.mongodb

import org.springframework.data.mongodb.core.mapping.Document
import javax.persistence.Id

@Document
class MongodbEntity {
    @Id
    val id: String? = null

    val name: String

    constructor(name: String) {
        this.name = name
    }

    override fun toString(): String {
        return "MongodbEntity(id=$id, name='$name')"
    }
}