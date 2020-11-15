package cs105Project.managers;

import cs105Project.actions.Request;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public final class RequestManager {

    private static final int nThreads = 2;
    private static final ExecutorService executor = Executors.newFixedThreadPool(nThreads);
    private static final LinkedBlockingQueue<Request> requests = new LinkedBlockingQueue<>(5);

    static {
        Runnable runRequests = () -> {
            while (true) {
                Request request = null;

                try {
                    request = requests.take();
                } catch (InterruptedException ex) {
                    System.out.println("Thread interrupted! Program shutdown expected.");
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
        executor.shutdownNow();
    }
}