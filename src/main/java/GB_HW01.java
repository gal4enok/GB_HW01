import java.util.*;

public class GB_HW01 {

    public static void printArray(int[] array){
        for (int element: array){
            System.out.print(element+ " ");
        }
        System.out.println("\n");
    }

    public static void sortArrayBubble (int[] array) {
        int x;
        for (int i = array.length; i >=0; i--)
            for (int j = 0; j < array.length-1; j++)
                if (array[j]>array[j+1]) {
                    x = array[j];
                    array[j] = array[j+1];
                    array[j+1] = x;
                }

        printArray(array);
    }

    public static void main(String[] args) {
        // Task 1: create random 15 int array [0:9]. Print array. count even elements and print out amount of even elements
        int arrayLength = 15;
        int[] randomNumbers= new int[arrayLength];

        Random generator = new Random();

        for (int i = 0; i<arrayLength; i++) {
            randomNumbers[i] = (generator.nextInt(9));
        }
        //print random array
        System.out.println("Random Array:");
        printArray(randomNumbers);


        //count even numbers
        int countEvenNumbers = 0;
        for (int i = 0; i<arrayLength; i++){
            if (randomNumbers[i]%2==0)countEvenNumbers+=1;
        }
        System.out.println("Amount of even numbers: " + countEvenNumbers+"\n");

        //Task2: sort array
        System.out.println("Sorted Array:");
        sortArrayBubble(randomNumbers);

        //Task4: create new BankAccount, check credit, debit
        BankAccount bankAccountTest = new BankAccount(111111, 100);
        bankAccountTest.credit(500);
        System.out.println("Bank Amount after adding 500: " + bankAccountTest.get_balance());

        bankAccountTest.debit(300);
        System.out.println("Bank Amount after decrease 300: " + bankAccountTest.get_balance());

        bankAccountTest.debit(500);
    }

}