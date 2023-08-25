import java.io.*;
import java.nio.Buffer;
import java.sql.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num != 0) {
                dq.addFirst(num);
            } else {
                dq.poll();
            }
        }

        int size = dq.size();

        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += dq.poll();
        }

        sb.append(sum);
        bw.write(sb.toString());
        bw.close();

    }
}