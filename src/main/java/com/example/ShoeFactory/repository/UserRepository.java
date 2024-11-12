package com.example.ShoeFactory.repository;

import com.example.ShoeFactory.entity.ShoeEntity;
import com.example.ShoeFactory.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    @Query("select u from UserEntity u where u.emailId = ?1")
    UserEntity findByEmailAddress(String emailId);

}
