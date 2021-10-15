package com.revature.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.dao.BalanceDAOImpl;

class CustomerPortalTest {
	public static Logger log = LoggerFactory.getLogger(CustomerPortalTest.class);
	public static BigDecimal bg = new BigDecimal(50);
	@Mock
	private static CustomerPortal ap;
	@Mock
	private static BalanceDAOImpl balDaoI;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		log.info("In test: Customer Portal SetupMOck ");
		ap = Mockito.mock(CustomerPortal.class);
		balDaoI = Mockito.mock(BalanceDAOImpl.class);
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	

	@Test
	void testWithdrawCash() {
		log.info("In test: Customer Portal testWithdrawCash ");
		
		when(ap.withdrawCash(bg)).thenReturn(true);
		assertEquals(true, ap.withdrawCash(bg));
	}

	@Test
	void testDeposit() {
		log.info("In test: Customer Portal testDeposit ");
		
		when(ap.Deposit(bg)).thenReturn(true);
		assertEquals(true, ap.Deposit(bg));
	}

	@Test
	void testTransfer() {
		log.info("In test: Customer Portal testTransfer ");
		
		when(ap.transfer(bg, 406)).thenReturn(true);
		assertEquals(true, ap.transfer(bg, 406));
	}
	@AfterAll
	static void setUpAllClass() throws Exception {
		log.info("In test: Customer Portal setUpAfterAllClass ");
		ap = null;
		balDaoI = null;
	}

	
}
