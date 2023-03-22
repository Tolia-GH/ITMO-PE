package Data;

public class Validator {
    public static boolean validateValues(Dot dot){
        double x = dot.getX();
        double y = dot.getY();
        double r = dot.getR();
        return (x >= -3 && x <= 3) && (y >= -5 && y <= 5) && (r >= 1 && r <= 4);
    }
    public static boolean validateRange(Double x, Double y, Double r){

        if(x >= 0 && y >= 0) {
            return x <= r && y <= r;
        }
        else if(x < 0 && y > 0) {
            return (2 * x + r) > y;
        } else if (x < 0 && y < 0) {
            return x * x + y * y <= (r/2) * (r/2);
        } else {
            return false;
        }
    }
}
