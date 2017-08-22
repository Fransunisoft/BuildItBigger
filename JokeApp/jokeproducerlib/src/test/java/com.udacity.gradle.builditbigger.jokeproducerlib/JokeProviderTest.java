package com.udacity.gradle.builditbigger.jokeproducerlib;
import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Test class for JokeProvider
 */
public class JokeProviderTest   {

    Logger LOG = Logger.getLogger(JokeProviderTest.class.getSimpleName());
    JokeProvider jokeProvider = new JokeProvider();

    /**
     * Test joke populated
     */
    @Test
    public void jokeListPopulated() {
        assertNotNull(jokeProvider.jokesList);
        assertFalse(jokeProvider.jokesList.isEmpty());
    }

    /**
     * Test joke retrieved
     */
    @Test
    public void retrieveJoke() {
        String joke = jokeProvider.retrieveJokes();
        assertNotNull(joke);
        assertFalse(joke.isEmpty());
    }


}