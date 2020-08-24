import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testMainFunction(){
        int steps = 0;
        for (int i =0; i <= 20000 ; i++) {
             steps = Main.check(Integer.toString(i));
            System.out.println("steps: "+steps+"; i: "+i);
             assertTrue("true",steps > -2);
        }


    }

    public int randInt(int from,int to){
        return (int)Math.round(Math.random()*to+from);
    }

}