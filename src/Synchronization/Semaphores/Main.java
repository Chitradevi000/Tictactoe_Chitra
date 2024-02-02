package Synchronization.Semaphores;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        //this is the client class

        //we will create obj for producer and consumer and store(Queue)
        Queue<Object> queue=new ConcurrentLinkedQueue<>();

        //intruducing semaphore

        Semaphore producersema=new Semaphore(6);
        Semaphore consumersema=new Semaphore(0);

        //there are lot of producers
        Producer p1=new Producer(queue,6,"p1",producersema,consumersema); //parameter passed are store, storesize and producer name
        Producer p2=new Producer(queue,6,"p2",producersema,consumersema);
        Producer p3=new Producer(queue,6,"p3",producersema,consumersema);
        Producer p4=new Producer(queue,6,"p4",producersema,consumersema);
        Producer p5=new Producer(queue,6,"p5",producersema,consumersema);
        Producer p6=new Producer(queue,6,"p6",producersema,consumersema);


        Consumer c1=new Consumer(queue,6,"c1",consumersema,producersema);
        Consumer c2=new Consumer(queue,6,"c2",consumersema,producersema);
        Consumer c3=new Consumer(queue,6,"c3",consumersema,producersema);

        Thread t1=new Thread(p1);
        t1.start();
        Thread t2=new Thread(p2);
        t2.start();
        Thread t3=new Thread(p3);
        t3.start();
        Thread t4=new Thread(p4);
        t4.start();
        Thread t5=new Thread(p5);
        t5.start();
        Thread t6=new Thread(p6);
        t6.start();

        Thread t7=new Thread(c1);
        t7.start();
        Thread t8=new Thread(c2);
        t8.start();
        Thread t9=new Thread(c3);
        t9.start();

    }
}
