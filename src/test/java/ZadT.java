import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ZadT {
    public static void main(String[] args) throws Exception {
        BufferedReader my_reader = new BufferedReader(new InputStreamReader(System.in));
        int numbers = Integer.parseInt(my_reader.readLine());
        int count = 0;
        int i = 0;
        String temp;
        char[][] results = new char[numbers][];
        for (; i < numbers; i++) {
            count = Integer.parseInt(my_reader.readLine());
            String pass = my_reader.readLine();
            results[i] = new char[count];
            for (int j = 0; j < count; j++) {
                temp = pass.substring(j*4,(j+1)*4);
                results[i][j] = (char)(Integer.parseInt(temp.substring(0,1)+""+temp.substring(2,3))+Integer.parseInt(temp.substring(1,2)+""+temp.substring(3,4)));
            }
        }
        for(i =0; i < numbers;i++){
            System.out.println(new String(results[i]));
        }
    }
}
