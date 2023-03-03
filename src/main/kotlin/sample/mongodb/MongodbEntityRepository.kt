package sample.mongodb

import org.springframework.data.repository.CrudRepository

interface MongodbEntityRepository : CrudRepository<MongodbEntity, String>