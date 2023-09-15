
class ChickenThread extends Thread {
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Курица");
                sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class EggThread extends Thread {

    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Яйцо");
                sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ChickenThread chickenThread = new ChickenThread();
        EggThread eggThread = new EggThread();

        chickenThread.start();
        eggThread.start();

        while (chickenThread.isAlive() || eggThread.isAlive()) {
            try {
                chickenThread.join();
                eggThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (chickenThread.isAlive()) {
            System.out.println("Яйцо появилось сначала!");
        } else {
            System.out.println("Курица появилась сначала!");
        }
    }
}