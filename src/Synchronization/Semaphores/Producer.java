package Synchronization.Semaphores;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable {

    String name;
    int max_size;
    Queue<Object> queue;
    Semaphore producersema;
    Semaphore consumersema;

    public Producer(Queue<Object> queue, int max_size,String name,Semaphore producersema,Semaphore consumersema ) {
        this.name = name;
        this.max_size = max_size;
        this.queue = queue;
        this.producersema=producersema;
        this.consumersema= consumersema;
    }

    @Override
    public void run() {
        while(true)
        {
            try {
                producersema.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            queue.add(new Object());
            System.out.println(this.name+" adding the new item "+"the new queue size is "+queue.size());
            consumersema.release();
        }
    }
}
