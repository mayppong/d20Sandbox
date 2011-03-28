package com.andrewnelder.d20.dicebag;

import java.util.ArrayList;
import java.util.Collection;

public class DiceRoller {
	
	/**
	 * Dice rolls are expected as +d10
	 * @param inputRoll
	 */
	public static int roll(Collection<Dice> diceBag) {
		int sum = 0;
		for (Dice dice : diceBag) {
			sum += dice.executeRoll();
		}
		System.err.println("Total --> "+sum);
		return sum;
	}
	
	public static void main(String[] args) {
		Collection<Dice> x = new ArrayList<Dice>();
		
		x.add(new Dice(3).positive());
		x.add(new Dice(10,30,"Drugs").negative());
		
		DiceRoller.roll(x);
	}
	
}
