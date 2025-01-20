import java.util.Iterator;
import java.util.Random;

public class Multithread {
        public static void main(String[] args) {
            int transNum = 10;
            for(int i=1;i<=transNum;i++){
                Multi m = new Multi(i);
                Thread t = new Thread(m);
                t.start();
            }
//            long startTime = System.currentTimeMillis();
//            TransactionSimulation simulation = new TransactionSimulation();
//            simulation.performTransaction();
//            long endTime = System.currentTimeMillis();
//            System.out.println("Final Balance: " + simulation.balance);
//            System.out.println("Final Balance2: " + (TransactionSimulation.INIT_BALANCE + simulation.credits - simulation.debits));
//            System.out.println("Total Credits: " + simulation.credits);
//            System.out.println("Total Debits: " + simulation.debits);
//            long elapsedTime = endTime - startTime;
//            System.out.println("Execution Time: " + elapsedTime + " milliseconds");
        }
    }

class TransactionSimulation {
    static final int INIT_BALANCE = 50;
    static final int NUM_TRANS = 1000000;
    int balance = INIT_BALANCE;
    int credits = 0;
    int debits = 0;

    public void performTransaction() {
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
class Multi extends Thread {
    private int threadNum;

    Multi(int num){
        this.threadNum = num;
    }
    @Override
    public void run() {
        System.out.println("thread "+ threadNum +" is running...");
        long startTime = System.currentTimeMillis();
        TransactionSimulation simulation = new TransactionSimulation();
        simulation.performTransaction();
        long endTime = System.currentTimeMillis();
        System.out.println("Final Balance: " + simulation.balance);
        System.out.println("Final Balance2: " + (TransactionSimulation.INIT_BALANCE + simulation.credits - simulation.debits));
//        System.out.println("Total Credits: " + simulation.credits);
//        System.out.println("Total Debits: " + simulation.debits);
        long elapsedTime = endTime - startTime;
//        System.out.println("Execution Time: " + elapsedTime + " milliseconds");
    }
}