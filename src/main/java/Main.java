import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public  void main(String[] args) throws Exception{

        BufferedReader my_reader = new BufferedReader(new InputStreamReader(System.in));
        int numbers = Integer.parseInt(my_reader.readLine());
        int[] int_line = new int[4];
        int[] reversed = new int[4];
        int[] steps = new int[numbers];
        int result;
        String line;
        int i = 0;
        for (; i < numbers; i++) {
            line = my_reader.readLine();
            result = Integer.parseInt(line);

            if(result%1111 == 0){
                steps[i] = -1;
                continue;
            }
            if(result>9999||result<1000){
                steps[i] = -1;
                continue;
            }
            while(result != 6174){

                try {
                    int_line[0] = Character.getNumericValue(line.charAt(0));
                } catch (Exception e){
                    int_line[0] = 0;
                }
                try{
                    int_line[1] = Character.getNumericValue(line.charAt(1));
                } catch (Exception e){
                    int_line[1] = 0;
                }
                try{
                    int_line[2] = Character.getNumericValue(line.charAt(2));
                } catch (Exception e){
                    int_line[2] = 0;
                }
                try{
                int_line[3] = Character.getNumericValue(line.charAt(3));
                } catch (Exception e){
                    int_line[3] = 0;
                }
                Arrays.sort(int_line);
                reversed[0] = int_line[3];
                reversed[1] = int_line[2];
                reversed[2] = int_line[1];
                reversed[3] = int_line[0];

                result = (parse(reversed)-parse(int_line));
                line = Integer.toString(result);
                steps[i]++;
            }
            result = 0;
        }

        for(i = 0; i < numbers; i++){
            System.out.println(steps[i]);
        }



    }

    public static int parse(int[] number){
        return Integer.parseInt(""+number[0]+number[1]+number[2]+number[3]);
    }
    public static int check(String line){
        int[] int_line = new int[4];
        int[] reversed = new int[4];
        int steps = 0;
        int result;
        if(line.equals("9999")
                ||line.equals("1111")
                ||line.equals("2222")
                ||line.equals("3333")
                ||line.equals("4444")
                ||line.equals("5555")
                ||line.equals("6666")
                ||line.equals("7777")
                ||line.equals("8888")
        ){
            steps = -1;
            return steps;
        }
        result = Integer.parseInt(line);
        while(result != 6174){
            try {
            int_line[0] = Character.getNumericValue(line.charAt(0));
            } catch (Exception e){
                int_line[0] = 0;
            }
            try{
                int_line[1] = Character.getNumericValue(line.charAt(1));
            } catch (Exception e){
                int_line[1] = 0;
            }
            try{
                int_line[2] = Character.getNumericValue(line.charAt(2));
            } catch (Exception e){
                int_line[2] = 0;
            }
            try{
                int_line[3] = Character.getNumericValue(line.charAt(3));
            } catch (Exception e){
                int_line[3] = 0;
            }
            Arrays.sort(int_line);
            reversed[0] = int_line[3];
            reversed[1] = int_line[2];
            reversed[2] = int_line[1];
            reversed[3] = int_line[0];

            result = (parse(reversed)-parse(int_line));
            line = Integer.toString(result);
            steps++;
        }
        return steps;
    }
}

