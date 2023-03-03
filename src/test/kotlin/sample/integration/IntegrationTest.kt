package sample.integration

import io.kotest.core.config.AbstractProjectConfig
import io.kotest.core.listeners.Listener
import io.kotest.spring.SpringListener
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(
    MySQLTestcontainersExtension::class,
    MongodbIntegrationExtension::class,
    RedisTestcontainersExtension::class,
)
@ActiveProfiles("test")
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class IntegrationTest

/**
 * 통합 테스트를 위한 Kotest 설정
 */
object ProjectConfig : AbstractProjectConfig() {
    override fun listeners(): List<Listener> {
        return listOf(SpringListener) // Kotest-Spring 통합 설정
    }
}