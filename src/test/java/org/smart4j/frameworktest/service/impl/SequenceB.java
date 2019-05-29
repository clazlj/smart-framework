package org.smart4j.frameworktest.service.impl;

import org.smart4j.frameworktest.service.ClientThread;
import org.smart4j.frameworktest.service.Sequence;

/**
 * 线程安全ThreadLocal
 */
public class SequenceB implements Sequence {
    /**
     * 对于不同的线程，变量未被共享，而是每个线程各一份
     * ThreadLocal为每个线程提供了一个独立的副本
     */
    private static ThreadLocal<Integer> numberContainer = ThreadLocal.withInitial(() -> 0);


    @Override
    public int getNumber() {
        numberContainer.set(numberContainer.get() + 1);
        return numberContainer.get();
    }

    public static void main(String[] args) {
        Sequence sequence = new SequenceB();

        ClientThread thread1 = new ClientThread(sequence);
        ClientThread thread2 = new ClientThread(sequence);
        ClientThread thread3 = new ClientThread(sequence);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
