import static org.junit.Assert.*;

import java.io.IOException;
import java.text.ParseException;

import org.json.JSONException;
import org.junit.Test;

public class AverageCastAgeTests {

	/*
	 * Test with valid actor and movie name
	 */
	@Test
	public void testValidActorData() throws JSONException, IOException, ParseException {
		AverageCastAge aca = new AverageCastAge();
		int count = aca.captureEachActorAge("Brad Pitt", "Snatch");
		int expectedCount = 50;

		assertEquals(count, expectedCount);
	}
	
	/*
	 * Test an actor not in free base
	 */
	@Test
	public void testNoActorFound() throws JSONException, IOException, ParseException {
		AverageCastAge aca = new AverageCastAge();
		int count = aca.captureEachActorAge("Brad Pi", "Snatch");
		int expectedCount = 0;

		assertEquals(count, expectedCount);
	}
	
	/*
	 * Test with empty actor and movie movie
	 */
	@Test
	public void testEmptyActorName() throws JSONException, IOException, ParseException {
		AverageCastAge aca = new AverageCastAge();
		int count = aca.captureEachActorAge("", "");
		int expectedCount = 0;

		assertEquals(count, expectedCount);
	}
	
	/*
	 * Test avg cast in a movie with valid data
	 */
	@Test
	public void testAvgAgeValid() throws JSONException, IOException, ParseException {
		AverageCastAge aca = new AverageCastAge();
		String url = "http://api.rottentomatoes.com/api/public/v1.0/movies/314387087/cast.json";
		int count = aca.captureAllCastAvg(url, "The Departed");
		int expectedCount = 48;

		assertEquals(count, expectedCount);
	}
	
	/*
	 * Test avg cast in a movie with invalid data
	 */
	@Test(expected=IOException.class)
	public void testMalFormedURL() throws JSONException, IOException, ParseException {
		AverageCastAge aca = new AverageCastAge();
		String url = "http://api.rottentomatoes.com/api/public/v1.0/movies/314387087/cast.json?key=a";
		int count = aca.captureAllCastAvg(url, "The Departed");
		int expectedCount = 48;

		assertEquals(count, expectedCount);
	}
	
	/*
	 * Test avg cast in a movie with valid data, but no results in free base
	 */
	@Test(expected=IOException.class)
	public void testAgeWithNotEnoughData() throws JSONException, IOException, ParseException {
		AverageCastAge aca = new AverageCastAge();
		String url = "http://api.rottentomatoes.com/api/public/v1.0/movies/771312977/cast.json?key=a";
		int count = aca.captureAllCastAvg(url, "St. Vincent");
		int expectedCount = 0;

		assertEquals(count, expectedCount);
	}
}
