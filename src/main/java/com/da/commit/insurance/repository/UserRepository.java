package com.da.commit.insurance.repository;

import com.da.commit.insurance.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
* Repository class to access UserRepository Entity on database
*/

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * for findByNoTelp on database
     * @param findByPhoneNumber for findByPhoneNumber
     * @return response
     */

    @Query
    User findByPhoneNumber(@Param("findByPhoneNumber") String findByPhoneNumber);

    /**
     * for findByIdUSer on database
     * @param idUser for findIdUser
     * @return Integer
     */

    User findByIdUser(Integer idUser);

    /**
     * for findByPenghasilan on database
     * @param findByIncome for findByIncome
     * @return Integer
     */

    User findByIncome(@Param("findByIncome") Integer findByIncome);
}
