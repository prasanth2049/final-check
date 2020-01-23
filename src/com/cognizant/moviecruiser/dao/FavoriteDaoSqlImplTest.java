package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Movie;

public class FavoriteDaoSqlImplTest {

	public static void main(String[] args) throws FavoriteEmptyException {
		
		testAddFavorite();

		testRemoveFavorite();

		testGetAllFavorite();

	}

	static void testAddFavorite() throws FavoriteEmptyException {

		FavoriteDaoSqlImpl favoriteDaoSqlImpl = new FavoriteDaoSqlImpl();

		FavoriteDao favoriteDao = favoriteDaoSqlImpl;

		favoriteDao.addFavorite(1, 4);

		favoriteDao.addFavorite(1, 3);

		List<Movie> movieList = favoriteDao.getAllFavorite(1);

	}

	static void testGetAllFavorite() throws FavoriteEmptyException {

		FavoriteDaoSqlImpl favoriteDaoSqlImpl = new FavoriteDaoSqlImpl();

		FavoriteDao favoriteDao = favoriteDaoSqlImpl;

		List<Movie> movieList = favoriteDao.getAllFavorite(1);

		System.out.println("Movie list :" + movieList);

	}

	static void testRemoveFavorite() throws FavoriteEmptyException {

		FavoriteDaoSqlImpl favoriteDaoSqlImpl = new FavoriteDaoSqlImpl();

		FavoriteDao favoriteDao = favoriteDaoSqlImpl;

		try {

			favoriteDao.deleteFavorite(1, 4);

			List<Movie> movieList = favoriteDao.getAllFavorite(1);

		} catch (Exception e) {

			throw new FavoriteEmptyException("Favorite is empty");

		}

	}

}