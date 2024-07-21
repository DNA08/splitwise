package com.gupta.splitwise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gupta.splitwise.models.ExpenseOwningUser;

@Repository
public interface ExpenseOwningUserRepository extends JpaRepository<ExpenseOwningUser, Long> {

}
