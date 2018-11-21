package gameholic.model;

import java.util.HashMap;
import java.util.Map;

public class ShippingOptions {
	private Map<String, Boolean> shippingOptionMap;

	public ShippingOptions() {
		super();
		this.shippingOptionMap = new HashMap<>();
		shippingOptionMap.put("Ground", false);
		shippingOptionMap.put("Express", false);
		shippingOptionMap.put("Two Days", false);
		shippingOptionMap.put("One Day", false);
		
		
	}

	public Map<String, Boolean> getShippingOptionMap() {
		return shippingOptionMap;
	}

	public void setShippingOptionMap(Map<String, Boolean> shippingOptionMap) {
		this.shippingOptionMap = shippingOptionMap;
	}

}
