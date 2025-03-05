import java.util.ArrayList;
import java.util.Arrays;

public class MyNumber {
    private int number = 2;
    private boolean[] booleanArray = new boolean[this.number + 1];
    private ArrayList<Integer> primesList = new ArrayList<>();

    MyNumber() {
    }

    MyNumber(int number) {
        this.setNumber(number);
    }

    public void setNumber(int number) {
        try {
            if (number < 2) {
                throw new IllegalArgumentException(
                        "\nNumber argument cannot be less than 2! If creating a new object, the number data member will default to 2.");
            } else {
                this.number = number;
                this.prepareArray();
                this.sievePrimeMethod(this.booleanArray);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /*
     * Creates a boolean array the size of the number + 1 to represent all integers.
     * The array is filled by default to true, all numbers are considered prime by
     * default.
     * Index 0 and 1, representing numbers 0 and 1, are set to false as these
     * numbers are never prime.
     * The array is returned.
     */
    private boolean[] prepareArray() {
        this.primesList.clear();
        this.booleanArray = new boolean[this.number + 1];
        Arrays.fill(booleanArray, true);
        booleanArray[0] = booleanArray[1] = false;
        return booleanArray;
    }

    /*
     * The Sieve algrothim loops through the array starting at index position 2,
     * finding all multiples up to the specified number.
     * All multiples are marked as false. All remaning index positions that are true
     * are prime numbers. Following the algorithim,
     * the result array is looped through again to count all positions that are true
     * and thus prime numbers. They are added to primesList array list.
     */
    private boolean[] sievePrimeMethod(boolean[] array) {
        for (int irreterator = 2; irreterator * irreterator <= this.number; irreterator++) {
            if (array[irreterator]) {
                for (int multiple = irreterator * irreterator; multiple <= this.number; multiple += irreterator) {
                    array[multiple] = false;
                }
            }
        }

        for (int index = 2; index <= this.number; index++) {
            if (array[index]) {
                this.primesList.add(index);
            }
        }
        return array;
    }

    public void printPrimeList() {
        System.out.println(this.primesList);
    }

    public int getNumber() {
        return this.number;
    }

    public Boolean isPrime() {
        return this.booleanArray[this.number];
    }

    public int numberOfPrimes() {
        return this.primesList.size();
    }
}
