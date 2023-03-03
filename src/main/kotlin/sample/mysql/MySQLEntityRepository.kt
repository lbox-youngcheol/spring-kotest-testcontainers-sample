package sample.mysql

import org.springframework.data.jpa.repository.JpaRepository

interface MySQLEntityRepository : JpaRepository<MySQLEntity, Long>