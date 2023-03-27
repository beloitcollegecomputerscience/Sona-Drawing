package InitialSetup;

import java.util.ArrayList;
import java.util.Arrays;

public class DotsPosition {
    public static void main(String args[]){
        // small setup for showing, could be bigger by changing the numb
        ArrayList<int[]> coordinate =new ArrayList<>();    //create array storing status

        // example of how to add array into the arraylist


        //test run, whether it stores those coordinates of dots

        System.out.println("------------test run | add dots-------------");
        coordinate.add(new int[]{1, 1});
        coordinate.add(new int[]{1, 2});
        coordinate.add(new int[]{1, 3});
        System.out.println("get the x/y coordinate of a certain dots");
        System.out.println(Arrays.toString(new int[]{coordinate.get(1)[1]}));
        System.out.println(Arrays.toString(new int[]{coordinate.size()}));// should give 3
        System.out.println(Arrays.toString(coordinate.get(1))); // should give {1, 2}


        System.out.println("------------test run | delete dots-------------");
        coordinate.remove(0); //delete first one
        int[] a = {1, 2};
        System.out.println(coordinate.size());

        // delete the certain coordinate
        int pointer = 0;
        for (int i = 0; i < coordinate.size(); i++) {
            if (Arrays.equals(a, (coordinate.get(i)))) {
                coordinate.remove(i);
            }

            if (pointer == coordinate.size()) {
                break;
            }
            pointer++;
        }
        System.out.println("get the x/y coordinate of a certain dots");
        System.out.println(coordinate.size());// should give 1
        System.out.println(Arrays.toString(coordinate.get(0))); // should give {1, 2}
//        System.out.println(Arrays.toString(coordinate.get(1)));//should be fails

    }


//    public class add(int[] TopRightCoordinate, int Length, int Width){
//    }
    /*input example: {2, 2}, 2, 1
      expectation:
      1. Add the array {2, 2}, {2, 4} into the "coordinate" arraylist
      2. Change the canvas status of points with coordinate {1, 2}, {1, 4} from {0, 0, 0} into {1, 0, 0}
      Notice that:
      1. the coordinate should be detected whether it is EVEN or not at the beginning.
      2. if the matrices from two adds operation collapse with each other
      (which means that there are dots adding more than once), there should only be one record in the "coordinate" arraylist
      3. the status updates should happen right after everytime we use the add function.
      4. only the EVEN number coordinate in the canvas can set dots, ODD number coordinate positions are for lines and walls
      *. may be the insertion in arraylist could be in a certain order.
    */



//    public class delete(int[] Coordinate){
//    }

    /*input example: {1, 2}
        expectation:
        1. delete the array {1, 2} from the "coordinate" arraylist, IF IT EXIST
        2. Change the canvas status of points with coordinate {1, 2} from {1, 0, 0} back into {0, 0, 0}
        Notice that:
        1. the coordinate should be detected whether it is EVEN or not at the beginning.
        2. the status updates should happen right after everytime we use the add function.
    */



}
