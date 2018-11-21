package gameholic.model;

import java.util.Date;


public class Orders {
	private int orderId;
	private Users user;
	private Games game;
	private Date placeOrderDate;
	private String receiverName;
	private String shipAddress;
	private Date shippedDate;
	private String paymentMethod;
	private OrderStatus orderStatus;
	private ShippingOptions shippingOption;
	public Orders(int orderId, Users user, Games game, Date placeOrderDate, String receiverName, String shipAddress,
			Date shippedDate, String paymentMethod, OrderStatus orderStatus, ShippingOptions shippingOption) {
		super();
		this.orderId = orderId;
		this.user = user;
		this.game = game;
		this.placeOrderDate = placeOrderDate;
		this.receiverName = receiverName;
		this.shipAddress = shipAddress;
		this.shippedDate = shippedDate;
		this.paymentMethod = paymentMethod;
		this.orderStatus = orderStatus;
		this.shippingOption = shippingOption;
	}
	public int getOrderId() {
		return orderId;
	}
	public Users getUser() {
		return user;
	}
	public Games getGame() {
		return game;
	}
	public Date getPlaceOrderDate() {
		return placeOrderDate;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public String getShipAddress() {
		return shipAddress;
	}
	public Date getShippedDate() {
		return shippedDate;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	public ShippingOptions getShippingOption() {
		return shippingOption;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public void setGame(Games game) {
		this.game = game;
	}
	public void setPlaceOrderDate(Date placeOrderDate) {
		this.placeOrderDate = placeOrderDate;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}
	public void setShippedDate(Date shippedDate) {
		this.shippedDate = shippedDate;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	public void setShippingOption(ShippingOptions shippingOption) {
		this.shippingOption = shippingOption;
	}
	
	
	
	

}
