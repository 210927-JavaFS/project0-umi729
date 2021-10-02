package com.revature;

import java.security.SecureRandom;

public class TestClass {
public static void main(String[] args) {
	SecureRandom rand = new SecureRandom();
	 
    // Generate random integers in range 0 to 999
    int rand_int1 = rand.nextInt(1000000);
    int rand_int2 = rand.nextInt(1000);

    // Print random integers
    System.out.println("Random Integers: " + rand_int1);
    System.out.println("Random Integers: " + rand_int2);
}
}
