package com.revature.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
/*import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
*/
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class TestValidationClass {

	public static ValidationClass vc;
	public static int i;
	public static int mn;
	public static int mx;
	public static boolean result; 
	
	// name of current class
	public static Logger log = LoggerFactory.getLogger(TestValidationClass.class);
	
	@BeforeAll
	public static void setValidationClass() {
		log.info("In setValidationClass");
		vc = new ValidationClass();
	}
	
	@BeforeEach
	public void setInts() {
		i = 2;
		mn = 1;
		mx = 4;
		log.info("In setInts");
	}
	
	@Test
	public void testvalidateIntInput() {
		log.info("In testvalidateIntInput");
		result = vc.validateIntInput(i,mn, mx);
		assertEquals(true, result);
	}
	
	/*
	 * @Test public void testSubtract() { log.info("In testSubtract."); result =
	 * mathUtil.subtract(i, j); assertTrue(result==2); }
	 * 
	 * @Test public void testDivideByZero() { log.info("In testDivideByZero");
	 * assertThrows(ArithmeticException.class, () -> mathUtil.divide(i,k)); }
	 *//*
		 * @Test public void testCommutativeAdd() { log.info("in testCommutativeAdd");
		 * assert
		 */
	/* Equals(mathUtil.add(i, j), mathUtil.add(j, i)); } */
	 
	//While so far we have been testing directly inputs and outputs it can often be more useful to test properties.
	//For example, addition has the commutative property. 
	/**/
	
	
	@AfterEach
	public void clearResult() {
		result = false;
		log.info("In clearResult");
	}
	
	@AfterAll 
	public static void clearMathUtil() {
		vc = null;
		log.info("in clearMathUtil");
	}
	

}

