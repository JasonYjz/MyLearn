package cwe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by jasyu on 2020/12/15.
 *
 * THI04-J. Ensure that threads performing blocking operations can be terminated
 *
 * Noncompliant
 **/
// Thread-safe class
public final class SocketReader implements Runnable {
    private final Socket socket;
    private final BufferedReader in;
    private volatile boolean done = false;
    private final Object lock = new Object();

    public SocketReader(String host, int port) throws IOException {
        this.socket = new Socket(host, port);
        this.in = new BufferedReader(
                new InputStreamReader(this.socket.getInputStream())
        );
    }

    // Only one thread can use the socket at a particular time
    @Override public void run() {
        try {
            synchronized (lock) {
                readData();
            }
        } catch (IOException ie) {
            // Forward to handler
        }
    }

    public void readData() throws IOException {
        String string;
        //when the thread is blocked on network I/O as a consequence of invoking the readLine() method,
        //it cannot respond to the newly set flag until the network I/O is complete.
        while (!done && (string = in.readLine()) != null) {
            // Blocks until end of stream (null)
        }
    }

    public void shutdown() {
        done = true;
    }

    public static void main(String[] args)
            throws IOException, InterruptedException {
        SocketReader reader = new SocketReader("somehost", 25);
        Thread thread = new Thread(reader);
        thread.start();
        Thread.sleep(1000);
        reader.shutdown(); // Shut down the thread
    }
}
