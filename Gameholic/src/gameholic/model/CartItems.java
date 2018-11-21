package gameholic.model;

public class CartItems {
	private int cartItemId;
	private ShoppingCart shoppingCart;
	private int quantity;
	private Orders order;
	private double price;
	private Games game;
	public CartItems(int cartItemId, ShoppingCart shoppingCart, int quantity, Orders order, double price, Games game) {
		super();
		this.cartItemId = cartItemId;
		this.shoppingCart = shoppingCart;
		this.quantity = quantity;
		this.order = order;
		this.price = price;
		this.game = game;
	}
	public int getCartItemId() {
		return cartItemId;
	}
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}
	public int getQuantity() {
		return quantity;
	}
	public Orders getOrder() {
		return order;
	}
	public double getPrice() {
		return price;
	}
	public Games getGame() {
		return game;
	}
	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}
	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setGame(Games game) {
		this.game = game;
	}
	
	

}
