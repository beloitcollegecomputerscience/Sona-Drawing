package initialSetup;

import canvas.canvas_switching; 

import java.util.ArrayList;
import java.util.Arrays;
import javafx.geometry.Point2D;

public class DotsPosition {
    public ArrayList<int[]> dots_coordinate = new ArrayList<>(); // create array storing status
    canvas_switching cs = new canvas.canvas_switching();
    public void add(int[] TopRightCoordinate, int Length, int Width) {
        int[] TopRightDots = cs.PixelCanvas_to_DotsSpots(TopRightCoordinate);
        int[] false_value = new int[]{-1,-1};
        if (!Arrays.equals(TopRightDots, false_value)){
        for (int i = 0; i < Length; i++) {
            for (int j = 0; j < Width; j++) {
                int [] new_dots = {TopRightDots[0] + 2*j,TopRightDots[1] + 2*i};
                if  ((!checkDup(new_dots, dots_coordinate)) &&
                        !Arrays.equals(cs.StructuralCanvas_to_PixelCanvas(new_dots), false_value)){
                    dots_coordinate.add(new_dots);}}}}
    }


    public static boolean checkDup(int[] target, ArrayList<int[]> coordinate){
        for (int i = 0; i < coordinate.size(); i++){
            if (Arrays.equals(target, coordinate.get(i))){return true;}
        }
        return false;
    }


    public void delete(int[] target) {
        int[] targetDots = cs.PixelCanvas_to_DotsSpots(target);
        // Implementation of add function goes here
            for (int i = 0; i < dots_coordinate.size(); i++){
                if (Arrays.equals(targetDots, dots_coordinate.get(i))){
                    dots_coordinate.remove(i);}
        }
    }
    public boolean getCanvasDots(int [] target){
        for (int i = 0; i < dots_coordinate.size(); i++){
            if (Arrays.equals(target, dots_coordinate.get(i))){return true;}
        }
        return false; 
    }
    
   public int[][] two_closest_point(int[] walls_position_coordinate) {
        double [] euclidean_distance_list = new double[dots_coordinate.size()];
        Point2D point1 = new Point2D(walls_position_coordinate[0], walls_position_coordinate[1]);

        for (int i = 0; i < dots_coordinate.size(); i++) {
            Point2D point2 = new Point2D(dots_coordinate.get(i)[0], dots_coordinate.get(i)[1]);
            euclidean_distance_list[i] = point1.distance(point2);
        }

        Arrays.sort(euclidean_distance_list);

        int first_closest = euclidean_distance_list[0];
        int second_closest = euclidean_distance_list[1];

        return new int[][] {{first_closest}, {second_closest}};
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
