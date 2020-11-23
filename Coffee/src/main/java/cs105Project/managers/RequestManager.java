/*
 * Made for the Final Project in CS105, due December 4th 2020. <br>
 * This work is licensed under the GNU General Public License v3.0 <br>
 * GNU © 2020 Daniel Stefani / OpenSrcerer
 */

package cs105Project.managers;

import cs105Project.actions.Request;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * This class manages every request that gets
 * sent to the queue. By only having one spot open and
 * a dedicated thread, it allows one request at a time
 * to have independency from the GUI.
 *
 * This class is actually built for more threads but is currently
 * only using one thread.
 */
public final class RequestManager {

    // Initialization of the thread-managing executor & queue.
    private static final int nThreads = 1;
    private static final ExecutorService executor = Executors.newFixedThreadPool(nThreads);
    private static final LinkedBlockingQueue<Request> requests = new LinkedBlockingQueue<>(1);

    static {
        // Runnable that gets parked to wait for requests.
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

        // submits the request to the executor
        for (int thread = 1; thread <= nThreads; ++thread) {
            executor.submit(runRequests);
        }
    }

    /**
     * Adds the request to the requests array of active requests.
     * @param request Request to be added.
     */
    public static void queueRequest(Request request) {
        requests.offer(request);
    }

    /**
     * Shuts the executors down and interrupts threads.
     */
    public static void killExecutor() {
        executor.shutdownNow();
    }
}