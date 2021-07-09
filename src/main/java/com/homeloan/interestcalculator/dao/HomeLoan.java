package com.homeloan.interestcalculator.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class HomeLoan {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private long id;
	private double rate;
	@NotNull(message="tenure can't be null")
	@Positive
	private double tenure;
	@NotNull(message="loanAmount can't be null")
	@Positive
	private double loanAmount;
	
}
