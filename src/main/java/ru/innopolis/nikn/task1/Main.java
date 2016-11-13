package ru.innopolis.nikn.task1;


/**
 * Created by Nikolay on 10.11.2016.
 */
public class Main {

    public static void main(String[] args) {
        PositiveSummer positiveSummer = new PositiveSummer();
        String[] resources = {
                "/test0/1.txt",
                "/test0/2.txt",
                "http://10.240.17.30/1.txt",
                "http://10.240.17.30/1.txt"
        };
        positiveSummer.getPositiveSum(resources);
    }

}
