public class CalculatorTest {
	public static void main(String[] args){
		Calculator c = new Calculator();
		c.performOperation(10);
		c.performOperation("*");
		c.performOperation(2);
		c.performOperation("-");
		c.performOperation(5);
		c.performOperation("*");
		c.performOperation(7);
		c.performOperation("-");
		c.performOperation(5);
		c.performOperation("-");
		c.performOperation(5);
		c.performOperation("*");
		c.performOperation(5);
		c.performOperation("*");
		c.performOperation(5);
		c.performOperation("/");
		c.performOperation(5);
		c.performOperation("+");
		c.performOperation(20);
		c.performOperation("=");
		System.out.println(c.getResults());
	}
}