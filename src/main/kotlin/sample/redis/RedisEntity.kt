package sample.redis

import org.springframework.data.redis.core.RedisHash
import javax.persistence.Id

@RedisHash(value = "entity")
class RedisEntity {
    @Id
    val id: String? = null

    val name: String

    constructor(name: String) {
        this.name = name
    }
}