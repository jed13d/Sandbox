package sandbox.utils;

import java.util.Arrays;

public class Primes {

	private boolean primesArray[];
	
	public Primes(int highest) {
		primesArray = new boolean[highest];
		Arrays.fill(primesArray, true);
	}// ==============================
	
	public void calculatePrimes() {
		primesArray[0] = primesArray[1] = false;
		
		// if the number is prime, iterate through all its multiples and make them false
		for(int i = 2; i < primesArray.length; i++) {
			if(primesArray[i]) {
				for(int j = 2; i * j < primesArray.length; j++) {
					primesArray[i*j] = false;
				}// ===== for
			}// ===== if
		}// ===== for
	}// ==============================
	
	public void report() {
		int ctr = 0;
		
		for(boolean p: primesArray) {
			if(p) ctr++;
		}// ===== for
		
		System.out.println("Number of primes under "+ primesArray.length +": "+ ctr);
	}// ==============================
}// ==============================
