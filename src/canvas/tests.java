package canvas;

import java.util.Arrays;


public class tests {

    public static int interval_space = 2;
    public static int frame_space = 8;
    public static int[] Max_PixelCoordinate = {32, 24};
    private static final int[] Max_StructuralCoordinate = {(Max_PixelCoordinate[0] - 2 * frame_space)/ interval_space,
            (Max_PixelCoordinate[1] - 2 * frame_space )/ interval_space};


    public static int[] PixelCanvas_to_DotsSpots(int[] PixelCanvas_coordinate) {
        int i = (int) Math.floor((double)(PixelCanvas_coordinate[0] - frame_space) / interval_space / 2);
        int j = (int) Math.floor((double)(PixelCanvas_coordinate[1] - frame_space )/interval_space/2);
        if (i >= 0 && j >= 0 && i <= Max_StructuralCoordinate[0]/2 && j <= Max_StructuralCoordinate[1]/2) {
            return new int[] {i*2+1, j*2+1 };}
        else {
            return new int[] {-1, -1};}
    }



//
    public static int[] PixelCanvas_to_LinesSpots (int[] PixelCanvas_coordinate) {
        int a = (int) Math.floor((double)(PixelCanvas_coordinate[0] - frame_space) / interval_space);
        int b = (int) Math.floor((double)(PixelCanvas_coordinate[1] - frame_space )/interval_space/2);
        if ( a >= 0 && b >= 0 && a <= Max_StructuralCoordinate[0]  && b <= Max_StructuralCoordinate[1] /2) {
            if (a % 2 == 0) {
                return new int[]{a, b * 2 + 1};}
            else {
                return new int[]{a, b * 2};}}
        else {
            return new int[]{-1, -1};}
    }

//
    public static int[] StructuralCanvas_to_PixelCanvas (int[] StructuralCanvas_coordinate) {
        int x = StructuralCanvas_coordinate[0] * interval_space + frame_space;
        int y = StructuralCanvas_coordinate[1] * interval_space + frame_space;
        if (StructuralCanvas_coordinate[0]>=0 && StructuralCanvas_coordinate[1] >= 0
                && StructuralCanvas_coordinate[0] <= Max_StructuralCoordinate[0]
                && StructuralCanvas_coordinate[1] <= Max_StructuralCoordinate[1]) {
            return new int[]{x, y};}
        else {
            return new int[] {-1, -1};}
    }






    public static void main(String[] args) {
        System.out.println("----------- test on dots ------------");
        System.out.println(Arrays.toString(StructuralCanvas_to_PixelCanvas(PixelCanvas_to_DotsSpots(new int[]{12,10}))));
        //[14,10]
        System.out.println(Arrays.toString(StructuralCanvas_to_PixelCanvas(PixelCanvas_to_DotsSpots(new int[]{12,12}))));
        //[14, 14]
        System.out.println(Arrays.toString(StructuralCanvas_to_PixelCanvas(PixelCanvas_to_DotsSpots(new int[]{9, 13}))));
        //[10, 14]
        System.out.println(Arrays.toString(PixelCanvas_to_DotsSpots(new int[]{9, 13})));
        //[1, 3]
        System.out.println(Arrays.toString(StructuralCanvas_to_PixelCanvas(PixelCanvas_to_DotsSpots(new int[]{5, 15}))));
        //[-1, -1]


        System.out.println(Arrays.toString(StructuralCanvas_to_PixelCanvas(PixelCanvas_to_LinesSpots(new int[]{18, 10}))));
        //[18,8]
        System.out.println(Arrays.toString(PixelCanvas_to_LinesSpots(new int[]{18, 10})));
        //[5,0]
        System.out.println(Arrays.toString(StructuralCanvas_to_PixelCanvas(PixelCanvas_to_LinesSpots(new int[]{19, 14}))));
        //[18,12]
        System.out.println(Arrays.toString(StructuralCanvas_to_PixelCanvas(PixelCanvas_to_LinesSpots(new int[]{20,16}))));
        //[-1,-1]
        System.out.println(Arrays.toString(StructuralCanvas_to_PixelCanvas(PixelCanvas_to_LinesSpots(new int[]{22,16}))));
        //[20,16]
    }
}





