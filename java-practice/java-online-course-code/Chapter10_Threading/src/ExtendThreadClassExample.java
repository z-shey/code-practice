/*
 * @FileName: null.java
 * @Description: null.java
 *
 * @Version: 1.0.0
 * @Author: zhangjiangh03
 * @Date: 2023-10-03 14:56
 */


public class ExtendThreadClassExample {
    public static void main(String[] args) {
        PintPrimeNumber primeNumber = new PintPrimeNumber();
        primeNumber.start();

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

class PintPrimeNumber extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

