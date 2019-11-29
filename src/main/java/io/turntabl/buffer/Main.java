package io.turntabl.buffer;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random ran = new Random();
        int tamArray = ran.nextInt(21) + 1;
        int[] array = new int[tamArray];

        CircularBuffer buffer = new CircularBuffer(array);

        Producer producer = new Producer (buffer);
        Consumer consumer = new Consumer (buffer);

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            System.err.println("Error with Threads");
            e.printStackTrace();
        }

    }
}
