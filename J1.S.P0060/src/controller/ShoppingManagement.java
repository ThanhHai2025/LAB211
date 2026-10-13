package controller;

import java.util.Scanner;
import model.Person;
import model.Wallet;

/**
 * ShoppingManagement class processing the value user entered, calculate total
 * of bills, compare the amount of wallet and display result user can or can not
 * buy it.
 *
 * @version 13/10/2026
 * @author HaiNT
 */
public class ShoppingManagement {

    private Scanner scanner = new Scanner(System.in);

    public void display() {
        System.out.println("====== Shopping program ======");

        //Step 1: Entered number of the bills.
        System.out.print("Input number of bill: ");
        int n = scanner.nextInt();

        int[] bills = new int[n];
        //Step 2: User entered value for each bills.
        for (int i = 0; i < n; i++) {
            System.out.print("Input value of bill " + (i + 1) + ": ");
            bills[i] = scanner.nextInt();
        }
        //Step 3: Entered amount in wallet.
        System.out.print("Input value of wallet: ");
        int amount = scanner.nextInt();

        //Step:  Processing calculate total bills.
        int total = calcTotal(bills);
        Wallet wallet = new Wallet(amount);
        Person person = new Person(wallet);

        //Step 5:  Display the result
        System.out.println("This is total of bill: " + total);
        if (person.getWallet().payMoney(total)) {
            System.out.println("You can buy it.");
        } else {
            System.out.println("You can't buy it.");
        }
    }

    /**
     * Function calculate total of the bills.
     *
     * @param bills the bills
     * @return total
     */
    private int calcTotal(int[] bills) {
        int total = 0;
        for (int bill : bills) {
            total += bill;
        }
        return total;
    }
}
