package com.homeloan.interestcalculator.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestCalculatorDao extends JpaRepository<HomeLoan, Long> {

}
