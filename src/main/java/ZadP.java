import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ZadP {
    private static BufferedReader my_reader;
    private static int numbers;
    private static int relations;
    private static int x = 0;
    private static int y = 0;
    private static Graph g;
    private static String[] line;
    private static String[] people;
    private static int[] people_cost;
    private static Set<Integer> hacked = new HashSet<Integer>();
    private static Set<Integer> d = new HashSet<Integer>();
    private static int cost = 0;


    public static void main(String[] args) {
        my_reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            numbers = Integer.parseInt(my_reader.readLine());
        }
        catch (NumberFormatException | IOException e){
            numbers = 0;
        }
        g = new Graph(numbers);
        people = new String[numbers];
        people_cost = new int[numbers];
        for (int i = 0; i < numbers; i++) {
            try {
                line = my_reader.readLine().split(" ");
            }
            catch (NumberFormatException | IOException e){
                line = new String[2];
            }
            people[i] = line[0];
            people_cost[i] = Integer.parseInt(line[1]);

        }
        try {
            relations = Integer.parseInt(my_reader.readLine());
        }
        catch (NumberFormatException | IOException e){
            relations = 0;
        }

        for (int i = 0; i < relations; i++) {
            try {
                line = my_reader.readLine().split(" ");
            }
            catch (NumberFormatException | IOException e){
                line = new String[2];
            }
            for (int j = 0; j < numbers; j++) {
                if(people[j].equals(line[0])){
                    x = j;
                } else if(people[j].equals(line[1])) {
                    y = j;
                }
            }
            g.addEdge(x,y);
        }


        //Main part of code
        int max = getMax();
        while(hacked.size() < numbers){
            hacked.add(max);
            d.add(max);
            hacked.addAll(g.getEdgesOfVertex(max,hacked));
            max = getMax();
        }
        System.out.println(d.size());
        for (Integer integer : d) {
            cost += people_cost[integer];
            System.out.println(people[integer]);
        }
        System.out.println(cost);


    }

    public static int getMax(){
        double max = -1;
        int max_index = -1;

        for (int i = 0; i < numbers; i++) {
            if(!hacked.contains(i)){
                if(max == -1){
                    max = ((double)g.getNumberOfEdgesOfVertex(i,hacked))/((double)people_cost[i]);
                    max_index = i;
                    continue;
                }
                double temp = ((double)g.getNumberOfEdgesOfVertex(i,hacked))/((double)people_cost[i]);
                if(temp > max ){
                    max = temp;
                    max_index = i;
                }
            }
        }
        return max_index;
    }

}
class Graph {

    private int size;
    private boolean adjMatrix[][];

    Graph(Integer s) {
        this.size = s;
        adjMatrix = new boolean[size][size];
    }

    public void addEdge(Integer i, Integer j) {
        adjMatrix[i][j] = true;
        adjMatrix[j][i] = true;
    }

    public void removeEdge(Integer i, Integer j) {
        adjMatrix[i][j] = false;
        adjMatrix[j][i] = false;
    }

    public void displayEdgesOfVertex(List<String[]> vertices, Integer index) {
        for (int i = 0; i < adjMatrix.length; i++) {
            if (adjMatrix[index][i]) {
                System.out.println(vertices.get(index)[1] + " is connected to " + vertices.get(i)[1]);
            }
        }
    }

    public List<Integer> getEdgesOfVertex(Integer index) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < adjMatrix.length; i++) {
            if (adjMatrix[index][i]) {
                list.add(i);
            }
        }
        return list;
    }
    public List<Integer> getEdgesOfVertex(Integer index,Set<Integer> not) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < adjMatrix.length; i++) {
            if (adjMatrix[index][i]&&!not.contains(i)) {
                list.add(i);
            }
        }
        return list;
    }

    public int getNumberOfEdgesOfVertex(Integer index,Set<Integer> not){
        int result = getEdgesOfVertex(index,not).size();
        return  result > 0 ? result : 1;
    }

    public boolean isConnected(Integer source, Integer destination, List<Integer> visitedList) {
        List<Integer> visited = visitedList;
        visited.add(source);
        List<Integer> toVisit = toVisit(source, visited);
        if (existEdge(source, destination)) {
            return true;
        } else if (toVisit.stream().count() > 0) {
            return iterateToVisit(toVisit, destination, visitedList);
        }

        return false;
    }

    public List<Integer> toVisit(Integer source, List visited) {
        List<Integer> toVisit = new ArrayList<Integer>();
        for (Integer i : getEdgesOfVertex(source)) {
            if (!visited.contains(i)) {
                toVisit.add(i);
            }
        }
        return toVisit;
    }

    public boolean iterateToVisit(List<Integer> toVisit, Integer destination, List visitedList) {
        int s = toVisit.size();
        boolean[] b = new boolean[s];
        for (int i = 0; i < s; i++) {
            b[i] = isConnected(toVisit.get(i), destination, visitedList);
        }
        for (int i = 0; i < s; i++) {
            if (b[i] == true) {
                return true;
            }
        }
        return false;
    }

    public Integer size() {
        return this.size;
    }

    public boolean existEdge(Integer i, Integer j) {
        return adjMatrix[i][j];
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
            s.append(i + ": ");
            for (boolean j : adjMatrix[i]) {
                s.append((j ? 1 : 0) + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }
}
