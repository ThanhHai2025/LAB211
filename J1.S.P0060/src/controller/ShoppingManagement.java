package controller;

import java.util.Scanner;
import model.Person;
import model.Wallet;
import util.Validation;

/**
 * The ShoppingManagement class handles user input, calculates the total amount
 * of the bills, compares it with the wallet balance, and displays whether the
 * buyer can afford the purchase.
 *
 * @version 10/11/2026
 * @author HaiNT
 */
public class ShoppingManagement {

    /**
     * Validation object used to read and validate user input.
     */
    private Validation validation = new Validation();

    public void display() {
        System.out.println("====== Shopping program ======");

        //Step 1: Entered number of the bills.
        int n = validation.getInt("Input number of bill: ", 1);

        //Create an array to store the values of the bills.
        int[] bills = new int[n];

        //Step 2: User entered value for each bills.
        for (int i = 0; i < n; i++) {
            bills[i] = validation.getInt("Input value of bill " + (i + 1) + ": ", 0);
        }
        //Step 3: Entered amount of the wallet.
        int amount = validation.getInt("Input value of wallet: ", 0);

        //Step 4: Calculate the total amount of the bills.
        int total = calcTotal(bills);

        //Step 5: Create Wallet and Person objects.
        Wallet wallet = new Wallet(amount);
        Person person = new Person(wallet);

        //Step 7: Display the total amount of the bills.
        System.out.println("This is total of bill: " + total);

        //Step 8: Check whether the buyer has enough money to pay.
        if (person.getWallet().payMoney(total)) {
            System.out.println("You can buy it.");
        } else {
            System.out.println("You can't buy it.");
        }
    }

    /**
     * Calculate the total amount of all bills.
     *
     * @param bills the array of bill amounts.
     * @return total amount of the bills.
     */
    private int calcTotal(int[] bills) {
        int total = 0;
        //Calculate the total amount of all bills.
        for (int bill : bills) {
            total += bill;
        }
        return total;
    }
}
