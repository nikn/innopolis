package ru.innopolis.nikn.task1;


import java.util.Date;

/**
 * Created by Nikolay on 10.11.2016.
 */
public class Main {

    public static void main(String[] args) {
        PositiveSummer positiveSummer = new PositiveSummer();
        long time = new Date().getTime();
        String[] resources = {
                "/test0/1.txt",
                "/test0/2.txt",
                "http://10.243.1.219/1.txt",
                "http://10.243.1.219/1.txt"
        };

       /* String[] resources = {
                "/test1/0.ints",
                "/test1/1.ints",
                "/test1/2.ints",
                "/test1/3.ints",
                "/test1/4.ints",
                "/test1/5.ints",
                "/test1/6.ints",
                "/test1/7.ints",
                "/test1/8.ints",
                "/test1/9.ints",
                "/test1/10.ints",
                "/test1/11.ints",
                "/test1/12.ints",
                "/test1/13.ints",
                "/test1/14.ints",
                "/test1/15.ints",
        };*/
        ShareBoxMonitor shareBoxMonitor = positiveSummer.getPositiveSum(resources);
        System.out.println(((new Date()).getTime() - time));
        System.out.println(shareBoxMonitor.getValue());
    }

}
