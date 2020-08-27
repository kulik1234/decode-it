import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public  void main(String[] args) throws Exception{

        BufferedReader my_reader = new BufferedReader(new InputStreamReader(System.in));
        int numbers;
        try {
            numbers = Integer.parseInt(my_reader.readLine());
        }
        catch (NumberFormatException e){
            numbers = 0;
        }

        int[] int_line = new int[4];
        int[] steps = new int[numbers];
        int result;
        String line;
        int i = 0;
        for (; i < numbers; i++) {
            line = my_reader.readLine();

            try {
                result = Integer.parseInt(line);
            } catch (Exception e){
                steps[i] = -1;
                continue;
            }
            if(result%1111 == 0){
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

                result = (Integer.parseInt(""+int_line[3]+int_line[2]+int_line[1]+int_line[0])-
                        Integer.parseInt(""+int_line[0]+int_line[1]+int_line[2]+int_line[3]));
                line = Integer.toString(result);
                steps[i]++;
            }
            result = 0;
        }

        for(i = 0; i < numbers; i++){
            System.out.println(steps[i]);
        }



    }
}

