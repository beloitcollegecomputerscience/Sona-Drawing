package initialSetup;

import canvas.canvas_switching;
import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        System.out.println("------------test run | add dots with add function-------------");
        DotsPosition dp = new DotsPosition();
        canvas_switching cs = new canvas_switching();
        System.out.println("dots test------------------------");
        dp.add(new int[]{140, 220}, 2,2);
        dp.add(new int[]{1000, 1000}, 2,2);
        System.out.println(DotsPosition.checkDup(new int[]{3,7}, dp.dots_coordinate));
        System.out.println(Arrays.deepToString(dp.dots_coordinate.toArray()));
        dp.delete(new int[]{-1, -1});
        dp.delete(new int[]{140, 220});
        System.out.println(DotsPosition.checkDup(new int[]{3,7}, dp.dots_coordinate));
        System.out.println(Arrays.deepToString(dp.dots_coordinate.toArray()));

    }
}

//package Internal_Structure;
//
//import java.util.Arrays;
//
//public class test {
//    public static void main(String args[]) {
//        System.out.println("------------test run | add dots with add function-------------");
//        canvas canvas = new canvas();
//        canvas.create_canvas();
//        DotsPosition dp = new DotsPosition();
//        System.out.println("print the canvas------------------------");
//        for(int i=0; i<canvas.status.length; i++){
//            for(int j=0; j<canvas.status[0].length; j++){
//                System.out.print(Arrays.toString(canvas.status[i][j])+"\t");
//            }
//            System.out.println();
//        }
//        System.out.println("dots test------------------------");
//
//        System.out.println(Arrays.deepToString(dp.dots_coordinate.toArray()));//should be empty
//        dp.dots_coordinate.add(new int[]{1, 1});
//        dp.dots_coordinate.add(new int[]{1, 2});
//        dp.dots_coordinate.add(new int[]{2, 2});
////        dp.dots_coordinate.add(new int[]{1, 3});
//        System.out.println(Arrays.deepToString(dp.dots_coordinate.toArray())); // should give [[1, 1], [1, 2], [2, 2]]
//        dp.add(new int[]{2, 2}, 2, 2, canvas.status);
//        System.out.println(Arrays.deepToString(dp.dots_coordinate.toArray()));
//        // should add [4, 2], [2, 4], [4, 4] ( where [2, 2]should not be added twice )
//        System.out.println(canvas.checkDup(new int[]{2, 9},dp.dots_coordinate)); //should return false
//        System.out.println(canvas.checkDup(new int[]{2, 4},dp.dots_coordinate)); //should return true
//
//        dp.delete(new int[]{1, 2}, canvas.status);
//        dp.delete(new int[]{1, 1}, canvas.status);
//        dp.delete(new int[]{2, 2}, canvas.status);
//        System.out.println(Arrays.deepToString(dp.dots_coordinate.toArray()));// should give [4, 2], [2, 4], [4, 4]
//        System.out.println(canvas.checkDup(new int[]{2, 2},dp.dots_coordinate)); //should return false
//
//
//        System.out.println("walls_test -------------------------- ");
//        WallsPosition wp = new WallsPosition();
//        System.out.println(Arrays.deepToString(wp.walls_coordinate_direction.toArray()));
//        wp.add(new int[]{0, 0}, 1, canvas.status);  //should not add this point(even)
//        wp.add(new int[]{1, 1}, 1, canvas.status);
//        wp.add(new int[]{1, 3}, 2, canvas.status);  //should add these two walls in
//
//
//        wp.delete(new int[]{1, 3}, canvas.status);
//        wp.delete(new int[]{1, 0}, canvas.status);
//        System.out.println(Arrays.deepToString(wp.walls_coordinate_direction.toArray()));
//
//
//        System.out.println("print the canvas------------------------");
//        for(int i=0; i<canvas.status.length; i++){
//            for(int j=0; j<canvas.status[0].length; j++){
//                System.out.print(Arrays.toString(canvas.status[i][j])+"\t");
//            }
//            System.out.println();
//        }
//        // should have [1, 0, 0] in (2, 4), (4, 2) and (4, 4), and [0, 0, 0] in rest position
//
//    }
//
//
//
//}
