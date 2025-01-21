import java.util.Iterator;
import java.util.Random;

public class Multithread {
        public static void main(String[] args) throws InterruptedException {
            int transNum = 10;
            TransactionSimulation simulation = new TransactionSimulation();

            Thread[] threads = new Thread[transNum];

            long startTime = System.currentTimeMillis();
            for (int i = 0; i < transNum; i++) {
                threads[i] = new Thread(new Multi(i+1, simulation));
                threads[i].start();
            }

            for (Thread t : threads) {
                t.join();
            }

            long endTime = System.currentTimeMillis();
            System.out.println("Final Balance: " + simulation.balance);
            System.out.println("Final Balance2: " + (TransactionSimulation.INIT_BALANCE + simulation.credits - simulation.debits));
            System.out.println("Total Credits: " + simulation.credits);
            System.out.println("Total Debits: " + simulation.debits);
            long elapsedTime = endTime - startTime;
            System.out.println("Execution Time: " + elapsedTime + " milliseconds");
        }
    }

class TransactionSimulation {
    static final int INIT_BALANCE = 50;
    static final int NUM_TRANS = 1000000;
    int balance = INIT_BALANCE;
    int credits = 0;
    int debits = 0;

    public synchronized void performTransaction() {
        Random random = new Random();
        for (int i = 0; i < NUM_TRANS; i++) {
            int v = random.nextInt(NUM_TRANS);
            if (random.nextInt(2) == 0) {
                // Credit transaction
                balance += v;
                credits += v;
            } else {
                // Debit transaction
                balance -= v;
                debits += v;
            }
        }
    }
}
class Multi implements Runnable {
    private int threadNum;
    private TransactionSimulation simulation;
    Multi(int num, TransactionSimulation simulation){
        this.threadNum = num;
        this.simulation = simulation;
    }
    @Override
    public void run() {
        System.out.println("thread "+ threadNum +" is running...");
        simulation.performTransaction();
    }
}