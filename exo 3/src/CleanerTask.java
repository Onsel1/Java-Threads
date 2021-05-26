import java.util.Date;
import java.util.Deque;
public class CleanerTask extends Thread {
    private Deque<Event> deque;

    public CleanerTask(Deque<Event> deque) {
        this.deque = deque;
    }
    public void run() {
        while (true) {
            Date date = new Date();
            clean(date);
        }
    }
    private void clean(Date date) {
        try{
            Event e = deque.getLast();
            if((e.getDate().compareTo(date))> 10){
                deque.removeLast();
            }
            else{
                System.out.println(e.getEvent());
                deque.removeLast();
            }
            System.out.println("Taille du deque"+ this.deque.size());
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
