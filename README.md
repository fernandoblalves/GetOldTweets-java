# Get Old Tweets Programatically
A project written in Java to get old tweets, it bypass some limitations of Twitter Official API.

## Details
Twitter Official API limits the tweet search to a week. Some tools provide access to older tweets but in the most of them you have to spend some money.
This tools mimics the tweet search performed on a browser, where there are no time limits.

## Components
- **Tweet:** Model class to give some informations about a specific tweet.
  - id (String)
  - permalink (String)
  - username (String)
  - text (String)
  - date (Date)
  - retweets (int)
  - favorites (int)
  - mentions (String)
  - hashtags (String)
  - geo (String)

- **TweetManager:** A manager class to help getting tweets in **Tweet**'s model.
  - getTweets (**TwitterCriteria**): Return the list of tweets retrieved by using an instance of **TwitterCriteria**. 

- **TwitterCriteria:** A collection of search parameters to be used together with **TweetManager**.
  - create: First method to be called, creates a new empty instance. 
  - setUsername (String): An optional specific username from a twitter account. Without "@".
  - setSince (String. "yyyy-mm-dd"): A lower bound date to restrict search.
  - setUntil (String. "yyyy-mm-dd"): An upper bound date to restrist search.
  - setQuerySearch (String): A query text to be matched.
  - setMaxTweets (int): The maximum number of tweets to be retrieved. If this number is unsetted or lower than 1 all possible tweets will be retrieved.
  - optional - [output] (str): The name of the file where to store the results (default: *got_output.csv*)
  
- **Main:** A simple class showing examples of use.

- **Exporter:** A class to execute tweets search through command-line.

- **got.jar:** A runnable jar to call **Exporter** class. The result goes to a generated csv file named "output_got.csv".

## Examples of java use
- Get tweets by username
``` java
    TwitterCriteria criteria = TwitterCriteria.create()
				.setUsername("barackobama")
				.setMaxTweets(1);
    Tweet t = TweetManager.getTweets(criteria).get(0);
    System.out.println(t.getText());
```    
- Get tweets by query search
``` java
    TwitterCriteria criteria = TwitterCriteria.create()
				.setQuerySearch("europe refugees")
				.setMaxTweets(1);
    Tweet t = TweetManager.getTweets(criteria).get(0);
    System.out.println(t.getText());
```    
- Get tweets by username and bound dates
``` java
    TwitterCriteria criteria = TwitterCriteria.create()
				.setUsername("barackobama")
				.setSince("2015-09-10")
				.setUntil("2015-09-12")
				.setMaxTweets(1);
    Tweet t = TweetManager.getTweets(criteria).get(0);
    System.out.println(t.getText());
```    

## Examples of command-line use
- Get help use
```
    java -jar got.jar -h
``` 
- Get tweets by username
```
    java -jar got.jar username=barackobama maxtweets=1
```    
- Get tweets by query search
```
    java -jar got.jar querysearch="europe refugees" maxtweets=1
```    
- Get tweets by username and bound dates
```
    java -jar got.jar username=barackobama since=2015-09-10 until=2015-09-12 maxtweets=1
```    
