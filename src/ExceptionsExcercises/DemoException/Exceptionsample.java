package ExceptionsExcercises.DemoException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class Exceptionsample {

    public static void main(String[] args) {
        //3 types of exception

        //throwable class handle all your errors and exceptions
        //2 classes - Errors and Exceptions

        //Errors cant be handled(Physical err)
        //Excep - can be handled - 2 types-
        // checked (it will tell you to hold for the error at compile time)
            // IO and SQL
        // and unchecked
            // all your runtime are unchecked

        //normal stmt - until 21

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int i,j,k=0;
        int a[]=new int[4];
        i=8;
        j=2;
        // add io exception
        int val=0;
        try {
//        below is critical stmt
            k = i / j;
            for(int c=0;c<=a.length;c++)
            {
                a[c]=c+1;
            }

            //enhanced forloop
            for(int n:a)
            {
                System.out.println(n);
            }
             val=Integer.parseInt(br.readLine());
        }
        catch (ArithmeticException e)
        {
            System.out.println("Cant divide by zero" + e);
            //this is unchecked exception

        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Check the array size");
        }
        catch (IOException e)
        {
            System.out.println("io error");
        }

        System.out.println(k);

    }
}
