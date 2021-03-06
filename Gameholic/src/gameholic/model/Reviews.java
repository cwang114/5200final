package gameholic.model;

import java.util.Date;

public class Reviews {
	private int reviewId;
	private String content;
	private Date created;
	private int rating;
	private Games game;
	private Users user;
	public Reviews(int reviewId, String content, Date created, int rating, Games game, Users user) {
		super();
		this.reviewId = reviewId;
		this.content = content;
		this.created = created;
		this.rating = rating;
		this.game = game;
		this.user = user;
	}
	public int getReviewId() {
		return reviewId;
	}
	public String getContent() {
		return content;
	}
	public Date getCreated() {
		return created;
	}
	public int getRating() {
		return rating;
	}
	public Games getGame() {
		return game;
	}
	public Users getUser() {
		return user;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public void setGame(Games game) {
		this.game = game;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	
	

}
