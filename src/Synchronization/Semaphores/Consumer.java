package Synchronization.Semaphores;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {

    String name;
    int max_size;
    Queue<Object> queue;
    Semaphore consumersema;
    Semaphore producersema;

    public Consumer(Queue<Object> queue, int max_size,String name,Semaphore consumersema,Semaphore producersema ) {
        this.name = name;
        this.max_size = max_size;
        this.queue = queue;
        this.consumersema=consumersema;
        this.producersema=producersema;
    }

    @Override
    public void run() {
        while(true)
        {
            try {
                consumersema.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            queue.remove();
            System.out.println(this.name+"taken the item"+" the new size is "+ queue.size());
            producersema.release();
        }
    }
}
