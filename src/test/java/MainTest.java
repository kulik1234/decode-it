import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testMainFunction(){
        List<int[]> data = new ArrayList<int[]>();
        int[] temp = new int[3];
        for (int i = 0; i < 100; i++) {
            temp[0] = randInt(1,20);
            temp[1] = randInt(1,30);
            temp[2] = randInt(1,15);
            data.add(temp);
        }


    }

    public int randInt(int from,int to){
        return (int)Math.round(Math.random()*to+from);
    }

}