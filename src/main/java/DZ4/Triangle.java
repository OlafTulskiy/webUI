package DZ4;

public class Triangle {
    public double AreaOfTriangle(int a, int b, int c) throws MyException {
        if (a < 0 || b < 0 || c < 0) throw new MyException("One of the side is negative!");
        if (a == 0 || b == 0 || c == 0) throw new MyException("One of the side is null!");
        if ((a + b) < c || (a + c) < b || (b + c) < a ) throw new MyException("Triangle is not exist!");

        double area = 0.0;
        double halfOFPerimetr = 0;
        halfOFPerimetr = ((double)a + (double) b + (double) c) / 2;
        area = Math.sqrt(halfOFPerimetr * (halfOFPerimetr - a) * (halfOFPerimetr - b) * (halfOFPerimetr - c));
        return area;
    }
}
