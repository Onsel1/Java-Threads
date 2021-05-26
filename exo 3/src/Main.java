import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args){
        Deque<Event> deque = new LinkedList<Event>();
        int pr = Runtime.getRuntime().availableProcessors();
        System.out.println(pr);
        for(int i=0; i<pr; i++){
            WriterTask wt = new WriterTask(deque);
            Thread thread = new Thread(wt);
            thread.start();
            try{
                thread.join();
            }catch(Exception e){
                System.out.println(e);
            }
            deque.addAll(wt.getDeque());
        }
        System.out.println(deque.size());
        CleanerTask ct = new CleanerTask(deque);
        ct.start();
        try{
            ct.join();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
