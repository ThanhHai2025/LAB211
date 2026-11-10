package model;

/**
 * Wallet class stores the amount of money that the buyer can use to pay for
 * bills.
 *
 * @version 10/11/2026
 * @author HaiNT
 */
public class Wallet {

    /**
     * The amount of money stored in the wallet.
     */
    private int amount;

    /**
     * Creates a Wallet object with the specified amount of money.
     *
     * @param amount amount of money in the wallet.
     */
    public Wallet(int amount) {
        this.amount = amount;
    }

    /**
     * Checks whether the buyer has enough money to pay for the bills.
     *
     * @param total the total amount of the bills.
     * @return true if the buyer's amount is greater than or equal to the total;
     * false otherwise.
     */
    public boolean payMoney(int total) {
        return this.amount >= total;
    }
}
