package io.turntabl.buffer;

public class CircularBuffer {
    volatile int[] array;
    volatile int p;
    volatile int c;
    volatile int nElem;

    public CircularBuffer(int[] array) {
        this.array = array;
        this.p = 0;
        this.c = 0;
        this.nElem = 0;
    }

    public synchronized void writeData (int data) {
        this.array[p] = data;
        this.p = (p + 1) % array.length;
        this.nElem++;
    }

    public synchronized int readData() {
        int data = array[c];
        this.c = (c + 1) % array.length;
        this.nElem--;
        return data;
    }
}
