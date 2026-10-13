package model;

/**
 * Wallet class stored amount that buyer use to pay the bills.
 *
 * @version 13/10/2026
 * @author HaiNT
 */
public class Wallet {

    /**
     * amount store money buyer have in wallet.
     */
    private int amount;

    /**
     * Construct and initialize amount object.
     *
     * @param amount amount of wallet
     */
    public Wallet(int amount) {
        this.amount = amount;
    }

    /**
     * payMoney check buyer have enough money to pay.
     *
     * @param total total of bills.
     * @return can buy if amount > total of bills.
     */
    public boolean payMoney(int total) {
        return this.amount >= total;
    }
}
