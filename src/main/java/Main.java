import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader my_reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = my_reader.readLine().split(" ");
        long currentTime = System.currentTimeMillis();
        int columns = Integer.parseInt(line[0]);
        int corals = Integer.parseInt(line[1]);
        int[] result = new int[columns];
        int result_r = 1;
        int i = 0;
        for (; i < corals; i++) {
            result[i%columns]+=2;
        }
        for (i=0; i < columns; i++) {
            result_r *= result[i]+2;
        }
        System.out.println(result_r);

        System.out.println("time of programme: "+(System.currentTimeMillis()-currentTime));
    }
}
