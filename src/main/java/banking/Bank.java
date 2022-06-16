package banking;

import java.util.LinkedHashMap;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
	private static LinkedHashMap<Long, Account> accounts = new LinkedHashMap<Long, Account>();
	private static Long countOfAccounts = 0L;
	
	public Bank() {
		// complete the function
	}

	private Account getAccount(Long accountNumber) {
		// complete the function
        return accounts.get(accountNumber);
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		countOfAccounts++;
		CommercialAccount c =  new CommercialAccount(company, countOfAccounts, pin, startingDeposit);
		accounts.put(countOfAccounts, c);
        return countOfAccounts;
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		countOfAccounts++;
		ConsumerAccount c =  new ConsumerAccount(person, countOfAccounts, pin, startingDeposit);
		accounts.put(countOfAccounts, c);
        return countOfAccounts;
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		return getAccount(accountNumber).validatePin(pin);
    }

	public double getBalance(Long accountNumber) {
		// complete the function
		return accounts.get(accountNumber).getBalance();
	}

	public void credit(Long accountNumber, double amount) {
		getAccount(accountNumber).creditAccount(amount);
	}

	public boolean debit(Long accountNumber, double amount) {
		Account a = getAccount(accountNumber);
		return a.debitAccount(amount);
    }
}
