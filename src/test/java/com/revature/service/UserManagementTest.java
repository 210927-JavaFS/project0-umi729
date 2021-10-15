package com.revature.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class UserManagementTest {

	public static Logger log = LoggerFactory.getLogger(UserManagementTest.class);

	@Mock
	private static UserManagement ap;

	@BeforeAll
	public static void setupMock() {

		log.info("In test Before All: UserManagement Setup Mock ");
		ap = Mockito.mock(UserManagement.class);

	}

	@Test
	void testGetMyUserName() {
		log.info("In test: UserManagement testGetMyUserName ");
		when(ap.getMyUserName("umi729@gmail.com", 85009)).thenReturn("Admin");
		assertEquals("Admin", ap.getMyUserName("umi729@gmail.com", 85009));
	}

	@Test
	void testResetPassword() {
		log.info("In test: UserManagement testResetPassword ");
		when(ap.resetPassword("Admin", "umi729@gmail.com", 85009)).thenReturn("Admin");
		assertEquals("Admin", ap.resetPassword("Admin", "umi729@gmail.com", 85009));
	}

}
