package sample

import org.junit.jupiter.api.Test
import org.springframework.context.ApplicationContext
import sample.integration.IntegrationTest
import sample.mongodb.MongodbEntityRepository
import sample.mysql.MySQLEntityRepository
import sample.redis.RedisEntityRepository

@IntegrationTest
class SpringKotestSampleApplicationTests(
    private val ac: ApplicationContext
) {

    @Test
    fun contextLoads() {
    }

    @Test
    fun mysqlIntegrationTest() {
        println(ac.getBean(MySQLEntityRepository::class.java).findAll())
    }

    @Test
    fun mongodbIntegrationTest() {
        println(ac.getBean(MongodbEntityRepository::class.java).findAll())
    }

    @Test
    fun redisIntegrationTest() {
        println(ac.getBean(RedisEntityRepository::class.java).findAll())
    }
}
