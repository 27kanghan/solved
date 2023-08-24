import java.io.*;
import java.nio.Buffer;
import java.sql.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Deque <Integer> card = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        // 덱에 카드 삽입. 1~N까지
        for (int i = 1; i <= N; i++){
            card.add(i);
        }
        
        //이제 작업해야함. 큐가 빌 때 까지.
        while (true){
            //큐 맨 처음꺼 뽑고
           sb.append(card.poll()).append(" ");
            // 그 다음거 큐 맨 뒤로
            // 근데 큐가 비어있으면 끝내야함
            if(card.isEmpty()){
                break;
            }else {
                card.addLast(card.poll());
            }

        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}
