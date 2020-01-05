import java.math.BigInteger;
import java.util.Scanner;

/*
* 1914번 문제
*
* 세 개의 장대가 있고 첫 번째 장대에는 반경이 서로 다른 n개의 원판이 쌓여 있다.
* 각 원판은 반경이 큰 순서대로 쌓여있다.
* 이제 수도승들이 다음 규칙에 따라 첫 번째 장대에서 세 번째 장대로 옮기려 한다.
* 한 번에 한 개의 원판만을 다른 탑으로 옮길 수 있다.
* 쌓아 놓은 원판은 항상 위의 것이 아래의 것보다 작아야 한다.
* 이 작업을 수행하는데 필요한 이동 순서를 출력하는 프로그램을 작성하라. 단, 이동 횟수는 최소가 되어야 한다.
*
* 입력 : 첫째 줄에 첫 번째 장대에 쌓인 원판의 개수 N (1 ≤ N ≤ 100)이 주어진다.
*
* 출력 : 첫째 줄에 옮긴 횟수 K를 출력한다.
* N이 20 이하인 입력에 대해서는 두 번째 줄부터 수행 과정을 출력한다.
* 두 번째 줄부터 K개의 줄에 걸쳐 두 정수 A B를 빈칸을 사이에 두고 출력하는데,
* 이는 A번째 탑의 가장 위에 있는 원판을 B번째 탑의 가장 위로 옮긴다는 뜻이다.
* N이 20보다 큰 경우에는 과정은 출력할 필요가 없다.
*
 * */
public class Hanoi_191029 {

    static void hanoi(int num, char one, char two, char three)
    {
        if(num == 1)
            System.out.println(one + " " + three);

        else
        {
            // Step 1 : 1번 -> 3번 -> 2번 (n-1번)
            // 마지막 원판을 제외한 원판을 2번 장대로 옮긴다.
            hanoi(num - 1, one, three, two);
            // Step 2 : 1번 -> 3번 (1번)
            // 마지막 원판을 3번으로 옮긴다.
            System.out.println(one + " " + three);
            // Step 3 : 2번 -> 3번 (n-1번)
            // 2번 장대에 있는 n-1개의 원판을 3번으로 옮긴다.
            hanoi(num - 1, two, one, three);
        }

    }

    public static void main(String[] args)
    {
        // 입력 값이 최대 2^100-1이므로 BigInteger 사용한다.
        BigInteger c = new BigInteger("2");
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        c = c.pow(n).subtract(BigInteger.ONE);

        System.out.println(c);

        if(n <= 20)
            hanoi(n,'1','2','3');
    }

}
