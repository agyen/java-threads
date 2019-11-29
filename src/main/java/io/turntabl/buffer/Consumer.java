package io.turntabl.buffer;

public class Consumer extends Thread {
    CircularBuffer buffer;
    int cont;

    public Consumer(CircularBuffer buff) {
        this.buffer = buff;
        this.cont = 0;
    }

    public void consumeData() {
        int data = buffer.readData();
        cont++;
        System.out.println("data  " + cont + ": " + data);
    }

    public void run() {
        for (int i = 0; i < 500; i++) {
            while (this.buffer.nElem == 0) {
                Thread.yield();
            }
            this.consumeData();
        }
    }
}
