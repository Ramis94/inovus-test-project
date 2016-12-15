package ru.test.gramis.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.test.gramis.entity.Users;

import java.sql.SQLException;

/**
 * Created by GRamis on 12.12.2016.
 * Репозиторий для работы с БД
 */
@Repository
public interface UserRepository extends CrudRepository<Users, Long> {

    Users findUserByName(String name);

    //Select * From Users WHERE LOWER(name) LIKE 'ramis'

    @Query("SELECT u FROM Users u WHERE UPPER(name) LIKE UPPER(:name)")
    Users findUserWithoutRegister(@Param("name") String name);

}
