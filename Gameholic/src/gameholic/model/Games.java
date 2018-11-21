package gameholic.model;

public class Games {
	private int gameId;
	private String intro;
	private boolean isOutOfStock;
	private int stockNumber;
	private String pictureUrl;
	private double price;
	
	public Games(int gameId, String intro, boolean isOutOfStock, int stockNumber, String pictureUrl, double price) {
		super();
		this.gameId = gameId;
		this.intro = intro;
		this.isOutOfStock = isOutOfStock;
		this.stockNumber = stockNumber;
		this.pictureUrl = pictureUrl;
		this.price = price;
	}
	public int getGameId() {
		return gameId;
	}
	public String getIntro() {
		return intro;
	}
	public boolean isOutOfStock() {
		return isOutOfStock;
	}
	public int getStockNumber() {
		return stockNumber;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public double getPrice() {
		return price;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public void setOutOfStock(boolean isOutOfStock) {
		this.isOutOfStock = isOutOfStock;
	}
	public void setStockNumber(int stockNumber) {
		this.stockNumber = stockNumber;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
