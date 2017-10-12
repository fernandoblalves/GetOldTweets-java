package me.falves.main;

import me.falves.manager.TweetManager;
import me.falves.manager.TwitterCriteria;
import me.falves.model.Tweet;

public class Main {
	private static final String USERNAME = "Username: ";
	private static final String RETWEETS = "Retweets: ";
	private static final String TEXT = "Text: ";
	private static final String MENTIONS = "Mentions: ";
	private static final String HASHTAGS = "Hashtags: ";

	public static void main(String[] args) {
		/*
		 * Reusable objects
		 */
		TwitterCriteria criteria;
		Tweet t;
		
		/*
		 *  Example 1 - Get tweets by username
		 **/
		
		criteria = TwitterCriteria.create()
				.setUsername("barackobama")
				.setMaxTweets(1);
		t = TweetManager.getTweets(criteria).get(0);
		
		System.out.println("### Example 1 - Get tweets by username [barackobama]");
		System.out.println(USERNAME + t.getUsername());
		System.out.println(RETWEETS + t.getRetweets());
		System.out.println(TEXT + t.getText());
		System.out.println(MENTIONS + t.getMentions());
		System.out.println(HASHTAGS + t.getHashtags());
		System.out.println();
		
		/*
		 *  Example 2 - Get tweets by query search
		 **/
		criteria = TwitterCriteria.create()
				.setQuerySearch("europe refugees")
				.setSince("2015-05-01")
				.setUntil("2015-09-30")
				.setMaxTweets(1);
		t = TweetManager.getTweets(criteria).get(0);
		
		System.out.println("### Example 2 - Get tweets by query search [europe refugees]");
		System.out.println(USERNAME + t.getUsername());
		System.out.println(RETWEETS + t.getRetweets());
		System.out.println(TEXT + t.getText());
		System.out.println(MENTIONS + t.getMentions());
		System.out.println(HASHTAGS + t.getHashtags());
		System.out.println();
		
		/*
		 *  Example 3 - Get tweets by username and bound dates
		 **/
		criteria = TwitterCriteria.create()
				.setUsername("barackobama")
				.setSince("2015-09-10")
				.setUntil("2015-09-12")
				.setMaxTweets(1);
		t = TweetManager.getTweets(criteria).get(0);
		
		System.out.println("### Example 3 - Get tweets by username and bound dates [barackobama, '2015-09-10', '2015-09-12']");
		System.out.println(USERNAME + t.getUsername());
		System.out.println(RETWEETS + t.getRetweets());
		System.out.println(TEXT + t.getText());
		System.out.println(MENTIONS + t.getMentions());
		System.out.println(HASHTAGS + t.getHashtags());
		System.out.println();
	}
	
}