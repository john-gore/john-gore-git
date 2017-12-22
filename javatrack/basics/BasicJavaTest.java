public class BasicJavaTest {
	public static void main(String[] args){
        BasicJava basics = new BasicJava();

        basics.oneToTwoFiftyFive();
        basics.oddNumbersTwoFiftyFive();
        basics.printSum();
        int[] myArray = {1, 3, 5, 7, 9, 13};
        basics.iteratingThroughArray(myArray);
        basics.findMax(myArray);
        basics.getAverage(myArray);
        basics.arrayOfOdds();
        basics.greaterThanY(myArray, 5);
        basics.squareValues(myArray);
        int[] myArray2 = {1, 5, 10, -2};
        basics.eliminateNegatives(myArray2);
        basics.maxMinAvg(myArray2);
        int[] myArray3 = {1, 5, 10, 7, -2};
        basics.arrayShift(myArray3);
    }
}