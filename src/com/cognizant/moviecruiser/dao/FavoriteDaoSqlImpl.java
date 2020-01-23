package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.moviecruiser.model.Favorite;
import com.cognizant.moviecruiser.model.Movie;

public class FavoriteDaoSqlImpl implements FavoriteDao {

	@Override
	public void addFavorite(long userId, long movieId) {
		Connection con = ConnectionHandler.getConnection();

		try {
			String sql = "insert into favorite values(default,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, userId);

			ps.setLong(2, movieId);

			// System.out.println("userId: " + userId + " menuItemId: "

			// + menuItemId);

			ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			try {

				con.close();

			} catch (Exception e) {

				e.printStackTrace();

			}
		}

	}

	@Override
	public List<Movie> getAllFavorite(long userId) throws FavoriteEmptyException {
		Connection con = ConnectionHandler.getConnection();
		List<Movie> movieList = new ArrayList<Movie>();

		PreparedStatement ps;

		ResultSet resultSet;

		boolean active, hasTeaser;

		Movie movie = null;

		try {

			Favorite favorite = new Favorite();

			StringBuffer sqlBuffer = new StringBuffer();

			sqlBuffer

					.append("SELECT movie.m_id," + " movie.m_title  ," + " movie.m_boxoffice " + ",movie.m_active,"
							+ "movie.m_date_of_launch," + "movie.m_genre, " + "movie.m_has_teaser " + "FROM movie ")

					.append("INNER JOIN favorite ON movie.m_id = favorite.ft_pr_id WHERE favorite.ft_us_id = ?");

			ps = con.prepareStatement(sqlBuffer

					.toString());

			ps.setLong(1, userId);

			resultSet = ps.executeQuery();

			while (resultSet.next()) {

				int movieId = resultSet.getInt(1);

				String title = resultSet.getString(2);

				long boxoffice = resultSet.getLong(3);

				String isactive = resultSet.getString(4);

				Date date_of_launch = resultSet.getDate(5);

				String genre = resultSet.getString(6);

				String ishasTeaser = resultSet.getString(7);

				if (isactive != null && isactive.equals("Yes"))

					active = true;

				else

					active = false;

				if (ishasTeaser != null && ishasTeaser.equals("Yes"))

					hasTeaser = true;

				else

					hasTeaser = false;

				movie = new Movie(movieId, title, boxoffice,

						active, date_of_launch, genre,

						hasTeaser);

				movieList.add(movie);

			}

			favorite.setMovieList(movieList);

		} catch (SQLException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		} finally {

			try {

				con.close();

			} catch (SQLException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

		}

		if (movieList.size() == 0) {

			throw new FavoriteEmptyException("Favorite is Empty");

		}

		return movieList;

	}

	@Override
	public void deleteFavorite(long userId, long movieId) {

		Connection con = ConnectionHandler.getConnection();

		try {

			String sql = "delete from favorite where ft_us_id=? and  ft_pr_id=? limit 1";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setLong(1, userId);

			ps.setLong(2, movieId);

			ps.executeUpdate();

		} catch (SQLException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		} finally {

			try {

				con.close();

			} catch (SQLException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

		}
	}

}
