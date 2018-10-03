import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BankAccountTest {

    private static BankAccount bankAccount;

    @BeforeClass
    public static void init() {
        bankAccount = new BankAccount(11111, 0);
    }

    @Test
    public void verifyCreditAddAmountOnAccount() {
        bankAccount.set_balance(300);
        int initialBalance = bankAccount.get_balance();
        int addAmount =  100;
        int expectedBalance = initialBalance+addAmount;

        bankAccount.credit(addAmount);
        int updatedBalance = bankAccount.get_balance();

        writeMessage(updatedBalance, expectedBalance, "Verify Add "+addAmount+" to Balance");

        Assert.assertEquals(expectedBalance, updatedBalance);
    }

    @Test
    public void verifyDebitSubtractAmountFromAccountPositive() {
        bankAccount.set_balance(100);
        int initialBalance = bankAccount.get_balance();
        int subtractAmount = 50;
        int expectedBalance = initialBalance - subtractAmount;

        bankAccount.debit(subtractAmount);
        int updatedBalance = bankAccount.get_balance();

        writeMessage(updatedBalance, expectedBalance, "Verify subtract "+subtractAmount+" to Balance. Positive case, when amount is subtracted");

        Assert.assertEquals(expectedBalance, updatedBalance);
    }

    @Test
    public void verifyDebitSubtractAmountFromAccountNegative() {
        bankAccount.set_balance(100);
        int initialBalance = bankAccount.get_balance();
        int subtractAmount = 200;
        int expectedBalance = initialBalance; //as subtract amount is more than balance, than amount should not besubtracted

        bankAccount.debit(subtractAmount);
        int updatedBalance = bankAccount.get_balance();

        writeMessage(updatedBalance, expectedBalance, "Verify subtract "+subtractAmount+" to Balance. Negative case, when amount is not subtracted and message is written instead");

        Assert.assertEquals(expectedBalance, updatedBalance);
    }

    @AfterClass
    public static void close(){
        bankAccount = null;
    }

    private static void writeMessage (int act, int exp, String textMessage){
        System.out.println(textMessage);
        System.out.println("Actual  " + act);
        System.out.println("Expected  " + exp);
        System.out.println("\n");
    }

}