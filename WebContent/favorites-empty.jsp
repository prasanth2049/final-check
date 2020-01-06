<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Movie List Admin</title>
<link rel="stylesheet" type="text/CSS" href="./style/style.css" />
</head>

<body>
	<header> <span id="head">Movie Cruiser </span> <img
		src="./images/logo.png" /> <a id="Favorites" href="ShowFavorites">Favorites</a>
	<a id="movies" href="ShowMovieListCustomer">Movies</a> </header>

	<div>
		<h2 class="cont">Favorites</h2>
		<table class="cont">
			<p id="text">
				No items in Favorites.Use'Add to Favorite'option in <a
					href="ShowMovieListCustomer">Movie List</a>.
			</p>
		</table>
	</div>

	<footer> <span class="cont">Copyright@2019</span></footer>
</body>
</html>