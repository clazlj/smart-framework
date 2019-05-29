package org.smart4j.frameworktest.service.impl;

import org.smart4j.frameworktest.service.ClientThread;
import org.smart4j.frameworktest.service.Sequence;

/**
 * 非线程安全
 */
public class SequenceA implements Sequence {
    /**
     * 不同的线程共享该变量
     */
    private static int number = 0;

    @Override
    public int getNumber() {
        number = number + 1;
        return number;
    }

    public static void main(String[] args) {
        Sequence sequence = new SequenceA();

        ClientThread thread1 = new ClientThread(sequence);
        ClientThread thread2 = new ClientThread(sequence);
        ClientThread thread3 = new ClientThread(sequence);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
