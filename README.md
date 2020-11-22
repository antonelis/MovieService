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

![#1589F0](https://imgrp2.xiaolee.net/i/aHR0cHM6Ly9wbGFjZWhvbGQuaXQvMTUvMTU4OUYwLzAwMDAwMD90ZXh0PSs=.jpg) _**GET movies actors directors**_

http://localhost:8080/MovieService/api/v1/movie/getall

http://localhost:8080/MovieService/api/v1/actor/getall

http://localhost:8080/MovieService/api/v1/director/getall

![#1589F0](https://imgrp2.xiaolee.net/i/aHR0cHM6Ly9wbGFjZWhvbGQuaXQvMTUvMTU4OUYwLzAwMDAwMD90ZXh0PSs=.jpg) _**GET movies with specific actor (Reeves)**_

http://localhost:8080/MovieService/api/v1/movie/byactor/Reeves

![#1589F0](https://imgrp2.xiaolee.net/i/aHR0cHM6Ly9wbGFjZWhvbGQuaXQvMTUvMTU4OUYwLzAwMDAwMD90ZXh0PSs=.jpg) _**GET actors with specific movie and director (The Fast and the Furious / Cohen)**_

http://localhost:8080/MovieService/api/v1/director/getactorsformovie/Cohen/The Fast and the Furious

![#1589F0](https://imgrp2.xiaolee.net/i/aHR0cHM6Ly9wbGFjZWhvbGQuaXQvMTUvMTU4OUYwLzAwMDAwMD90ZXh0PSs=.jpg) _**GET all movies sorted by category**_

http://localhost:8080/MovieService/api/v1/movie/sortedbycategory

![#1589F0](https://imgrp2.xiaolee.net/i/aHR0cHM6Ly9wbGFjZWhvbGQuaXQvMTUvMTU4OUYwLzAwMDAwMD90ZXh0PSs=.jpg) _**GET one movie by ID (2)**_

http://localhost:8080/MovieService/api/v1/movie/2

![#1589F0](https://imgrp2.xiaolee.net/i/aHR0cHM6Ly9wbGFjZWhvbGQuaXQvMTUvMTU4OUYwLzAwMDAwMD90ZXh0PSs=.jpg) _**GET movies with specific category (Drama)**_

http://localhost:8080/MovieService/api/v1/movie/bycategory/Drama

![#1589F0](https://imgrp2.xiaolee.net/i/aHR0cHM6Ly9wbGFjZWhvbGQuaXQvMTUvMTU4OUYwLzAwMDAwMD90ZXh0PSs=.jpg) _**GET movies between specific release years ( from 1998 to 2020 )**_

http://localhost:8080/MovieService/api/v1/movie/byreleaseyears/1998/2020

![#c5f015](https://imgrp2.xiaolee.net/i/aHR0cHM6Ly9wbGFjZWhvbGQuaXQvMTUvYzVmMDE1LzAwMDAwMD90ZXh0PSs=.jpg)  _**POST new movie**_

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

![#c5f015](https://imgrp2.xiaolee.net/i/aHR0cHM6Ly9wbGFjZWhvbGQuaXQvMTUvYzVmMDE1LzAwMDAwMD90ZXh0PSs=.jpg)  _**POST new actor with movie**_

	{
	  "id": 6,
    "firstName": "Anton",
    "lastName": "Johansson",
    "birthday": "seokdegsp",
	  "movie" : {
		"id":3
	 }
 	}
 
 ![#c5f015](https://imgrp2.xiaolee.net/i/aHR0cHM6Ly9wbGFjZWhvbGQuaXQvMTUvYzVmMDE1LzAwMDAwMD90ZXh0PSs=.jpg)  _**POST new director with movie**_
 
  	{
    "birthday": " March 12",
    "firstName": "Rob",
    "id": 20,
    "lastName": "Cohen",
    "movie": {
			"id":20
		}
 	}
	
![#f03c15](https://imgrp2.xiaolee.net/i/aHR0cHM6Ly9wbGFjZWhvbGQuaXQvMTUvZjAzYzE1LzAwMDAwMD90ZXh0PSs=.jpg)  _**DELETE movie by id (2)**_

http://localhost:8080/MovieService/api/v1/movie/2

![#f03c15](https://imgrp2.xiaolee.net/i/aHR0cHM6Ly9wbGFjZWhvbGQuaXQvMTUvZjAzYzE1LzAwMDAwMD90ZXh0PSs=.jpg)  _**DELETE actor by id (1)**_

http://localhost:8080/MovieService/api/v1/actor/1

![#c5f015](https://imgrp2.xiaolee.net/i/aHR0cHM6Ly9wbGFjZWhvbGQuaXQvMTUvYzVmMDE1LzAwMDAwMD90ZXh0PSs=.jpg)  _**PUT movie by id (3)**_

	{
	  "id":3,		
      "title":"Memento",
	  "category":"Thriller",
	  "runningTime": "113 min",
	  "releaseYear": 2000
	}
  
http://localhost:8080/MovieService/api/v1/movie/update
