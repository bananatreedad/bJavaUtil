import java.util.concurrent.TimeUnit;

/**
 * Threadsafe sleep functions.
 *
 * Created by bananatreedad on 24/05/16.
 * Inspired by "Der Weg zu Java-Profi" by Michael Inden (p. 501)
 */
public final class SleepUtils {

    public static void safeSleep(final TimeUnit timeUnit, final long duration) {
        safeSleep(timeUnit.toMillis(duration));
    }

    private static void safeSleep(final long durationInMilliSecs) {
        try {
            Thread.sleep(durationInMilliSecs);
        } catch (final InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
