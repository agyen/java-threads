package io.turntabl.buffer;

public class CircularBuffer {
    volatile int[] array;
    private volatile int end;
    private volatile int front;
    volatile int bufferLength;
    private final Object lock = new Object();

    public CircularBuffer(int[] array) {
        this.array = array;
        this.end = 0;
        this.front = 0;
        this.bufferLength = 0;
    }

    public void writeData (int data) {
        synchronized (lock) {
            this.array[end] = data;
            this.end = (end + 1) % array.length;
            this.bufferLength++;
        }
    }

        public synchronized int readData() {
            synchronized (lock) {
                int data = array[front];
                this.front = (front + 1) % array.length;
                this.bufferLength--;
                return data;
            }
        }
    }