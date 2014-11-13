ActorsAvgAge
============

Coding Challenge

Approach and Data considerations:

Initial idea to solve the challenge

1. Find resources to capture "Movies" and "Actor Data"
2. Use a JSON Parser to parse and save required information
3. Perform calculations to find average age of cast for each movie

Currently considering the Rotten Tomatoes API, which has information about
list of movies that are being shown in theatres as on today's date as well
as complete list of cast for each movie.

Few example get requests are mentioned below:

Get complete cast for a given movie
http://api.rottentomatoes.com/api/public/v1.0/movies/771355766/cast.json?apikey=6rfdvqjd4kxp22car8fu9c4m

Get the list of movies that are being show in theatres now:
http://api.rottentomatoes.com/api/public/v1.0/lists/movies/in_theaters.json?apikey=6rfdvqjd4kxp22car8fu9c4m

/** need to find a way to retrive each actor's age **/


