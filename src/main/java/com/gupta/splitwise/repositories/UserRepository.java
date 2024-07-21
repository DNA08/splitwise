
package com.gupta.splitwise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gupta.splitwise.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
