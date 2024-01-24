# How to Test the Movie Best Picture Oscars Application
This app consists of 3 api calls.

To test the functionality of the application you can either use postman( or any other api client) or terminal to make api calls.

## Usage Examples via terminal

### Check Movie Awards
~~~
 curl -X GET  'http://localhost:8080/api/movies/checkAwards?imdbId=tt1010048'
~~~
Response
```
{ "won" : true }

```

### Rate Movie
``` 
curl -X PUT -H "Content-Type: application/json" -d '{"rate": 4.5}' "http://localhost:8080/api/movies/tt1010048"

```
### Find Top Ten Movies
``` 
curl -X GET http://localhost:8080/api/movies

```

Response

``` 
{
    "data": [
        {
            "id": "tt1010048",
            "title": "Slumdog Millionaire",
            "boxOfficeValue": 141319928.00
        }
    ]
}
```
To be able to compare more movies you need to use Rate Movie endpoints to add more data in database.

For movies imdbId, you can choose any imdbId for any movie in the https://www.omdbapi.com/ or choose from below data

```
[
  { "title": "Black Swan", "imdbId": "tt0947798" },
  { "title": "The Kids Are All Right", "imdbId": "tt0842926" },
  { "title": "The King's Speech", "imdbId": "tt1504320" },
  { "title": "127 Hours", "imdbId": "tt1542344" },
  { "title": "The Social Network", "imdbId": "tt1285016" },
  { "title": "Toy Story 3", "imdbId": "tt0435761" },
  { "title": "True Grit", "imdbId": "tt1403865" },
  { "title": "Winter's Bone", "imdbId": "tt1399683" },
  { "title": "The Reader", "imdbId": "tt0976051" },
  { "title": "Slumdog Millionaire", "imdbId": "tt1010048" },
  { "title": "Milk", "imdbId": "tt1013753" },
  { "title": "The Curious Case of Benjamin Button", "imdbId": "tt0421715" }
]

```

## Making API Calls via Postman
You can use Postman to make API calls.
 
1- Check Movie Awards : Check if a movie won a "Best Picture" Oscar .
```
    - GET http://localhost:8080/api/movies/checkAwards?imdbId=tt1010048
```
You should see the response as below.

```
 {"won":true}
```

 for this api call Slumdog Millionaire imdbId is used. You can choose any imdbId for any movie in the https://www.omdbapi.com/ list .

2- Rate Movie : Rate a movie using the following API:

    -  `PUT http://localhost:8080/api/movies/tt1010048`
   request body:
```
{
    "rate": 7
}
```

3- Find Top Ten Movies : Get the list of top-rated movies ordered by box-office value :

    - `GET http://localhost:8080/api/movies`
response :
``` 
{
    "data": [
        {
            "id": "tt1010048",
            "title": "Slumdog Millionaire",
            "boxOfficeValue": 141319928.00
        }
    ]
}

```

