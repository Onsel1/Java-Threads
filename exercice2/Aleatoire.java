import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.Random;

public class Aleatoire {
    static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            Thread.sleep(2000);
            Integer rand = (int)(Math.random()*1000);
            return rand;
        }
    }
    public static void main(String[]args){
        //create pool
        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        //submit 100 tasks to be executed
        List<Future> futures = new ArrayList<>();
        for (int i=0; i<100; i++){
            Future<Integer> future = service.submit(new Task());
            futures.add(future);
        }
        for(int i=0; i<100; i++){
            Future<Integer> future = futures.get(i);
            try{
                Integer randNumber = future.get(2, TimeUnit.SECONDS);
                System.out.println("Future number: "+i+"'s result is: "+randNumber);
            } catch (TimeoutException e){
                System.out.println("time out exception! task isn't completed");
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
            catch (ExecutionException e){
                e.printStackTrace();
            }

        }
    }
}