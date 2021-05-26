import java.util.Date;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class WriterTask implements Runnable {
    public Deque<Event> getDeque() {
        return deque;
    }

    public void setDeque(Deque<Event> deque) {
        this.deque = deque;
    }

    private Deque<Event> deque;

    public WriterTask(Deque<Event> deque) {
        this.deque = deque;
    }

    public void run() {
        // Writes 100 events in deque
        for(int i=0; i<100; i++){
            Date date = new Date();
            Event e = new Event();
            e.setDate(date);
            e.setEvent("Event # "+ i);
            this.deque.add(e);
        }
    }
}