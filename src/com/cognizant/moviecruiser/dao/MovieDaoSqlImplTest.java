package com.cognizant.moviecruiser.dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.util.DateUtil;
import com.cognizant.moviecruiser.dao.MovieDaoSqlImpl;
import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.model.Movie;

public class MovieDaoSqlImplTest {
	public static void main(String[] args) throws ClassNotFoundException, ParseException {
		try {
			System.out.println("*********Admin Movie List********");
			testGetMovieListAdmin();
			System.out.println("*********Customer Movie List********");
			testGetMovieListCustomer();
			System.out.println("*********Modified Movie List********");
			testModifyMovie();
			testGetMovieListAdmin();

		} catch (ParseException e) {
			System.out.println(e);
		}
	}

	public static void testGetMovieListAdmin() throws ParseException {
		MovieDao movieDao = new MovieDaoSqlImpl();
		List<Movie> movieList = movieDao.getMovieListAdmin();
		for (Movie x : movieList) {
			System.out.println(x);
		}

	}

	public static void testGetMovieListCustomer() throws ParseException {
		MovieDao movieDao = new MovieDaoSqlImpl();
		List<Movie> customerList = movieDao.getMovieListCustomer();
		for (Movie x : customerList) {
			System.out.println(x);
		}

	}

	public static void testModifyMovie() throws ParseException {
		MovieDao movieDao = new MovieDaoSqlImpl();
		Movie movie = (new Movie(1, "Forrest gump", 1234567873L, true, DateUtil.convertToDate("12/03/2012"), "Drama",
				true));
		movieDao.modifyMovie(movie);
	}

}
