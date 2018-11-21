package gameholic.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gameholic.model.Games;
import gameholic.model.Genres;
import gameholic.model.Languages;
import gameholic.model.VideoGames;
// tODO: get list of videogames by genre, language and isOnline, licensed....
public class VideoGamesDao extends GamesDao{
	private static VideoGamesDao instance = null;
	protected VideoGamesDao() {
		super();
	}
	public static VideoGamesDao getInstance() {
		if(instance == null) {
			instance = new VideoGamesDao();
		}
		return instance;
	}
	
	public VideoGames create(VideoGames videoGame) throws SQLException {
		// Insert into the superclass table first.
		create(new Games(
				videoGame.getGameId(), 
				videoGame.getIntro(),
				videoGame.isOutOfStock(),
				videoGame.getStockNumber(),
				videoGame.getPictureUrl(),
				videoGame.getPrice()));

		String insertVideoGames = "INSERT INTO VideoGames(GameId, Title, Console, USSales, YearReleased, Publisher, DeveloperName, AverageRating, MaxPlayers, IsOnline, Licensed, ContentRating) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		GenresDao genresDao = GenresDao.getInstance();
		LanguagesDao languagesDao = LanguagesDao.getInstance();
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertVideoGames);
			insertStmt.setInt(1, videoGame.getGameId());
			insertStmt.setString(2, videoGame.getTitle());
			insertStmt.setString(3, videoGame.getConsole());
			insertStmt.setDouble(4, videoGame.getUSSales());
			insertStmt.setInt(5, videoGame.getYearReleased());
			insertStmt.setString(6, videoGame.getPublisher());
			insertStmt.setString(7, videoGame.getDeveloperName());
			insertStmt.setDouble(8, videoGame.getAverageRating());
			insertStmt.setInt(9, videoGame.getMaxPlayers());
			insertStmt.setBoolean(10, videoGame.isOnline());
			insertStmt.setBoolean(11, videoGame.isLicensed());
			insertStmt.setString(12, videoGame.getContentRating());

			Genres genre = videoGame.getGenre();
			genresDao.create(genre, videoGame.getGameId());
			
			Languages languages = videoGame.getLanguage();
			languagesDao.create(languages, videoGame.getGameId());
			
			insertStmt.executeUpdate();
			return videoGame;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(insertStmt != null) {
				insertStmt.close();
			}
		}
	}
	public VideoGames getVideoGameById(int videoGameId) throws SQLException{
		String selectVideoGame=
				"SELECT VideoGames.GameId AS GameId, Intro, IsOutOfStock, StockNumber, PictureURL, Price, "
				+ "Title, Console, USSales, YearReleased, Publisher, DeveloperName, AverageRating, MaxPlayers, IsOnline, Licensed, ContentRating " +
				"FROM VideoGames INNER JOIN Games " +
				"  ON VideoGames.GameId = Games.GameId " +
				"WHERE VideoGames.GameId=?;";
			Connection connection = null;
			PreparedStatement selectStmt = null;
			ResultSet results = null;
			GenresDao genresDao = GenresDao.getInstance();
			LanguagesDao languagesDao = LanguagesDao.getInstance();
			try {
				connection = connectionManager.getConnection();
				selectStmt = connection.prepareStatement(selectVideoGame);
				selectStmt.setInt(1, videoGameId);
				results = selectStmt.executeQuery();
				if(results.next()) {
					int resultGameId = results.getInt("GameId");
					String intro = results.getString("Intro");
					boolean isOutOfStock = results.getBoolean("IsOutOfStock");
					int stockNumber = results.getInt("StockNumber");
					String pictureUrl = results.getString("PictureURL");
					double price = results.getDouble("Price");
					
					String title = results.getString("Title");
					String console = results.getString("Console");
					double usSales = results.getDouble("USSales");
					int yearReleased = results.getInt("YearReleased");
					String publisher = results.getString("Publisher");
					String developerName = results.getString("DeveloperName");
					double averageRating = results.getDouble("AverageRating");
					int maxPlayers = results.getInt("MaxPlayers");
					boolean isOnline = results.getBoolean("IsOnline");
					boolean isLicensed = results.getBoolean("Licensed");
					String contentRating = results.getString("ContentRating");
					Genres genres = genresDao.getGenreById(videoGameId);
					Languages languages = languagesDao.getLanguageById(videoGameId);
					
					
					VideoGames videoGame = 
							new VideoGames(resultGameId, intro, isOutOfStock, stockNumber, pictureUrl, price, title, console, usSales, 
									yearReleased, publisher, developerName, averageRating, maxPlayers, isOnline, isLicensed, contentRating, genres, languages);
					return videoGame;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			} finally {
				if(connection != null) {
					connection.close();
				}
				if(selectStmt != null) {
					selectStmt.close();
				}
				if(results != null) {
					results.close();
				}
			}
			return null;
	}
	
	public List<VideoGames> getVideoGamesByTitle(String title) throws SQLException{
		List<VideoGames> videoGames = new ArrayList<VideoGames>();
		String selectVideoGame=
				"SELECT VideoGames.GameId AS GameId, Intro, IsOutOfStock, StockNumber, PictureURL, Price, "
						+ "Title, Console, USSales, YearReleased, Publisher, DeveloperName, AverageRating, MaxPlayers, IsOnline, Licensed, ContentRating " +
						"FROM VideoGames INNER JOIN Games " +
						"  ON VideoGames.GameId = Games.GameId " +
						"WHERE VideoGames.Title=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		GenresDao genresDao = GenresDao.getInstance();
		LanguagesDao languagesDao = LanguagesDao.getInstance();
		
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectVideoGame);
			selectStmt.setString(1, title);
			results = selectStmt.executeQuery();
			while(results.next()) {
				int resultGameId = results.getInt("GameId");
				String intro = results.getString("Intro");
				boolean isOutOfStock = results.getBoolean("IsOutOfStock");
				int stockNumber = results.getInt("StockNumber");
				String pictureUrl = results.getString("PictureURL");
				double price = results.getDouble("Price");
				
				
				String console = results.getString("Console");
				double usSales = results.getDouble("USSales");
				int yearReleased = results.getInt("YearReleased");
				String publisher = results.getString("Publisher");
				String developerName = results.getString("DeveloperName");
				double averageRating = results.getDouble("AverageRating");
				int maxPlayers = results.getInt("MaxPlayers");
				boolean isOnline = results.getBoolean("IsOnline");
				boolean isLicensed = results.getBoolean("Licensed");
				String contentRating = results.getString("ContentRating");
				Genres genres = genresDao.getGenreById(resultGameId);
				Languages languages = languagesDao.getLanguageById(resultGameId);
				
				
				VideoGames videoGame = 
						new VideoGames(resultGameId, intro, isOutOfStock, stockNumber, pictureUrl, price, title, console, usSales, 
								yearReleased, publisher, developerName, averageRating, maxPlayers, isOnline, isLicensed, contentRating, genres, languages);
				videoGames.add(videoGame);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(selectStmt != null) {
				selectStmt.close();
			}
			if(results != null) {
				results.close();
			}
		}
		return videoGames;
	}
	
	public List<VideoGames> getVideoGamesByConsole(String console) throws SQLException{
		List<VideoGames> videoGames = new ArrayList<VideoGames>();
		String selectVideoGame=
				"SELECT VideoGames.GameId AS GameId, Intro, IsOutOfStock, StockNumber, PictureURL, Price, "
						+ "Title, Console, USSales, YearReleased, Publisher, DeveloperName, AverageRating, MaxPlayers, IsOnline, Licensed, ContentRating " +
						"FROM VideoGames INNER JOIN Games " +
						"  ON VideoGames.GameId = Games.GameId " +
						"WHERE VideoGames.Console=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		GenresDao genresDao = GenresDao.getInstance();
		LanguagesDao languagesDao = LanguagesDao.getInstance();
		
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectVideoGame);
			selectStmt.setString(1, console);
			results = selectStmt.executeQuery();
			while(results.next()) {
				int resultGameId = results.getInt("GameId");
				String intro = results.getString("Intro");
				boolean isOutOfStock = results.getBoolean("IsOutOfStock");
				int stockNumber = results.getInt("StockNumber");
				String pictureUrl = results.getString("PictureURL");
				double price = results.getDouble("Price");
				
				
				String title = results.getString("Title");
				double usSales = results.getDouble("USSales");
				int yearReleased = results.getInt("YearReleased");
				String publisher = results.getString("Publisher");
				String developerName = results.getString("DeveloperName");
				double averageRating = results.getDouble("AverageRating");
				int maxPlayers = results.getInt("MaxPlayers");
				boolean isOnline = results.getBoolean("IsOnline");
				boolean isLicensed = results.getBoolean("Licensed");
				String contentRating = results.getString("ContentRating");
				Genres genres = genresDao.getGenreById(resultGameId);
				Languages languages = languagesDao.getLanguageById(resultGameId);
				
				
				VideoGames videoGame = 
						new VideoGames(resultGameId, intro, isOutOfStock, stockNumber, pictureUrl, price, title, console, usSales, 
								yearReleased, publisher, developerName, averageRating, maxPlayers, isOnline, isLicensed, contentRating, genres, languages);
				videoGames.add(videoGame);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(selectStmt != null) {
				selectStmt.close();
			}
			if(results != null) {
				results.close();
			}
		}
		return videoGames;
	}
	public List<VideoGames> getVideoGamesByYearReleased(int yearReleased) throws SQLException{
		List<VideoGames> videoGames = new ArrayList<VideoGames>();
		String selectVideoGame=
				"SELECT VideoGames.GameId AS GameId, Intro, IsOutOfStock, StockNumber, PictureURL, Price, "
						+ "Title, Console, USSales, YearReleased, Publisher, DeveloperName, AverageRating, MaxPlayers, IsOnline, Licensed, ContentRating " +
						"FROM VideoGames INNER JOIN Games " +
						"  ON VideoGames.GameId = Games.GameId " +
						"WHERE VideoGames.YearReleased=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		GenresDao genresDao = GenresDao.getInstance();
		LanguagesDao languagesDao = LanguagesDao.getInstance();
		
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectVideoGame);
			selectStmt.setInt(1, yearReleased);
			results = selectStmt.executeQuery();
			while(results.next()) {
				int resultGameId = results.getInt("GameId");
				String intro = results.getString("Intro");
				boolean isOutOfStock = results.getBoolean("IsOutOfStock");
				int stockNumber = results.getInt("StockNumber");
				String pictureUrl = results.getString("PictureURL");
				double price = results.getDouble("Price");
				
				String title = results.getString("Title");
				String console = results.getString("Console");
				double usSales = results.getDouble("USSales");
				//int yearReleased = results.getInt("YearReleased");
				String publisher = results.getString("Publisher");
				String developerName = results.getString("DeveloperName");
				double averageRating = results.getDouble("AverageRating");
				int maxPlayers = results.getInt("MaxPlayers");
				boolean isOnline = results.getBoolean("IsOnline");
				boolean isLicensed = results.getBoolean("Licensed");
				String contentRating = results.getString("ContentRating");
				Genres genres = genresDao.getGenreById(resultGameId);
				Languages languages = languagesDao.getLanguageById(resultGameId);
				
				
				VideoGames videoGame = 
						new VideoGames(resultGameId, intro, isOutOfStock, stockNumber, pictureUrl, price, title, console, usSales, 
								yearReleased, publisher, developerName, averageRating, maxPlayers, isOnline, isLicensed, contentRating, genres, languages);
				videoGames.add(videoGame);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(selectStmt != null) {
				selectStmt.close();
			}
			if(results != null) {
				results.close();
			}
		}
		return videoGames;
	}
	
	public List<VideoGames> getVideoGamesByPublisher(String publisher) throws SQLException{
		List<VideoGames> videoGames = new ArrayList<VideoGames>();
		String selectVideoGame=
				"SELECT VideoGames.GameId AS GameId, Intro, IsOutOfStock, StockNumber, PictureURL, Price, "
						+ "Title, Console, USSales, YearReleased, Publisher, DeveloperName, AverageRating, MaxPlayers, IsOnline, Licensed, ContentRating " +
						"FROM VideoGames INNER JOIN Games " +
						"  ON VideoGames.GameId = Games.GameId " +
						"WHERE VideoGames.Publisher=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		GenresDao genresDao = GenresDao.getInstance();
		LanguagesDao languagesDao = LanguagesDao.getInstance();
		
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectVideoGame);
			selectStmt.setString(1, publisher);
			results = selectStmt.executeQuery();
			while(results.next()) {
				int resultGameId = results.getInt("GameId");
				String intro = results.getString("Intro");
				boolean isOutOfStock = results.getBoolean("IsOutOfStock");
				int stockNumber = results.getInt("StockNumber");
				String pictureUrl = results.getString("PictureURL");
				double price = results.getDouble("Price");
				
				String title = results.getString("Title");
				String console = results.getString("Console");
				double usSales = results.getDouble("USSales");
				int yearReleased = results.getInt("YearReleased");
				// String publisher = results.getString("Publisher");
				String developerName = results.getString("DeveloperName");
				double averageRating = results.getDouble("AverageRating");
				int maxPlayers = results.getInt("MaxPlayers");
				boolean isOnline = results.getBoolean("IsOnline");
				boolean isLicensed = results.getBoolean("Licensed");
				String contentRating = results.getString("ContentRating");
				Genres genres = genresDao.getGenreById(resultGameId);
				Languages languages = languagesDao.getLanguageById(resultGameId);
				
				
				VideoGames videoGame = 
						new VideoGames(resultGameId, intro, isOutOfStock, stockNumber, pictureUrl, price, title, console, usSales, 
								yearReleased, publisher, developerName, averageRating, maxPlayers, isOnline, isLicensed, contentRating, genres, languages);
				videoGames.add(videoGame);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(selectStmt != null) {
				selectStmt.close();
			}
			if(results != null) {
				results.close();
			}
		}
		return videoGames;
	}
	public List<VideoGames> getVideoGamesByDeveloper(String developerName) throws SQLException{
		List<VideoGames> videoGames = new ArrayList<VideoGames>();
		String selectVideoGame=
				"SELECT VideoGames.GameId AS GameId, Intro, IsOutOfStock, StockNumber, PictureURL, Price, "
						+ "Title, Console, USSales, YearReleased, Publisher, DeveloperName, AverageRating, MaxPlayers, IsOnline, Licensed, ContentRating " +
						"FROM VideoGames INNER JOIN Games " +
						"  ON VideoGames.GameId = Games.GameId " +
						"WHERE VideoGames.DeveloperName=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		GenresDao genresDao = GenresDao.getInstance();
		LanguagesDao languagesDao = LanguagesDao.getInstance();
		
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectVideoGame);
			selectStmt.setString(1, developerName);
			results = selectStmt.executeQuery();
			while(results.next()) {
				int resultGameId = results.getInt("GameId");
				String intro = results.getString("Intro");
				boolean isOutOfStock = results.getBoolean("IsOutOfStock");
				int stockNumber = results.getInt("StockNumber");
				String pictureUrl = results.getString("PictureURL");
				double price = results.getDouble("Price");
				
				String title = results.getString("Title");
				String console = results.getString("Console");
				double usSales = results.getDouble("USSales");
				int yearReleased = results.getInt("YearReleased");
				String publisher = results.getString("Publisher");
				//String developerName = results.getString("DeveloperName");
				double averageRating = results.getDouble("AverageRating");
				int maxPlayers = results.getInt("MaxPlayers");
				boolean isOnline = results.getBoolean("IsOnline");
				boolean isLicensed = results.getBoolean("Licensed");
				String contentRating = results.getString("ContentRating");
				Genres genres = genresDao.getGenreById(resultGameId);
				Languages languages = languagesDao.getLanguageById(resultGameId);
				
				
				VideoGames videoGame = 
						new VideoGames(resultGameId, intro, isOutOfStock, stockNumber, pictureUrl, price, title, console, usSales, 
								yearReleased, publisher, developerName, averageRating, maxPlayers, isOnline, isLicensed, contentRating, genres, languages);
				videoGames.add(videoGame);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(selectStmt != null) {
				selectStmt.close();
			}
			if(results != null) {
				results.close();
			}
		}
		return videoGames;
	}
	
	
		
	
	public VideoGames delete(VideoGames videoGame) throws SQLException {
		String deleteVideoGame = "DELETE FROM VideoGames WHERE GameId=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		GenresDao genresDao = GenresDao.getInstance();
		LanguagesDao languagesDao = LanguagesDao.getInstance();
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteVideoGame);
			deleteStmt.setInt(1, videoGame.getGameId());
			deleteStmt.executeUpdate();

			// Then also delete from the superclass.
			// Note: due to the fk constraint (ON DELETE CASCADE), we could simply call
			// super.delete() without even needing to delete from Administrators first.
			super.delete(videoGame);
			genresDao.delete(videoGame.getGameId());
			languagesDao.delete(videoGame.getGameId());
			
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(deleteStmt != null) {
				deleteStmt.close();
			}
		}
	}
}
