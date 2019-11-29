package io.turntabl.buffer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.IntStream;

public class Producer extends Thread{
    CircularBuffer buffer;
    int bufferTam;
    int countData;
    ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(500);

    public Producer(CircularBuffer buff) {
        this.buffer = buff;
        this.bufferTam = buffer.array.length;
        this.countData = 0;

    }

    public void produceData() {
        this.countData++;
        this.buffer.writeData(countData);
        System.out.println(" produce data  " + countData + ": " );

    }

    public void run() {

        IntStream.range(0, 20).forEach(i -> {
            while (this.buffer.bufferLength == this.bufferTam) {
                Thread.yield();
            }
            this.produceData();
        });
    }
}
