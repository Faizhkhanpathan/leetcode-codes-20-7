class Solution {
    public double separateSquares(int[][] squares) {
        double totalArea = 0;
        double low=2e9;
        double high=0;
        for(int[] sq:squares){
            double y=sq[1];
            double l=sq[2];
            totalArea += (double)(l * l);

            low=Math.min(low,y);
           high = Math.max(high, y + l);

        }
        double halfArea=totalArea/2.0;
        for(int i=0;i<100;i++){
            double mid=low+(high-low)/2.0;
            if (helper_calculateArea(squares, mid) >= halfArea) {

                high=mid;
            }else{
                low=mid;
            }
        }
        return high;
    }
    public double helper_calculateArea(int[][] squares, double currentY) {
        double area = 0;
        for (int[] sq : squares) {
    double y = sq[1];

            double l=sq[2];
            double top = y + l;

            if (y >= currentY) {
            continue;
        } else if (top <= currentY) {
            area += l * l;
        } else {
            area += l * (currentY - y);
        }
    }
        return area;
    }
}