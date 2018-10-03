import org.junit.*;

public class CalculatorTest {
        public static final int firstPositiveNumber = 10;
        public static final int secondPositiveNumber = 5;

        private Calculator calculator;

    @BeforeClass
    public void init() {
        calculator = new Calculator();
         }

    @Test
    public void verifyAddTwoPositiveNumbers() {
        int expected = 15;
        calculator.setFirstNumber(firstPositiveNumber);
        calculator.setSecondNumber(secondPositiveNumber);
        int actual = calculator.addNumbers();

        writeMessage(actual, expected, "Verify Add 2 positive Numbers");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void verifyDivisionTwoPositiveNumbers() {
        int expected = 2;
        calculator.setFirstNumber(firstPositiveNumber);
        calculator.setSecondNumber(secondPositiveNumber);
        int actual = calculator.divideNumbers();

        writeMessage(actual, expected, "Verify division of 2 positive Numbers");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void verifyMultiplyTwoPositiveNumbers() {
        int expected = 50;
        calculator.setFirstNumber(firstPositiveNumber);
        calculator.setSecondNumber(secondPositiveNumber);
        int actual = calculator.multiplyNumbers();

        writeMessage(actual, expected, "Verify multiply 2 positive Numbers");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void verifyAddTwoNegativeNumbers() {
        int expected = -15;
        calculator.setFirstNumber(-firstPositiveNumber);
        calculator.setSecondNumber(-secondPositiveNumber);
        int actual = calculator.addNumbers();

        writeMessage(actual, expected, "Verify add 2 negative Numbers");

        Assert.assertEquals(expected, actual);
    }


    @AfterClass
    public void close(){
        calculator = null;
    }

    private static void writeMessage (int act, int exp, String textMessage){
        System.out.println(textMessage);
        System.out.println("Actual  " + act);
        System.out.println("Expected  " + exp);

    }


}
