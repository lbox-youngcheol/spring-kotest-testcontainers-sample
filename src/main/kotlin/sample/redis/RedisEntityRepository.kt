package sample.redis

import org.springframework.data.repository.CrudRepository

interface RedisEntityRepository : CrudRepository<RedisEntity, String>