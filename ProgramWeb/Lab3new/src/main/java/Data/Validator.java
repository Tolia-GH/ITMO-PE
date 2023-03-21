package Data;

import Data.Dot;

public class Validator {
    public static boolean validateValues(Dot dot){
        double x = dot.getX();
        double y = Double.parseDouble(dot.getY());
        double r = dot.getR();
        return (x >= -5 && x <= 5) && (y >= -3 && y <= 3) && (r >= 0.1 && r <= 3);
    }
    public static boolean validateRange(Double x, Double y, Double r){
        //0<=x<=r,-r<=y<=0
        if( (x >= 0 && x < r) && (y <= 0 && y >= -r) ){
            return true;
        }//-r/2<=x<=0,-2rx-r<=y<=0
        else if( (x >= -r/2 && x <= 0) && (y<= 0 && y >= (-2*x-r) ) ){
            return true;
        }//y>=0,x<=0,x^2+y^2<=r*r
        else return (x <= 0) && (y >= 0) && (x*x + y*y <= r*r);
    }
}
