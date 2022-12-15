package Softeer;
import java.util.*;
import java.io.*;

public class Main_지도자동구축_Lv2 {
	public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int T = 3; // 1스테이지 한 변은 3

        for(int i = 1; i < N; i++) {
            T = (2 * T) - 1;
        }

        System.out.println(T*T);
        // System.out.println(((2 * (N + 1)) - 1) * ((2 * (N + 1)) - 1));
    }

}

//4 9 25 
//2^2 3^3 5^5 9^9 
//변이 두배 - 1 비율로 올라간다
//(2n - 1) * (2n - 1)
//1->4 는 예외처리