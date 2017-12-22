import java.util.ArrayList;

public class Calculator {
	private double result = 0;
	private ArrayList<Double> numbers = new ArrayList<Double>();
	private ArrayList<String> operations = new ArrayList<String>();
	private boolean divide = false;
	private boolean subtract = false;
 	
	public void performOperation(double num) {
		if(divide == true) {
			num = 1 / num;
		}
		
		if(subtract == true) {
			num = num * (-1);
		}
		numbers.add(new Double(num));
		divide = false;
		subtract = false;
	}

	public void performOperation(String operation) {
		if(operation.equals("/")) {
			operation = "*";
			divide = true;
		}
		
		if(operation.equals("-")) {
			operation = "+";
			subtract = true;
		}
		
		if(operation.equals("=")) {
			return;
		}
		
		operations.add(operation);
	}
	
	public static Double multiply(Double a, Double b) {
		return a * b;
	}
	
	public double getResults() {
		while(operations.indexOf("*") != -1) {
			int idx = operations.indexOf("*");
			double mult = multiply(numbers.get(idx), numbers.get(idx+ 1));
			numbers.set(idx, new Double(mult));
			numbers.remove(idx + 1);
			operations.remove(idx);		
		}
			
		for(Double num : numbers) {
			result += num;
		}
		
		return result;
	}
}