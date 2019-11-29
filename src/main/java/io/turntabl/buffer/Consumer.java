package io.turntabl.buffer;

import java.util.stream.IntStream;

public class Consumer extends Thread {
    private CircularBuffer buffer;
    private int count;

    public Consumer(CircularBuffer buff) {
        this.buffer = buff;
        this.count = 0;
    }

    public void consumeData() {
        int data = buffer.readData();
        count++;
        System.out.println(" consume data  " + count + ": " + data);
    }

    public void run() {
        IntStream.range(0, 20).forEach(i -> {
                    while (this.buffer.bufferLength == 0) {
                        Thread.yield();
                    }
                    this.consumeData();
                }

                );
        }
    }

