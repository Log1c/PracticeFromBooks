package blinov.chapter11;

public class WalkRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("walking");
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
    }
}
