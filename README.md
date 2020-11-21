# MovieService
JAVA EE / JAX-RS - Labb


| _MOVIE_  |  _ACTOR_ | _DIRECTOR_  |
| ------------- | ------------- | ------------- |
| The Fast and the Furious  | Paul Walker  | Rob Cohen  |
| Fight Club  | Vin Diesel  | David Fincher |
| Pulp Fiction  | Edward Norton | Quentin Tarantino  |
| Matrix  | Bruce Willis | Brothers Wachowski  |
| Speed  | Keanu Reeves  | Jan de Bont  |
| American History X  | George Clooney  | Tony Kaye  |
|From Dusk Till Dawn  |   |   |

![#1589F0](https://imgrp2.xiaolee.net/i/aHR0cHM6Ly9wbGFjZWhvbGQuaXQvMTUvMTU4OUYwLzAwMDAwMD90ZXh0PSs=.jpg)
## GET movies actors directors

http://localhost:8080/MovieService/api/v1/movie/getall

http://localhost:8080/MovieService/api/v1/actor/getall

http://localhost:8080/MovieService/api/v1/director/getall

![#1589F0](https://imgrp2.xiaolee.net/i/aHR0cHM6Ly9wbGFjZWhvbGQuaXQvMTUvMTU4OUYwLzAwMDAwMD90ZXh0PSs=.jpg)
## GET movies with specific actor (Reeves)

http://localhost:8080/MovieService/api/v1/movie/byactor/Reeves

![#1589F0](https://imgrp2.xiaolee.net/i/aHR0cHM6Ly9wbGFjZWhvbGQuaXQvMTUvMTU4OUYwLzAwMDAwMD90ZXh0PSs=.jpg)
## GET actors with specific movie and director (The Fast and the Furious / Cohen)

http://localhost:8080/MovieService/api/v1/director/getactorsformovie/Cohen/The Fast and the Furious

![#1589F0](https://imgrp2.xiaolee.net/i/aHR0cHM6Ly9wbGFjZWhvbGQuaXQvMTUvMTU4OUYwLzAwMDAwMD90ZXh0PSs=.jpg)
## GET all movies sorted by category

http://localhost:8080/MovieService/api/v1/movie/sortedbycategory

![#1589F0](https://imgrp2.xiaolee.net/i/aHR0cHM6Ly9wbGFjZWhvbGQuaXQvMTUvMTU4OUYwLzAwMDAwMD90ZXh0PSs=.jpg)
## GET one movie by ID (2)

http://localhost:8080/MovieService/api/v1/movie/2

![#1589F0](https://imgrp2.xiaolee.net/i/aHR0cHM6Ly9wbGFjZWhvbGQuaXQvMTUvMTU4OUYwLzAwMDAwMD90ZXh0PSs=.jpg)
## GET movies with specific category (Drama)

http://localhost:8080/MovieService/api/v1/movie/bycategory/Drama

![#1589F0](https://imgrp2.xiaolee.net/i/aHR0cHM6Ly9wbGFjZWhvbGQuaXQvMTUvMTU4OUYwLzAwMDAwMD90ZXh0PSs=.jpg)
## GET movies between specific release years ( from 1998 to 2020 ) 

http://localhost:8080/MovieService/api/v1/movie/byreleaseyears/1998/2020

![#c5f015](https://imgrp2.xiaolee.net/i/aHR0cHM6Ly9wbGFjZWhvbGQuaXQvMTUvYzVmMDE1LzAwMDAwMD90ZXh0PSs=.jpg)
## POST new movie 

	{	
      "title":"The Pianist",
	  "category":"Drama",
	  "runningTime": "150 min",
	  "releaseYear": 2002
    "director" : {	
    "id": 14
		}
	 
	}
	



http://localhost:8080/MovieService/api/v1/movie/new

![#c5f015](https://imgrp2.xiaolee.net/i/aHR0cHM6Ly9wbGFjZWhvbGQuaXQvMTUvYzVmMDE1LzAwMDAwMD90ZXh0PSs=.jpg)
## POST new actor with movie

	{
	  "id": 6,
    "firstName": "Anton",
    "lastName": "Johansson",
    "birthday": "seokdegsp",
	  "movie" : {
		"id":3
	 }
 	}
 
 ![#c5f015](https://imgrp2.xiaolee.net/i/aHR0cHM6Ly9wbGFjZWhvbGQuaXQvMTUvYzVmMDE1LzAwMDAwMD90ZXh0PSs=.jpg)
## POST new director with movie
  	{
    "birthday": " March 12",
    "firstName": "Rob",
    "id": 20,
    "lastName": "Cohen",
    "movie": {
			"id":20
		}
 	}
	
![#f03c15](https://imgrp2.xiaolee.net/i/aHR0cHM6Ly9wbGFjZWhvbGQuaXQvMTUvZjAzYzE1LzAwMDAwMD90ZXh0PSs=.jpg)
## DELETE movie by id (1)

http://localhost:8080/MovieService/api/v1/movie/1

![#c5f015](https://imgrp2.xiaolee.net/i/aHR0cHM6Ly9wbGFjZWhvbGQuaXQvMTUvYzVmMDE1LzAwMDAwMD90ZXh0PSs=.jpg)
## PUT movie by id (3)
	{
	  "id":3,		
      "title":"Memento",
	  "category":"Thriller",
	  "runningTime": "113 min",
	  "releaseYear": 2000
	}
  
http://localhost:8080/MovieService/api/v1/movie/update
