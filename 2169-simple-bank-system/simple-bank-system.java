class Bank {

    private long[] balance;  // Array to store balances of accounts

    public Bank(long[] balance) {
        this.balance = balance;
    }
    
    // Helper function to check if account number is valid
    private boolean isValidAccount(int account) {
        return account >= 1 && account <= balance.length;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        // Validate accounts
        if (!isValidAccount(account1) || !isValidAccount(account2)) return false;
        // Check sufficient balance
        if (balance[account1 - 1] < money) return false;

        // Perform transfer
        balance[account1 - 1] -= money;
        balance[account2 - 1] += money;
        return true;
    }
    
    public boolean deposit(int account, long money) {
        // Validate account
        if (!isValidAccount(account)) return false;

        // Deposit money
        balance[account - 1] += money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        // Validate account
        if (!isValidAccount(account)) return false;
        // Check sufficient balance
        if (balance[account - 1] < money) return false;

        // Withdraw money
        balance[account - 1] -= money;
        return true;
    }
}
