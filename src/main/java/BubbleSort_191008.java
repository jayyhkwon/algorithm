import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BubbleSort_191008 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size;
        List<Integer> list = new ArrayList<Integer>();
        size = Integer.parseInt(br.readLine());

        for(int i=0; i<size; i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        int cnt = 0;
        for(int i=size-1; i>0; i--) {
            cnt++;
            boolean change = false;
            for(int j=0; j<i; j++){
                if(list.get(j) > list.get(j+1)){
                    change = true;
                    swap(list,j);
                }
            }
            if(change == false){
                System.out.println(cnt);
                break;
            }
        }
    }

    public static void swap(List<Integer> list, int idx){
        int tmp = list.get(idx);
        list.set(idx,list.get(idx+1));
        list.set(idx+1,tmp);
    }
}
