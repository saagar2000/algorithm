package ratelimiter;

import java.time.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class TokenBucketRateLimiter {
  private final long capacity;
  private final AtomicLong tokens;
  private final Duration refillPeriod;
  private volatile Instant lastRefillTime;

  public TokenBucketRateLimiter(long capacity, Duration refillPeriod) {
    this.capacity = capacity;
    this.tokens = new AtomicLong(capacity);
    this.refillPeriod = refillPeriod;
  }

  public boolean isAllowed() {
    refillTokens();
    long currentTokens = tokens.get();
    if (currentTokens > 0) {
      tokens.decrementAndGet();
      return true;
    }
    return false;
  }

  private synchronized void refillTokens() {
    Instant now = Instant.now();
    long timeElapsed = Duration.between(lastRefillTime, now).toMillis();
    long newTokens = timeElapsed / refillPeriod.toMillis();
    if (newTokens > 0) {
      lastRefillTime = now;
      tokens.getAndUpdate(currentTokens -> Math.min(capacity, currentTokens + newTokens));
    }
  }
}
