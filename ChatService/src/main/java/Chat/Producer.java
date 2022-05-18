package Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Producer implements Runnable {

    private final String id;
    private final Queue queue;

    public Producer(String id, Queue q) { this.id = id; queue = q;}

    public void run() {
        while (true) {
            String m = null;
            try {
                m = write();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Prod. " + id + ": " + m);
            queue.put(m);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String write() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Input : ");
        String m = br.readLine();
        return m;
    }
}
