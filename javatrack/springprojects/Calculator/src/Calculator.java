
public class Calculator {
	private double operandOne;
	private double operandTwo;
	private double result;
	private String operation;

	public double getOperandOne() {
		return operandOne;
	}

	public void setOperandOne(double operandOne) {
		this.operandOne = operandOne;
	}

	public double getOperandTwo() {
		return operandTwo;
	}

	public void setOperandTwo(double operandTwo) {
		this.operandTwo = operandTwo;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public void performOperation() {
		if(operation.equals("+")){
			result = operandOne + operandTwo;
		} else if(operation.equals("-")){
			result = operandOne - operandTwo;
		} else {
			System.out.println("Invalid Operation");
			result = 0;
		}
	}

	public double getResults() {
		return result;
	}
}
