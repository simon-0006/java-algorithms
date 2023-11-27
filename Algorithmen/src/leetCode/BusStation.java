package leetCode;

import java.util.Arrays;
import java.util.HashMap;

public class BusStation {
	
	
	private static HashMap <Integer, Integer[]> connections;
    private static boolean[] line;

    public static void main(String[] args) {
    	int[][] routes = new int[][] {{1,2,7},{3,6,7}};
    	System.out.println(numBusesToDestination(routes, 1, 6));
    }
    
    public static int numBusesToDestination(int[][] routes, int source, int target) {
        connections = new HashMap<Integer, Integer[]>();
        line = new boolean[routes.length];
        Hashfiller(routes);
        for(int[] tester: routes) {for(int jojo: tester) {System.out.println(jojo + " | " +Arrays.toString(connections.get(jojo)));}}
        return BusCircle(routes, source, target, -1, connections.get(source)[0]);
    }

    private static void Hashfiller(int[][] routes) {
        for(int i = 0; i < routes.length; i++) {
            for(int j = 0; j< routes[i].length; j++) {
                if(connections.containsKey(routes[i][j])) {
                    Integer[] tmp = connections.get(routes[i][j]);
                    int k = 0;
                    while(tmp[k] != -1) k++;
                    tmp[k] = i;
                    connections.put(routes[i][j], tmp);
                } else {
                    Integer[] tmp = new Integer[routes.length];
                    Arrays.fill(tmp, -1);
                    tmp[0] = i;
                    connections.put(routes[i][j], tmp);
                }
            }
        }
    }

    private static int BusCircle(int[][] routes, int source, int target, int number, int tmpSource) {
        /*
        * tmpsource == index of route
        * target == bus stop target
        * number == how many different bus connections
        */

        // Basecases (if we circled to the same bus connection again)
        if(tmpSource == -1) return -1;
        if(line[tmpSource]) return -1;
        else line[tmpSource] = true;

        // Iteration through all bus stops
        for(int stop = 0; stop < routes[tmpSource].length; stop++) {
            // if tmpSource == original source then tmpSource = 1
            if(routes[tmpSource][stop] == target) return number;

            // Iteration through all possible bus connections
            for(int connection : connections.get(routes[tmpSource][stop])) {
                int busConLength = BusCircle(routes, source, target, number + 1, connection);
                number = (busConLength != -1 && busConLength < number) ? busConLength : number;
            }
        }


        return number;

    }
}
