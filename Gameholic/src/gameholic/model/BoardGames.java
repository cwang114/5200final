package gameholic.model;

public class BoardGames extends Games{
	private String title;
	private int minPlayer;
	private int maxPlayer;
	private int averageTime;
	private int yearReleased;
	private double ratingScore;
	private String mechanics;
	private String owned;
	private String theme;
	private String designerName;
	private double weight;
	public BoardGames(int gameId, String intro, boolean isOutOfStock, int stockNumber, String pictureUrl, double price,
			String title, int minPlayer, int maxPlayer, int averageTime, int yearReleased, double ratingScore,
			String mechanics, String owned, String theme, String designerName, double weight) {
		super(gameId, intro, isOutOfStock, stockNumber, pictureUrl, price);
		this.title = title;
		this.minPlayer = minPlayer;
		this.maxPlayer = maxPlayer;
		this.averageTime = averageTime;
		this.yearReleased = yearReleased;
		this.ratingScore = ratingScore;
		this.mechanics = mechanics;
		this.owned = owned;
		this.theme = theme;
		this.designerName = designerName;
		this.weight = weight;
	}
	public String getTitle() {
		return title;
	}
	public int getMinPlayer() {
		return minPlayer;
	}
	public int getMaxPlayer() {
		return maxPlayer;
	}
	public int getAverageTime() {
		return averageTime;
	}
	public int getYearReleased() {
		return yearReleased;
	}
	public double getRatingScore() {
		return ratingScore;
	}
	public String getMechanics() {
		return mechanics;
	}
	public String getOwned() {
		return owned;
	}
	public String getTheme() {
		return theme;
	}
	public String getDesignerName() {
		return designerName;
	}
	public double getWeight() {
		return weight;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setMinPlayer(int minPlayer) {
		this.minPlayer = minPlayer;
	}
	public void setMaxPlayer(int maxPlayer) {
		this.maxPlayer = maxPlayer;
	}
	public void setAverageTime(int averageTime) {
		this.averageTime = averageTime;
	}
	public void setYearReleased(int yearReleased) {
		this.yearReleased = yearReleased;
	}
	public void setRatingScore(double ratingScore) {
		this.ratingScore = ratingScore;
	}
	public void setMechanics(String mechanics) {
		this.mechanics = mechanics;
	}
	public void setOwned(String owned) {
		this.owned = owned;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public void setDesignerName(String designerName) {
		this.designerName = designerName;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	

}
