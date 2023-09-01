import java.io.*;
import java.nio.Buffer;
import java.sql.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr [] = new int[N];


        for (int i = 0; i < N; i++) {
            arr[i] = i+1;
        }

        for (int i = 0; i < M; i++) {
            int index = 0;
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            index = arr[b-1];

            arr[b-1] = arr[a-1];

            arr[a-1] = index;
        }


        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }


    }


}