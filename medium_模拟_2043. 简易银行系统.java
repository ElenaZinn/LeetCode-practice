//https://leetcode-cn.com/problems/simple-bank-system/
/**
用二维数组存？ num[account][balance]
 */
class Bank {
    private long[] balance;
    public Bank(long[] balance) {
        this.balance = balance;
    }
    //账户都存在才能转账
    public boolean transfer(int account1, int account2, long money) {
        if(account1 > balance.length ||account2 > balance.length) { //账户不存在
            return false;
        }
        if(balance[account1-1] >=money) { //额度充足
            balance[account2-1]  += money;
            balance[account1-1] -=money;
            return true;
        }else{
            return false;
        }
    }
    /**
    存款
     */
    public boolean deposit(int account, long money) {
        if(account > balance.length  ) { //账户不存在
            return false;
        }else{
            balance[account-1]  += money;
            return true;
        }
        
    }
    /**
    取款
     */
    public boolean withdraw(int account, long money) {
        if(account > balance.length  ) { //账户不存在
            return false;
        }else if(balance[account-1] < money) {//钱不够
            return false;
        }else {
            balance[account-1] -= money;
            return true;
        }
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */