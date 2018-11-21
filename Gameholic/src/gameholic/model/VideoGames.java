package gameholic.model;

public class VideoGames extends Games{
	private String title;
	private String console;
	private double USSales;
	private int yearReleased;
	private String publisher;
	private String developerName;
	private double averageRating;
	private int maxPlayers;
	private boolean isOnline;
	private boolean isLicensed;
	private String contentRating;
	private Genres genre;
	private Languages language;
	
	
	public VideoGames(int gameId, String intro, boolean isOutOfStock, int stockNumber, String pictureUrl, double price,
			String title, String console, double uSSales, int yearReleased, String publisher, String developerName,
			double averageRating, int maxPlayers, boolean isOnline, boolean isLicensed, String contentRating,
			Genres genre, Languages language) {
		super(gameId, intro, isOutOfStock, stockNumber, pictureUrl, price);
		this.title = title;
		this.console = console;
		this.USSales = uSSales;
		this.yearReleased = yearReleased;
		this.publisher = publisher;
		this.developerName = developerName;
		this.averageRating = averageRating;
		this.maxPlayers = maxPlayers;
		this.isOnline = isOnline;
		this.isLicensed = isLicensed;
		this.contentRating = contentRating;
		this.genre = genre;
		this.language = language;
	}
	public String getTitle() {
		return title;
	}
	public String getConsole() {
		return console;
	}
	public double getUSSales() {
		return USSales;
	}
	public int getYearReleased() {
		return yearReleased;
	}
	public String getPublisher() {
		return publisher;
	}
	public String getDeveloperName() {
		return developerName;
	}
	public double getAverageRating() {
		return averageRating;
	}
	public int getMaxPlayers() {
		return maxPlayers;
	}
	public boolean isOnline() {
		return isOnline;
	}
	public boolean isLicensed() {
		return isLicensed;
	}
	public String getContentRating() {
		return contentRating;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setConsole(String console) {
		this.console = console;
	}
	public void setUSSales(double uSSales) {
		USSales = uSSales;
	}
	public void setYearReleased(int yearReleased) {
		this.yearReleased = yearReleased;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public void setDeveloperName(String developerName) {
		this.developerName = developerName;
	}
	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}
	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}
	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}
	public void setLicensed(boolean isLicensed) {
		this.isLicensed = isLicensed;
	}
	public void setContentRating(String contentRating) {
		this.contentRating = contentRating;
	}
	
	public Genres getGenre() {
		return genre;
	}
	public Languages getLanguage() {
		return language;
	}
	public void setGenre(Genres genre) {
		this.genre = genre;
	}
	public void setLanguage(Languages language) {
		this.language = language;
	}

}
