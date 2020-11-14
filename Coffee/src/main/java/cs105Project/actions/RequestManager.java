package cs105Project.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public abstract class RequestManager {

    private static final int nThreads = 2;
    private static final Logger lgr = LoggerFactory.getLogger(RequestManager.class);
    private static final ExecutorService executor = Executors.newFixedThreadPool(nThreads);
    private static final LinkedBlockingQueue<Request> requests = new LinkedBlockingQueue<>(5);

    static {
        Runnable runRequests = () -> {
            while (true) {
                Request request = null;

                try {
                    request = requests.take();
                } catch (InterruptedException ex) {
                    lgr.error("Thread interrupted while waiting for request.", ex);
                }

                if (request == null) {
                    return;
                }

                request.run();
            }
        };

        for (int thread = 1; thread <= nThreads; ++thread) {
            executor.submit(runRequests);
        }
    }

    /**
     * Adds the request to the requests array of active requests.
     * @param request Request to be added.
     */
    public static void queueRequest(Request request) throws InterruptedException {
        requests.put(request);
    }

    public static void killExecutor() {
        executor.shutdown();
    }
}