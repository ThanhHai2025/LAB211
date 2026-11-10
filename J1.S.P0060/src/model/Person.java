package model;

/**
 * Person class represents buyer who owns a wallet.
 *
 * @version 10/11/2026
 * @author HaiNT
 */
public class Person {

    /**
     * The wallet owned by the buyer
     */
    private Wallet wallet;

    /**
     * Creates a Person object with the specified wallet.
     *
     * @param wallet the wallet owned by the buyer
     */
    public Person(Wallet wallet) {
        this.wallet = wallet;
    }

    /**
     * Returns the wallet owned by the buyer.
     *
     * @return the wallet of the buyer
     */
    public Wallet getWallet() {
        return wallet;
    }
}
