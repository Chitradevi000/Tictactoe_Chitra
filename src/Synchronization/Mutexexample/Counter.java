package Synchronization.Mutexexample;

public class Counter {
    private int count;

    public Counter(int count) {
        this.count = count;
    }

    public synchronized void incValue(int offset)
    {
//        synchronized (Counter   .class)
        count=count+offset; //this is CS
    }
    public void getValue()
    {
        System.out.println("The value is : " + this.count);
    }
    public synchronized void decValue(int offset)
    {
        count=count-offset; //this is CS
    }
}
