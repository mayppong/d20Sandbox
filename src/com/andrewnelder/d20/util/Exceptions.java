package com.andrewnelder.d20.util;

public class Exceptions {
	public static class AttributeNotFoundException extends Exception {
		
		private static final long serialVersionUID = 8753832483972881875L;
		String mistake;
		
		public AttributeNotFoundException(String err) {
			super();
			mistake = err;
		}
		
		public AttributeNotFoundException() {
			this("Unknown");
		}
		
	}
}
