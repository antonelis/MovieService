# MovieService
JAVA EE / JAX-RS - Labb

## GET all movies

_http://localhost:8080/MovieService/api/v1/movie/getall_

## GET all movies sorted by category

http://localhost:8080/MovieService/api/v1/movie/sortedbycategory

## GET one movie by ID (2)

http://localhost:8080/MovieService/api/v1/movie/2

## GET movies with specific category (Drama)

http://localhost:8080/MovieService/api/v1/movie/bycategory/Drama

## GET movies between specific release years ( from 1998 to 2020 ) 

http://localhost:8080/MovieService/api/v1/movie/byreleaseyears/1998/2020

## POST new movie 

	{	
      "title":"The Pianist",
	  "category":"Drama",
	  "runningTime": "150 min",
	  "releaseYear": 2002
	}

http://localhost:8080/MovieService/api/v1/movie/new

## DELETE movie by id (1)

http://localhost:8080/MovieService/api/v1/movie/1

## PUT movie by id (3)
	{
	  "id":3,		
      "title":"Memento",
	  "category":"Thriller",
	  "runningTime": "113 min",
	  "releaseYear": 2000
	}
  
http://localhost:8080/MovieService/api/v1/movie/update
