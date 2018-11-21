package gameholic.model;

import java.util.Date;

public class ShoppingCart {
	private int shoppingCartId;
	private Accounts account;
	private Date created;
	public ShoppingCart(int shoppingCartId, Accounts account, Date created) {
		super();
		this.shoppingCartId = shoppingCartId;
		this.account = account;
		this.created = created;
	}
	public int getShoppingCartId() {
		return shoppingCartId;
	}
	public Accounts getAccount() {
		return account;
	}
	public Date getCreated() {
		return created;
	}
	public void setShoppingCartId(int shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}
	public void setAccount(Accounts account) {
		this.account = account;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
	

}
