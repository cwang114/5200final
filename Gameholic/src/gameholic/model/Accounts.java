package gameholic.model;

import java.util.Date;

public class Accounts {
	private int accountId;
	private String billingAddress;
	private boolean isClosed;
	private Date createdAt;
	private Date closedAt;
	private boolean isPremium;
	private Users user;
	public Accounts(int accountId, String billingAddress, boolean isClosed, Date createdAt, Date closedAt,
			boolean isPremium, Users user) {
		super();
		this.accountId = accountId;
		this.billingAddress = billingAddress;
		this.isClosed = isClosed;
		this.createdAt = createdAt;
		this.closedAt = closedAt;
		this.isPremium = isPremium;
		this.user = user;
	}
	public int getAccountId() {
		return accountId;
	}
	public String getBillingAddress() {
		return billingAddress;
	}
	public boolean isClosed() {
		return isClosed;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public Date getClosedAt() {
		return closedAt;
	}
	public boolean isPremium() {
		return isPremium;
	}
	public Users getUser() {
		return user;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}
	public void setClosed(boolean isClosed) {
		this.isClosed = isClosed;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public void setClosedAt(Date closedAt) {
		this.closedAt = closedAt;
	}
	public void setPremium(boolean isPremium) {
		this.isPremium = isPremium;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	
	

}
