package com.revature.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.dao.BalanceDAOImpl;

@ExtendWith(MockitoExtension.class)
class AdminPortalTest {
	public static Logger log = LoggerFactory.getLogger(AdminPortalTest.class);
	public static BigDecimal bg = new BigDecimal(50);
	@Mock
	private static AdminPortal ap;
	@Mock
	private static BalanceDAOImpl balDaoI;

	@BeforeAll
	public static void setupMock() {
		log.info("In test: Admin Portal Setup MOck ");
		ap = Mockito.mock(AdminPortal.class);
		balDaoI = Mockito.mock(BalanceDAOImpl.class);
	}

	@Test
	public void testMockCreation() {
		log.info("In test: Admin Portal testMockCreation ");
		assertNotNull(ap);
		assertNotNull(balDaoI);
	}

	@Test
	void testWithdrawCash() {
		log.info("In test: Admin Portal testWithdrawCash ");
		
		when(ap.withdrawCash(bg, 10, 10)).thenReturn(true);
		assertEquals(true, ap.withdrawCash(bg, 10, 10));
	}

	
	@Test
	void testTransfer() {
		log.info("In test: Admin Portal testTransfer ");
		when(ap.transfer(bg, 8, 8, 8)).thenReturn(true);
		assertEquals(true, ap.transfer(bg, 8, 8, 8));
		
	}

	@Test
	void testDeposit() {
		log.info("In test: Admin Portal testUpgrade ");
		when(ap.Deposit(bg, 150, 299)).thenReturn(true);
		assertEquals(true, ap.Deposit(bg, 150, 299));
	}

	

	@Test
	void testViewCustomerAccount() {
		log.info("In test: Admin Portal testUpgrade ");
		when(ap.viewCustomerAccount("Umer", "Zahid", "umi729@gmail.com", 58585, "test")).thenReturn(true);
		assertEquals(true, ap.viewCustomerAccount("Umer", "Zahid", "umi729@gmail.com", 58585, "test"));
	}
	@AfterAll
	static void setUpAllClass() throws Exception {
		log.info("In test: Customer Portal setUpAfterAllClass ");
		ap = null;
		balDaoI = null;
	}

}
