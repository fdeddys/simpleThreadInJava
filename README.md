# Simple Thread In Java

1. Create Thread 
 Thread tr = new Thread("NEW Thread 2"){
            @Override
            public void run() {}
 }
 tr.start();
 
2. Class extend Thread 
 public static class SimpelThread extends Thread {
        @Override
        public void run() {}
 }
 SimpelThread simpelThread = new SimpelThread("SimpelThread " + nextNumb);
 simpelThread.start();
 
3. Class implement Runnable
 private static class MyRunnable implements Runnable{
        @Override
        public void run() {}
 }
 Thread tr2 = new Thread(new MyRunnable());
 tr2.start();
