import java.util.*;

public class ZadT {
    public void main(String[] args) throws Exception {
        Long start = System.currentTimeMillis();
        List<int[]> conns = new ArrayList<>();
        List<String[]> ips = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String string;
        String[] line = new String[3];
        int i = 0;
        int x = 0;
        int y = 0;
        try {
        while ((string = sc.nextLine()) != null){
                line = string.split(" ");
                if(line[0].equals("B")) {
                    String[] finalLine = line;
                    String[] a = null;
                    for(String[] e : ips){
                        if(e[1] != null && e[1].equals(finalLine[1])){
                            a = e;
                            break;
                        } else {
                            a = null;
                        }
                    }
                    if(a !=null){
                        x = Integer.parseInt(a[0]);
                    }
                    else {
                        x = i;
                        String[] nA = new String[2];
                        nA[0] = Integer.toString(i);
                        nA[1] = finalLine[1];
                        i++;
                        ips.add(nA);
                    }
                    for(String[] e : ips){
                        if(e[1] != null && e[1].equals(finalLine[2])){
                            a = e;
                            break;
                        } else {
                            a = null;
                        }
                    }
                    if(a != null){
                        y = Integer.parseInt(a[0]);
                    }
                    else {
                        y = i;
                        String[] nB = new String[2];
                        nB[0] = Integer.toString(i);
                        nB[1] = finalLine[2];
                        i++;
                        ips.add(nB);
                    }
                    int[] c = new int[2];
                    c[0] = x;
                    c[1] = y;
                    conns.add(c);
                }
                else if(line[0].equals("T")) {
                    Graph g = new Graph(ips.size());
                    for(int[] e : conns){
                        g.addEdge(e[0],e[1]);
                    }

                    String[] finalLine = line;
                    String[] a = null;
                    for(String[] e : ips){
                        if(e[1].equals(finalLine[1])){
                            a = e;
                            break;
                        } else {
                            a = null;
                        }
                    }
                    String[] b = null;
                    for(String[] e : ips){
                        if(e[1].equals(finalLine[2])){
                            b = e;
                            break;
                        } else {
                            b = null;
                        }
                    }

                    if(a != null && b != null){
                        if(g.isConnected(Integer.parseInt(a[0]),Integer.parseInt(b[0]),new ArrayList<Integer>())) {
                            System.out.println("T");
                        }
                        else {
                            System.out.println("N");
                        }
                    } else {
                        System.out.println("N");
                    }

                }
        }} catch (NoSuchElementException e){
            System.out.println(System.currentTimeMillis() - start);
            System.exit(0);
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}

