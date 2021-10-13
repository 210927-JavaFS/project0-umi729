package com.revature.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ValidationClassTest {

	
//	//if you are using JUnit4 add in the @Test annotation, JUnit3 works without it.
//	//@Test
//	public void testGetFilter(){
//	    try {
//	        Expression myReturnedObject = getFilter("testString");
//	        assertNotNull(myReturnedObject); //check if the object is != null
//	        //check if the returned object is of class Expression.
//	        assertTrue(true, myReturnedObject instanceof Expression);
//	    } catch(Exception e){
//	        // let the test fail, if your function throws an Exception.
//	        fail("got Exception, i want an Expression");
//	     }
//	}
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testZipUS() {
		fail("Not yet implemented");
	}

	@Test
	void testIsValid() {
		fail("Not yet implemented");
	}

	@Test
	void testValidateDoubleInput() {
		fail("Not yet implemented");
	}

	@Test
	void testValidateIntInput() {
		fail("Not yet implemented");
	}

}
