package sample.integration

import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.Extension
import org.junit.jupiter.api.extension.ExtensionContext
import org.testcontainers.containers.MySQLContainer

class MySQLTestcontainersExtension : Extension, BeforeAllCallback {
    // @DynamicPropertySource, DynamicPropertyRegistry 을 사용하고 싶었지만
    // annotation 만을 사용한 테스트를 짤 때 동작하는 방법을 찾질 못해 우회하여 JUnit Extension을 사용하는 식으로 우회
    override fun beforeAll(context: ExtensionContext?) {
        if (mysqlContainer.isRunning) {
            return
        }

        mysqlContainer.start()
        System.setProperty("spring.datasource.url", mysqlContainer.jdbcUrl)
        System.setProperty("spring.datasource.username", mysqlContainer.username)
        System.setProperty("spring.datasource.password", mysqlContainer.password)
    }

    companion object {
        private val mysqlContainer = MySQLContainer<Nothing>("mysql:5.7").apply {
            withReuse(true) // to speed up container startup
            withDatabaseName("lbox")
            withUsername("root")
            withPassword("root")
            withCreateContainerCmdModifier { cmd -> cmd.withPlatform("linux/x86_64") }
            withCommand("mysqld", "--character-set-server=utf8mb4")
        }
    }
}