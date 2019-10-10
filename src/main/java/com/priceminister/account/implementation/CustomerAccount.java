package com.priceminister.account.implementation;

import java.math.BigDecimal;
import java.util.Objects;

import com.priceminister.account.Account;
import com.priceminister.account.AccountRule;
import com.priceminister.account.IllegalBalanceException;

public class CustomerAccount implements Account {
	private BigDecimal balance;


	public CustomerAccount() {
		super();
		this.balance = BigDecimal.ZERO;
	}

	public void add(Double addedAmount) {
		Objects.requireNonNull(addedAmount);
		balance = balance.add(BigDecimal.valueOf(addedAmount));
	}

	public Double getBalance() {
		return this.balance.doubleValue();
	}

	public Double withdrawAndReportBalance(Double withdrawnAmount, AccountRule rule) throws IllegalBalanceException {
		Objects.requireNonNull(withdrawnAmount);
		Objects.requireNonNull(rule);
		if (rule.withdrawPermitted(balance.doubleValue() - withdrawnAmount)) {
			balance =  balance.subtract(BigDecimal.valueOf(withdrawnAmount));
			return balance.doubleValue();
		}
		throw new IllegalBalanceException(withdrawnAmount);
	}

}
