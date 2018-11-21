package gameholic.model;

import java.util.HashMap;
import java.util.Map;

public class OrderStatus {
	private Map<String, Boolean> orderStatusMap;

	public OrderStatus() {
		super();
		this.orderStatusMap = new HashMap<>();
		orderStatusMap.put("New Order", false);
		orderStatusMap.put("Hold", false);
		orderStatusMap.put("Shipped", false);
		orderStatusMap.put("Delievered", false);
		orderStatusMap.put("Cancelled", false);

		
	}

	public Map<String, Boolean> getOrderStatusMap() {
		return orderStatusMap;
	}

	public void setOrderStatusMap(Map<String, Boolean> orderStatusMap) {
		this.orderStatusMap = orderStatusMap;
	}

}
