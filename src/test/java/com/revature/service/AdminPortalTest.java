package com.revature.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.dao.BalanceDAOImpl;

@ExtendWith(MockitoExtension.class)
class AdminPortalTest {
	public static BigDecimal bg = new BigDecimal(50);
	@Mock
	private static AdminPortal ap;
	@Mock
	private static BalanceDAOImpl balDaoI;

	@BeforeAll
	public static void setupMock() {
		ap = Mockito.mock(AdminPortal.class);
		balDaoI = Mockito.mock(BalanceDAOImpl.class);
	}

	@Test
	public void testMockCreation() {
		assertNotNull(ap);
		assertNotNull(balDaoI);
	}

	@Test
	void testWithdrawCash() {
		
		when(ap.withdrawCash(bg, 10, 10)).thenReturn(true);
		assertEquals(true, ap.withdrawCash(bg, 10, 10));
	}

	
	//public static Logger log = LoggerFactory.getLogger(AdminPortalTest.class);

	

	@Test
	void testTransfer() {
		when(ap.transfer(bg, 8, 8, 8)).thenReturn(true);
		assertEquals(true, ap.transfer(bg, 8, 8, 8));
	}
/*
	@Test
	void testDeposit() {
		fail("Not yet implemented");
	}

	@Test
	void testUpgrade() {
		fail("Not yet implemented");
	}

	@Test
	void testViewCustomerAccount() {
		fail("Not yet implemented");
	}
*/
}
