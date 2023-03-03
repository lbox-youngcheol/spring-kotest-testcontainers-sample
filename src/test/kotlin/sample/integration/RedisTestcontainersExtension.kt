package sample.integration

import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.Extension
import org.junit.jupiter.api.extension.ExtensionContext
import org.testcontainers.containers.GenericContainer

class RedisTestcontainersExtension : Extension, BeforeAllCallback {
    // @DynamicPropertySource, DynamicPropertyRegistry 을 사용하고 싶었지만
    // annotation 만을 사용한 테스트를 짤 때 동작하는 방법을 찾질 못해 우회하여 JUnit Extension을 사용하는 식으로 우회
    override fun beforeAll(context: ExtensionContext?) {
        if (redisContainer.isRunning) {
            return
        }

        redisContainer.start()
        System.setProperty("spring.redis.host", redisContainer.host)
        System.setProperty("spring.redis.port", redisContainer.firstMappedPort.toString())
    }

    companion object {
        private val redisContainer = GenericContainer<Nothing>("redis:6.2-alpine").apply {
            withReuse(true) // to speed up container startup
            withExposedPorts(6379)
        }
    }
}