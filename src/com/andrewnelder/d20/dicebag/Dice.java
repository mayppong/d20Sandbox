package com.andrewnelder.d20.dicebag;

import java.util.Random;

public class Dice {
	
	protected boolean isNegative;
	protected int value;
	protected int multiplier;
	protected String comment;
	protected Random generator;
	
	public Dice (int value, int multiplier, String comment) {
		this.value 				= value;
		this.multiplier 		= multiplier;
		this.comment 			= comment;
		this.generator			= new Random();
		this.isNegative 		= false;
	}
	
	public Dice (int value, int multiplier) {
		this(value, multiplier, "");
	}
	
	public Dice (int value) {
		this(value, 1);
	}
	
	public Dice positive() {
		this.isNegative = false;
		return this;
	}
	
	public Dice negative() {
		this.isNegative = true;
		return this;
	}
	
	public int executeRoll() {
		int sum = 0;
		for (int i = 0; i < this.multiplier; i++) {
			final int res = generator.nextInt(this.value) + 1;
			System.err.println("Rolling d"+this.value+((!this.comment.isEmpty()) ? " ["+this.comment+"]" : "")+" #"+(i+1)+" -- "+res);
			sum += res;
		}
		return (this.isNegative) ? -1*sum : sum;
	}
	
}
