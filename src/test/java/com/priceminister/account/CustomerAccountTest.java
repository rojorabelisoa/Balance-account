package com.priceminister.account;


import static org.junit.Assert.*;

import org.junit.*;

import com.priceminister.account.implementation.*;


/**
 * Please create the business code, starting from the unit tests below.
 * Implement the first test, the develop the code that makes it pass.
 * Then focus on the second test, and so on.
 * 
 * We want to see how you "think code", and how you organize and structure a simple application.
 * 
 * When you are done, please zip the whole project (incl. source-code) and send it to recrutement-dev@priceminister.com
 * 
 */
public class CustomerAccountTest {
    
    Account customerAccount;
    AccountRule rule;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        customerAccount = new CustomerAccount();
        rule = new CustomerAccountRule();
        
    }
    
    /**
     * Tests that an empty account always has a balance of 0.0, not a NULL.
     */
    @Test
    public void testAccountWithoutMoneyHasZeroBalance() {
        assertEquals(0.0, customerAccount.getBalance(), 0.1);
    }
    
    /**
     * Adds money to the account and checks that the new balance is as expected.
     */
    @Test
    public void testAddPositiveAmount() {
    	customerAccount.add(50.0);
    	assertEquals(50.0, customerAccount.getBalance(), 0.1);
    }
    
    /**
     * Tests that an illegal withdrawal throws the expected exception.
     * Use the logic contained in CustomerAccountRule; feel free to refactor the existing code.
     * @throws IllegalBalanceException 
     */
    @Test(expected = IllegalBalanceException.class)
    public void testWithdrawAndReportBalanceIllegalBalance() throws IllegalBalanceException {
    	customerAccount.withdrawAndReportBalance(100.0, rule);
    }
    
    
    
    // Also implement missing unit tests for the above functionalities.
    @Test(expected = NullPointerException.class)
    public void testAddAccountWithNullValue() throws IllegalBalanceException {
    	customerAccount.add(null);
    }
    @Test(expected = NullPointerException.class)
    public void testWithdrawWithNullValue() throws IllegalBalanceException {
    	customerAccount.withdrawAndReportBalance(null, null);
    }
    @Test(expected = NullPointerException.class)
    public void testWithdrawWithNullValueFirstParam() throws IllegalBalanceException {
    	customerAccount.withdrawAndReportBalance(null, rule);
    }
    @Test(expected = NullPointerException.class)
    public void testWithdrawWithNullValueSecParam() throws IllegalBalanceException {
    	customerAccount.withdrawAndReportBalance(10.0, null);
    }
    
    
}
