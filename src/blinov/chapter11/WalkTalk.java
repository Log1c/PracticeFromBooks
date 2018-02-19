package blinov.chapter11;

public class WalkTalk {
    public static void main(String[] args) {
        TalkThread talk = new TalkThread();
        Thread walk = new Thread(new WalkRunnable());

        talk.start();
        walk.start();

//        WalkRunnable w = new WalkRunnable();
//        w.run();

    }
}
