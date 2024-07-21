package com.gupta.splitwise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gupta.splitwise.models.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
