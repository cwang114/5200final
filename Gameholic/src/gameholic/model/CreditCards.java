package gameholic.model;

import java.util.Date;

public class CreditCards {
	private long cardNumber;
	private Date expiration;
	private Users user;
	public CreditCards(long cardNumber, Date expiration, Users user) {
		super();
		this.cardNumber = cardNumber;
		this.expiration = expiration;
		this.user = user;
	}
	public long getCardNumber() {
		return cardNumber;
	}
	public Date getExpiration() {
		return expiration;
	}
	public Users getUser() {
		return user;
	}
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	
	
	
	

}
