package sample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringKotestSampleApplication

fun main(args: Array<String>) {
    runApplication<SpringKotestSampleApplication>(*args)
}
