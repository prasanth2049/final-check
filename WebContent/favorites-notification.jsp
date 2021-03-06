<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Movie List Admin</title>
<link rel="stylesheet" type="text/CSS" href="./style/style.css" />
</head>

<body>
	<header> <span id="head">Movie Cruiser </span> <img
		src="./images/logo.png" /> <a id="Favorites" href="ShowFavorite">Favorites</a>
	<a id="movies" href="ShowMovieListCustomer">Movies</a> </header>

	<div>
		<h2 class="cont">Favorites</h2>
		<table class="cont">
			<p id="center">Movie removed from favorites successfully</p>
			<table class="cont">
				<tr>
				<tr>
					<th>Title</th>
					<th class="al-right">Box Office</th>
					<th class="al-mid">Genre</th>
				</tr>
				</tr>
				<tr>
					<td>Avatar</td>
					<td class="al-right">$2,789,965,087</td>
					<td class="al-mid">Science Fiction</td>
					<td class="al-mid"><a href="favorites-notification.jsp"
						class="link-color">Delete</a></td>
				</tr>
				<tr>
					<td>The Avengers</td>
					<td class="al-right">$1,518,812,988</td>
					<td class="al-mid">Superhero</td>
					<td class="al-mid"><a href="favorites-notification.jsp"
						class="link-color">Delete<a></td>
				</tr>
			</table>
			<p id="view">
				<b>No of favorites:</b>2
			</p>
			</div>

			<footer> <span class="cont">Copyright@2019</span></footer>
</body>
</html>
