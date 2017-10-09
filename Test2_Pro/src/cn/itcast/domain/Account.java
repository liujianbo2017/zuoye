package cn.itcast.domain;

public class Account {
	private int id;
	private String username;
	private String cardid;
	private double balance;
	private double moneyRate;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(int id, String username, String cardid, double balance, double moneyRate) {
		super();
		this.id = id;
		this.username = username;
		this.cardid = cardid;
		this.balance = balance;
		this.moneyRate = moneyRate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCardid() {
		return cardid;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getMoneyRate() {
		return moneyRate;
	}

	public void setMoneyRate(double moneyRate) {
		this.moneyRate = moneyRate;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", cardid=" + cardid + ", balance=" + balance
				+ ", moneyRate=" + moneyRate + ", aid="+ "]";
	}

}
