import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static int nextNumb = 0;

    public static void main(String[] args) {

        Thread tr = new Thread("NEW Thread 2"){
            @Override
            public void run() {
                super.run();
                try {
                    for (int i=1; i<=10; i++){
                        System.out.println(this.getName() + " " + i);
                        Thread.sleep(300);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        tr.start();

        Thread tr2 = new Thread(new MyRunnable());
        tr2.start();

        jalankanThread();
    }

    private static void jalankanThread(){
        nextNumb++;
        SimpelThread simpelThread = new SimpelThread("SimpelThread " + nextNumb);
        simpelThread.start();
    }

    public static class SimpelThread extends Thread{

        public SimpelThread(String name) {
            super(name);
            this.setName(name);
        }
        @Override
        public void run() {
            super.run();    //To change body of overridden methods use File | Settings | File Templates.

            try {
                for (int i=1; i<=10; i++){
                    System.out.println(this.getName() +  " " + i);
                    Thread.sleep(200);
                }
                jalankanThread();
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
        @Override
        public synchronized void start() {
            super.start();    //To change body of overridden methods use File | Settings | File Templates.
            System.out.println("thread no " + nextNumb + " started ");
        }
    }

    private static class MyRunnable implements Runnable{

        @Override
        public void run() {

            try {
                for (int i=1; i<=10; i++){
                    System.out.println(this.getClass().getName() + " " + i);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
