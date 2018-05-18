package application;

public class Model {
	
	public static double calculate(double num1, double num2, String operator) {
		switch(operator) {
			case "-":
				return num1 - num2;
			case "*":
				return num1 * num2;
			case "+":
				return num1 + num2;
			case "/":
				if(num2 == 0) {
					return 0;
				} else {
					return num1 / num2;
				}
			case "pow":
				return Math.pow(num1,  num2);
			case "sqrt":
				return Math.sqrt(num1);
		}
		
		System.out.println("Operator unknown - " + operator);
		return 0;
	}
}
