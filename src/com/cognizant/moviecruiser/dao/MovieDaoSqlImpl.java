package com.cognizant.moviecruiser.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.moviecruiser.model.Movie;

import java.sql.Connection;

import java.sql.PreparedStatement;

public class MovieDaoSqlImpl implements MovieDao {

	public List<Movie> getMovieListAdmin() {
		List<Movie> movieList = new ArrayList<>();
		Movie mn;
		try {

			Connection con = ConnectionHandler.getConnection();

			PreparedStatement ps = con.prepareStatement("Select * from movie");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				long id = rs.getInt("m_id");

				String title = rs.getString("m_title");

				long boxoffice = rs.getLong("m_boxoffice");

				boolean active = false;

				if (rs.getString("m_active").equalsIgnoreCase("YES")) {

					active = true;

				}

				Date dateOfLaunch = rs.getDate("m_date_Of_Launch");

				String genre = rs.getString("m_genre");

				boolean has_teaser = false;

				if (rs.getString("m_has_teaser").equalsIgnoreCase("YES")) {

					has_teaser = true;

				}

				mn = new Movie(id, title, boxoffice, active, dateOfLaunch, genre, has_teaser);

				movieList.add(mn);

			}

		} catch (SQLException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

		return movieList;
	}

	public List<Movie> getMovieListCustomer() {

		List<Movie> al = new ArrayList<>();

		Movie m;

		try {

			Connection con = ConnectionHandler.getConnection();
			String sql = "Select * from movie where m_active='yes' and m_date_of_launch <= current_date()";
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				long id = rs.getInt("m_id");

				String title = rs.getString("m_title");

				long boxoffice = rs.getLong("m_boxoffice");

				boolean active = false;

				if (rs.getString("m_active").equalsIgnoreCase("YES")) {

					active = true;

				}

				Date dateOfLaunch = rs.getDate("m_date_of_launch");

				String genre = rs.getString("m_genre");

				boolean has_teaser = false;

				if (rs.getString("m_has_teaser").equalsIgnoreCase("YES")) {

					has_teaser = true;

				}
				m = new Movie(id, title, boxoffice, active, dateOfLaunch, genre, has_teaser);

				al.add(m);

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return al;

	}

	@Override
	public void modifyMovie(Movie movie) {

		Connection con = ConnectionHandler.getConnection();

		try {

			String sql = "update movie set m_title=?,m_boxoffice=?,m_active=?,m_date_of_launch=?,m_has_teaser=?,m_genre=? where m_id=?";

			PreparedStatement preparedStatement = con.prepareStatement(sql);

			preparedStatement.setString(1, movie.getTitle());

			preparedStatement.setLong(2, movie.getBoxOffice());

			if (movie.isActive()) {

				preparedStatement.setString(3, "Yes");

			} else {

				preparedStatement.setString(3, "No");

			}

			preparedStatement.setDate(4, new java.sql.Date(movie.getDateOfLaunch().getTime()));

			if (movie.isHasTeaser()) {

				preparedStatement.setString(5, "Yes");

			} else {

				preparedStatement.setString(5, "No");

			}

			preparedStatement.setString(6, movie.getGenre());

			preparedStatement.setLong(7, movie.getId());

			preparedStatement.executeUpdate();

		} catch (SQLException sq) {

			sq.printStackTrace();

		} finally {

			try {

				con.close();

			} catch (Exception e) {

				e.printStackTrace();

			}

		}

	}

	@Override
	public Movie getMovie(long movieId) {

		Connection con = ConnectionHandler.getConnection();

		ResultSet resultSet;

		Movie movie = null;

		if (con != null) {

			try {

				String sql = "select * from movie where m_id=?";

				PreparedStatement ps = con

						.prepareStatement(sql);

				ps.setLong(1, movieId);

				resultSet = ps.executeQuery();

				boolean active, hasteaser;

				Date date_of_launch;

				while (resultSet.next()) {

					String title = resultSet.getString(2);

					long boxoffice = resultSet.getLong(3);

					String isActive = resultSet.getString(4);

					date_of_launch = resultSet.getDate(5);

					String genre = resultSet.getString(6);

					String isHasteaser = resultSet.getString(7);

					if (isActive != null && isActive.equals("Yes"))

						active = true;

					else

						active = false;

					if (isHasteaser != null && isHasteaser.equals("Yes"))

						hasteaser = true;

					else

						hasteaser = false;

					movie = new Movie(movieId, title, boxoffice,

							active, date_of_launch, genre,

							hasteaser);

				}

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

		return movie;

	}
}
