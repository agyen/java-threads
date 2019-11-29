package io.turntabl.buffer;

public class Producer extends Thread{
CircularBuffer buffer;
    int bufferTam;
    int contData;

    public Producer(CircularBuffer buff) {
        this.buffer = buff;
        this.bufferTam = buffer.array.length;
        this.contData = 0;

    }

    public void produceData() {
        this.contData++;
        this.buffer.writeData(contData);
    }

    public void run() {
        for (int i = 0; i < 500; i++) {
            while (this.buffer.nElem == this.bufferTam) {
                Thread.yield();
            }
            this.produceData();
        }
    }
}
