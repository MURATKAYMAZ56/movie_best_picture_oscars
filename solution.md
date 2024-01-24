# Movie "Best Picture" Oscars Application Solution
## Overview
This Java application serves the purpose of indicating whether a movie has won a "Best Picture" Oscar and allows users to rate movies and provide a list of 10 top-rated movies ordered by box office value.
The solution is implemented using the following technologies:

Technologies Used
- Spring Boot: Employed for creating a standalone, production-grade Spring-based Applications.
- Hibernate: Chosen as the ORM to map Java objects to database tables.
- H2 Database: Utilized as an in-memory database for data persistence during development.

While running the application  csv data is getting imported in memory. Here data is stored in HashMap.For map key values; title, year , category fields are used. This is getting used with checkAwards endpoints to decide whether the movie has won "best picture" or not.

Solution consists of 3 api endpoints.

**CheckAwards**

 This endpoint gets imdbId to make call toward OMDBAPI to retrieve title and year information then uses this information (title, year) in memory data to check whether the movie has won "Best Picture". 
In the response it indicates as true or false for the movie.

**Rate**

This endpoints rates the movie and save it in database. 
Request gets imdbId and rate.  With imdbId  OMDBAPI gets called .  In the response it retrieves  title and box_office values  .  All these values (imdbId, title, rate, box_office) are store/updated
in database. Response status is OK. 

**FindTopTen**

It retrieves first 10 records data from database ordered by box_office_values descending.
