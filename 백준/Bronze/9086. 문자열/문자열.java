import java.io.*;
import java.nio.Buffer;
import java.sql.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            int length = str.length();

            System.out.println(str.charAt(0)+ "" +str.charAt(length-1));


        }





    }


}