To run the project locally, follow these steps:
1. Ensure that Java 17 is installed on your machine. You can download it from [here](https://www.oracle.com/java/technologies/downloads/#java17).
2. Clone this repository (Skip this step If you already have this project locally):
```
    git clone https://github.com/MURATKAYMAZ56/movie_best_picture_oscars.git
```
3. Navigate to the project directory:
```
    cd movie_best_picture_oscars
```
4. Build the project:
```
    ./mvnw clean install
```
5. Run the application:
```
    ./mvnw spring-boot:run
```
6. The  application will be accesiable at `http://localhost:8080`


## Endpoints

This application consists of 3 endpoints. See below to understand how they implemented what is needed to run/make the call.
(For sample api calls take a look at how_to_test.md file)

1 - **Check Movie Awards**

Endpoint:

`GET  api/movies/checkAwards/{imdbId}`

Parameters:

imdbId (String): The IMDb ID of the movie to check for awards.

Description:

Checks whether a movie won a "Best Picture" Oscar based on its IMDb ID.

Response:

Status: 200 OK

2 - **Rate Movie**

Endpoint:

`PUT  api/movies/{imdbId}`

Path Variable:

imdbId (String): The IMDb ID of the movie to rate.

Request Body:

MovieRateRequestDto containing the user's rating for the movie.

Description:
Allows users to rate a movie identified by its IMDb ID.

Response:

Status: 200 OK

Body: Empty response indicating the successful rating of the movie.

3 - **Find Top Ten Movies**

Endpoint:

`GET api/movies`

Description:

Returns the top 10 movies **ordered by box office value**.

Response:

Status: 200 OK

Body: MovieDataResponse containing information about the top 10 movies.


## Accessing H2 Console
The Movie Best Picture Oscars application uses an H2 in-memory database, and you can access the H2 Console to view and query the data.
1. After application is successfully run, open your browser and go to `http://localhost:8080/h2-console`.
2. In the login page, set the following values:
```
    JDBC URL: jdbc:h2:mem:testdb
    User Name: sa
    Password: pwd
```
3.Click the "Connect" button.
4. You will be redirected to the H2 Console. Here, you can view and execute SQL queries against the in-memory database.
5. To see data Click on `MOVIE` table and run below script

```
    SELECT * FROM MOVIE 
```
(when table is empty use 'PUT' endpoint to add data)

## Running Unit Tests
To run unit tests, execute the following command:
```
    ./mvnw test
```