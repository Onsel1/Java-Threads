import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class exemple1 extends Thread {
    private String Salutation;
    private int attente;
    private int number;
    public exemple1(String Salutation) {
        this.Salutation=Salutation;
    }
    public void run() {
        try (FileWriter file = new FileWriter(".\\log.txt"); PrintWriter pw = new PrintWriter(file);) {
            System.out.println(pw);
            for (int i = 1; i < 1000; i++)
                System.out.println(i + " " + Salutation);
         }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String args[]){
        exemple1 thread1, thread2, thread3;
        try (FileWriter file = new FileWriter(".\\log.txt"); PrintWriter pw = new PrintWriter(file);) {
            thread1 = new exemple1("Bonjour ");
            thread2 = new exemple1("Bonsoir ");
            thread3 = new exemple1("à demain ");
            System.out.println("Je suis le main :)");
            thread1.start();
            try{
                thread1.join();
            }catch (Exception exception){
                System.out.println("Exception arise "+exception);
            }
            thread2.start();
            try{
                thread2.join();
            }catch (Exception exception){
                System.out.println("Exception arise "+exception);
            }
            thread3.start();
            try{
                thread3.join();
            }catch (Exception exception){
                System.out.println("Exception arise "+exception);
            }
            System.out.println("main terminé");
            System.exit(0);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
