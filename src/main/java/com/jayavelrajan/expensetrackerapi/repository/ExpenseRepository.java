package com.jayavelrajan.expensetrackerapi.repository;

import com.jayavelrajan.expensetrackerapi.entity.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    //SELECT * FROM tbl_expenses WHERE category= ?
    Page<Expense> findByCategory(String category, Pageable page);

    //SELECT * FROM tbl_expenses WHERE name LIKE '%keyword%'
    Page<Expense> findByNameContaining(String keyword, Pageable page);

    //SELECT * FROM tbl_expenses WHERE date BETWEEN 'startdate' and 'enddate'
    Page<Expense> findByDateBetween(Date startDate, Date endDate, Pageable page);

}
