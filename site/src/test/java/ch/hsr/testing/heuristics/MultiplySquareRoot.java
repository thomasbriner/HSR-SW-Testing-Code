package ch.hsr.testing.heuristics;

public class MultiplySquareRoot {
    public static int calculate(String mult1, String mult2){
        return Math.toIntExact(Math.round(Math.sqrt(Integer.parseInt(mult1)*Integer.parseInt(mult2))));
    }

}
