import java.io.*;
import java.nio.Buffer;
import java.sql.Array;
import java.util.*;

public class Main {
    static int input[];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int arr [] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int num = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if(arr[i] == num){
                cnt++;
            }
        }

        System.out.println(cnt);


    }


}