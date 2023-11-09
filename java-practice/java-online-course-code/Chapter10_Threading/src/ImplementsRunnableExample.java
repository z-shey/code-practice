/*
 * @FileName: null.java
 * @Description: null.java
 *
 * @Version: 1.0.0
 * @Author: zhangjiangh03
 * @Date: 2023-10-03 15:25
 */

class EvenNumberPrint implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

public class ImplementsRunnableExample {
    public static void main(String[] args) {
        EvenNumberPrint evenNumberPrint = new EvenNumberPrint();

        Thread thread = new Thread(evenNumberPrint);
        thread.start();

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }

        Thread thread1 = new Thread(evenNumberPrint);
        thread1.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + ": " + i);
                    }
                }
            }
        }).start();

    }
}


