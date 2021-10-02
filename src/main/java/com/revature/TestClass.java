package com.revature;

import java.io.Console;

public class TestClass {
	public void passwordExample() {   
	Console console = System.console();
    if (console == null) {
        System.out.println("Couldn't get Console instance");
        System.exit(0);
    }

    console.printf("Testing password%n");
    char[] passwordArray = console.readPassword("Enter your secret password: ");
    console.printf("Password entered was: %s%n", new String(passwordArray));
    
	}
public static void main(String[] args) {
	new TestClass().passwordExample();
	/*
	 * SecureRandom rand = new SecureRandom();
	 * 
	 * // Generate random integers in range 0 to 999 int rand_int1 =
	 * rand.nextInt(1000000); int rand_int2 = rand.nextInt(1000);
	 * 
	 * // Print random integers System.out.println("Random Integers: " + rand_int1);
	 * System.out.println("Random Integers: " + rand_int2);
	 */
	
	

}


}

