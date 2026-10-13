package main;

import controller.ShoppingManagement;

/**
 * Main class run ShoppingManagement program.
 *
 * @version 13/10/2026
 * @author HaiNT
 */
public class Main {

    public static void main(String[] args) {

        //Step 1: Initialize ShoppingManagement object.
        ShoppingManagement shoppingManagement = new ShoppingManagement();

        //Step 2: Run ShoppingManagement program.
        shoppingManagement.display();
    }
}
