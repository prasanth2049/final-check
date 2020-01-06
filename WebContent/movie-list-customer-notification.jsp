<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Movie List Customer (Add to Favorites success)</title>
<link rel="stylesheet" type="text/CSS" href="./style/style.css" />
</head>

<body>
	<header> <span id="head">Movie Cruiser </span> <img
		src="./images/logo.png" /> <a id="Favorites" href="ShowFavorites">Favorites</a>
	<a id="movies" href="ShowMovieListCustomer">Movies</a> </header>

	<div>
		<h2 class="cont">Movies</h2>
		<table class="cont">
			<p class="al-mid">Movie added to favorites successfully</p>
			<table class="cont">
				<tr>
					<th>Title</th>
					<th class="al-right">Box Office</th>
					<th class="al-mid">Genre</th>
					<th class="al-mid">Has Teaser</th>
					<th class="al-mid">Action</th>
				</tr>
				</tr>
				<tr>
					<td>Avatar</td>
					<td class="al-right">$2,789,965,087</td>
					<td class="al-mid">Science Fiction</td>
					<td class="al-mid">Yes</td>
					<td class="al-mid"><a
						href="movie-list-customer-notification.jsp" class="link-color">Add
							to Favorite</a></td>
				</tr>
				<tr>
					<td>The Avengers</td>
					<td class="al-right">$1,518,812,988</td>
					<td class="al-mid">Superhero</td>
					<td class="al-mid">No</td>
					<td class="al-mid"><a
						href="movie-list-customer-notification.jsp" class="link-color">Add
							to Favorite<a></td>
				</tr>
				<tr>
					<td>Titanic</td>
					<td class="al-right">$2,187,463,944</td>
					<td class="al-mid">Romance</td>
					<td class="al-mid">No</td>
					<td class="al-mid"><a
						href="movie-list-customer-notification.jsp" class="link-color">Add
							to Favorite<a></td>
				</tr>
			</table>
			</div>

			<footer> <span class="cont">Copyright@2019</span></footer>
</body>
</html>
