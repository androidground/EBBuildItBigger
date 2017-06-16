package com.eightbytestech.ebbuilditbigger;

import android.app.Application;
import android.support.test.runner.AndroidJUnit4;
import android.test.ApplicationTestCase;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class EndPointAsyncTaskJokeTest extends ApplicationTestCase<Application> implements OnJokeReceivedListener {

    CountDownLatch signal;
    String joke;

    public EndPointAsyncTaskJokeTest() {
        super(Application.class);
    }

    @Test
    public void testJoke() {
        try {
            signal = new CountDownLatch(1);
            new EndpointsAsyncTask().execute(this);
            signal.await(10, TimeUnit.SECONDS);
            assertNotNull("joke is null", joke);
            assertFalse("joke is empty", joke.isEmpty());
        } catch (Exception ex) {
            fail();
        }
    }

    @Override
    public void onReceived(String joke) {
        this.joke = joke;
        signal.countDown();
    }
}
