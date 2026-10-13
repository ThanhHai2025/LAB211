package model;

/**
 * Person class presents buyer who have wallet.
 *
 * @version 13/10/2026
 * @author HaiNT
 */
public class Person {

    private Wallet wallet;
// gọi theo kiểu tham chiếu, Người này sở hữu một cái Ví, và cái Ví đó có khả năng tự kiểm tra tiền
// lớp person không quan tâm cái ví hoạt động thế nào, chỉ cần hỏi cái ví này đủ tiền mua hay không thôi.

    public Person(Wallet wallet) {
        this.wallet = wallet;
    }
    
    public Wallet getWallet() {
        return wallet;
    }
}
