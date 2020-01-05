import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable {

    private int id;

    public Processor(int id){
        this.id = id;
    }
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + " : Started : " + id);

        // do Something
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " : Completed : " + id);
    }

}

public class App{

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        for(int i=1; i<=10; i++){
            executor.execute(new Processor(i));
//            executor.submit(new Processor(i));
        }

        // 더 이상 새로운 task를 받지 않음
        executor.shutdown();

        try {
            // shutdown() 호출한 후 남은 task들이 timeout 시간내로 끝나길 기다린다.
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All tasks completed");

    }
}
