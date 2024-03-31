package ratelimiter;

import java.util.concurrent.atomic.*;

public class LeakyBucketRateLimiter {
    private final long capacity;
    private final long ratePerSecond;
    private final AtomicLong lastRequestTime;
    private final AtomicLong currentBucketSize;

    public LeakyBucketRateLimiter(long capacity, long ratePerSecond) {
        this.capacity = capacity;
        this.ratePerSecond = ratePerSecond;
        this.lastRequestTime = new AtomicLong(System.currentTimeMillis());
        this.currentBucketSize = new AtomicLong(0);
    }

}
