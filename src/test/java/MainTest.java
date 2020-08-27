import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;

public class MainTest {



    @Test
    public void testMainFunction() throws Exception {
        String[] arr = new String[0];

        InputStream f = new FileInputStream("C:\\Users\\Bogdan\\Desktop\\zad1\\decode\\src\\main\\resources\\test1");
        System.setIn(f);
        ZadP.main(arr);

    }

    public int randInt(int from,int to){
        return (int)Math.round(Math.random()*to+from);
    }

}