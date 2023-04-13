package Internal_Structure;
import gui.Controller;
import helperClasses.ClickOperation;

import java.util.ArrayList;
import java.util.Arrays;
import javafx.application.Application;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import gui.Controller;
import gui.Controller.CursorMode;
import helperClasses.ClickOperation;
import helperClasses.Point;

public class DotsPosition {
    public ArrayList<int[]> coordinate = new ArrayList<>(); // create array storing status

    public void add(int[] TopRightCoordinate, int Length, int Width) {
        // Implementation of add function goes here
        if (TopRightCoordinate[0] % 2 == 0 && TopRightCoordinate[1] % 2 == 0) {
            for (int i = 1; i < Length + 1; i++) {
                for (int j = 1; j < Width + 1; j++) {
                    coordinate.add(new int[]{TopRightCoordinate[0] * j, TopRightCoordinate[1] * i});
                    //status[TopRightCoordinate[0] * i][TopRightCoordinate[1] * j][0] = 1;
                }
            }
        }
    }
    public void delete(int[] target) {
        // Implementation of add function goes here
        if (target[0] % 2 == 0 && target[1] % 2 == 0) {
            for (int i = 0; i < coordinate.size(); i++){
                if (Arrays.equals(target, coordinate.get(i))){
                    coordinate.remove(i);}
                //status[TopRightCoordinate[0] * i][TopRightCoordinate[1] * j][0] = 0;

            }
        }
    }

    public boolean checkDup(int[] target, ArrayList<int[]> coordinate){
        for (int i = 0; i < coordinate.size(); i++){
            if (Arrays.equals(target, coordinate.get(i))){return true;}
        }
        return false;
    }

    public void addToScreen(int height, int width){
        Controller.doOnCanvasClick(new ClickOperation(CursorMode.DOTS, click -> {
            // 'click' is the x,y location of the last mouse click (you can call it anything you want)
            int [] new_coordinate = closestpoint(click.x,click.y);
             add(new int[]{new_coordinate[0], new_coordinate[1]}, 1, 1);
             dotPrinter(coordinate);
              
            //System.out.println("Click! x:" + click.x + " y:" + click.y);
        }));
    }

    public void dotPrinter(ArrayList<int[]> coordinate){
        for (int i=0; i < coordinate.size(); i++ ){
            int [] point = coordinate.get(i);
            GraphicsContext gc = Controller.getGraphicsContext();

            gc.fillOval(point[0], point[1],5, 5);

        }

    }

    public int [] closestpoint(int x, int y){
     // x and y are cordinates of click
        x = Math.round((x-15)/20)*20+15;
        y = Math.round((y-15)/20)*20+15;
        return new int[] {x,y};


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
