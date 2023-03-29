package Internal_Structure;

import java.util.ArrayList;
import java.util.Arrays;

public class WallsPosition {

    public ArrayList<int[]> walls_coordinate_direction = new ArrayList<>(); // create array storing status
    // [x, y, z] , x,y represent coordinate, z represent horizontal (1) /vertical (2)

    public void add(int[] coordinate, int orientation,int[][] status[]) {
        // Implementation of add function goes here
        if (coordinate[0] % 2 == 1 && coordinate[1] % 2 == 1) {
                    if  (!canvas.checkDup(new int[]{coordinate[0] , coordinate[1], orientation}, walls_coordinate_direction)){
                        walls_coordinate_direction.add(new int[]{coordinate[0], coordinate[1], orientation});
                        status[coordinate[0]][coordinate[1]][1] = orientation;
                    }

                }


    }



    public void delete(int[] target, int[][] status[]) {
        // Implementation of add function goes here
        if (target[0] % 2 == 1 && target[1] % 2 == 1) {
            for (int i = 0; i < walls_coordinate_direction.size(); i++){
                if (Arrays.equals(target, new int[] {walls_coordinate_direction.get(i)[0],walls_coordinate_direction.get(i)[1]})){
                    walls_coordinate_direction.remove(i);
                    status[target[0]][target[1]][1] = 0;
                }
            }
        }
    }



////  test runs:
//
//    public static void main(String args[]) {
//        DotsPosition dotsPosition = new DotsPosition(); // create an instance of DotsPosition
//        dotsPosition.test(); // call the test method
//    }
//
//    public void test() {
//        // test run, whether it stores those coordinates of dots
//        System.out.println("------------test run | add dots-------------");
//        dots_coordinate.add(new int[]{1, 1});
//        dots_coordinate.add(new int[]{1, 2});
//        dots_coordinate.add(new int[]{1, 3});
//        System.out.println("get the x/y coordinate of a certain dots");
//        System.out.println(Arrays.toString(new int[]{dots_coordinate.get(1)[1]}));
//        System.out.println(Arrays.toString(new int[]{dots_coordinate.size()}));// should give 3
//        System.out.println(Arrays.toString(dots_coordinate.get(1))); // should give {1, 2}
//
//        System.out.println("------------test run | delete dots-------------");
//        dots_coordinate.remove(0); //delete first one
//        int[] a = {1, 2};
//        System.out.println(dots_coordinate.size());
//
//        // delete the certain coordinate
//        int pointer = 0;
//        for (int i = 0; i < dots_coordinate.size(); i++) {
//            if (Arrays.equals(a, (dots_coordinate.get(i)))) {
//                dots_coordinate.remove(i);
//            }
//
//            if (pointer == dots_coordinate.size()) {
//                break;
//            }
//            pointer++;
//        }
//        System.out.println("get the x/y coordinate of a certain dots");
//        System.out.println(dots_coordinate.size());// should give 1
//        System.out.println(Arrays.toString(dots_coordinate.get(0))); // should give {1, 2}
////        System.out.println(Arrays.toString(coordinate.get(1)));//should be fails
//
//        System.out.println("------------test run | add dots with add method-------------");
//        //int[] TopRightCoordinate = {2, 2};
//        int Length = 2;
//        int Width = 1;
//        //add(TopRightCoordinate, Length, Width); // add dots
//        System.out.println(Arrays.toString(dots_coordinate.get(0))); // should give {1, 2}
//       // System.out.println(Arrays.toString(dots_coordinate.get(1))); // should give {2, 2}
//       // System.out.println(Arrays.toString(dots_coordinate.get(2))); // should give {2, 3}
//       // System.out.println(Arrays.toString(dots_coordinate.get(3))); // should give {1, 3}
//    }
}
