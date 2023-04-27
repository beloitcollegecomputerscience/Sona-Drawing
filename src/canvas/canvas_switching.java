package canvas;

import java.util.Arrays;


public class canvas_switching {

    public static int interval_space = 20;
    public static int frame_space = 80;
    public static int[] Max_PixelCoordinate = {800, 600};
    private static final int[] Max_StructuralCoordinate = {(Max_PixelCoordinate[0] - 2 * frame_space)/ interval_space,
            (Max_PixelCoordinate[1] - 2 * frame_space )/ interval_space};


    public static int[] PixelCanvas_to_DotsSpots(int[] PixelCanvas_coordinate) {
        int i = (PixelCanvas_coordinate[0] - frame_space )/interval_space/2;
        int j = (PixelCanvas_coordinate[1] - frame_space )/interval_space/2;
        if (i >= 0 && j >= 0 && i <= Max_StructuralCoordinate[0]/2 && j <= Max_StructuralCoordinate[1]/2) {
            return new int[] {i*2+1, j*2+1 };}
        else {
            return new int[] {-1, -1};}
    }


    public static int[] PixelCanvas_to_LinesSpots (int[] PixelCanvas_coordinate) {
        int a = (PixelCanvas_coordinate[0] - frame_space) / interval_space;
        int b = (PixelCanvas_coordinate[1] - frame_space) / interval_space / 2;
        if (a >= 0 && b >= 0 && a <= Max_StructuralCoordinate[0] / 2 && b <= Max_StructuralCoordinate[1] / 2) {
            if (a % 2 == 0) {
                return new int[]{a, b * 2 + 1};}
            else {
                return new int[]{a, b * 2};}
        } else {
            return new int[]{-1, -1};}
    }


    public static int[] StructuralCanvas_to_PixelCanvas (int[] DotsCanvas_coordinate) {
        int i = DotsCanvas_coordinate[0] * interval_space + frame_space;
        int j = DotsCanvas_coordinate[1] * interval_space + frame_space;
        if (DotsCanvas_coordinate[0]>=0 && DotsCanvas_coordinate[1] >=0
                && DotsCanvas_coordinate[0] <= Max_StructuralCoordinate[0]
                && DotsCanvas_coordinate[1] <= Max_StructuralCoordinate[1]) {
            return new int[]{i, j};}
        else {
            return new int[] {-1, -1};}
    }





//
//    public static void main(String[] args) {
//        System.out.println(Arrays.toString(StructuralCanvas_to_PixelCanvas(PixelCanvas_to_DotsSpots(new int[]{140, 220}))));
//        System.out.println(Arrays.toString(PixelCanvas_to_DotsSpots(new int[]{140, 220})));
//        System.out.println(Arrays.toString(StructuralCanvas_to_PixelCanvas(PixelCanvas_to_LinesSpots(new int[]{140, 220}))));
//        //should return [120, 200] and [140, 220] for dots position and lines position
//
//        System.out.println(Arrays.toString(StructuralCanvas_to_PixelCanvas(PixelCanvas_to_DotsSpots(new int[]{140, 0}))));
//        System.out.println(Arrays.toString(StructuralCanvas_to_PixelCanvas(PixelCanvas_to_LinesSpots(new int[]{1000, 220}))));
//        //both should return [-1， -1]  for dots position and lines position, since it is "outside"
//    }
}





