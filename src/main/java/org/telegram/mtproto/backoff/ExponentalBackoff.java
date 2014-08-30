package org.telegram.mtproto.backoff;

import org.telegram.mtproto.log.Logger;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Backoff for networking operations
 */
public class ExponentalBackoff {

    private static final int MIN_DELAY = 100;
    private static final int MAX_DELAY = 15000;
    private static final int MAX_FAILURE_COUNT = 50;

    private Random rnd = new Random();

    private AtomicInteger currentFailureCount = new AtomicInteger();

    private final String TAG;

    /**
     * Creating backoff
     *
     * @param logTag logging tag
     */
    public ExponentalBackoff(String logTag) {
        this.TAG = logTag;
    }

    /**
     * Called on failure, wait required time before exiting method
     *
     * @throws InterruptedException if waiting was interrupted
     */
    public void onFailure() throws InterruptedException {
        int val = currentFailureCount.incrementAndGet();
        if (val > 50) {
            currentFailureCount.compareAndSet(val, MAX_FAILURE_COUNT);
            val = MAX_FAILURE_COUNT;
        }

        int delay = MIN_DELAY + ((MAX_DELAY - MIN_DELAY) / MAX_FAILURE_COUNT) * val;

        synchronized (this) {
            Logger.d(TAG, "onFailure: wait " + delay + " ms");
            wait(delay);
        }
    }

    /**
     * onFailure without waiting
     */
    public void onFailureNoWait() {
        Logger.d(TAG, "onFailureNoWait");
        int val = currentFailureCount.incrementAndGet();
        if (val > 50) {
            currentFailureCount.compareAndSet(val, MAX_FAILURE_COUNT);
            val = MAX_FAILURE_COUNT;
        }
    }

    /**
     * Called on success operation
     */
    public void onSuccess() {
        Logger.d(TAG, "onSuccess");
        reset();
    }

    /**
     * Resetting backoff state
     */
    public void reset() {
        Logger.d(TAG, "reset");
        currentFailureCount.set(0);

        synchronized (this) {
            notifyAll();
        }
    }
}
