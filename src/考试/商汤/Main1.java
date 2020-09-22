package 考试.商汤;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double Ax = sc.nextDouble();
        double Ay = sc.nextDouble();
        int n = sc.nextInt();
        Double[] x = new Double[n];
        Double[] y = new Double[n];


        for (int i = 0; i < n; i++) {
            x[i] = sc.nextDouble();
            y[i] = sc.nextDouble();
        }

        double min = Integer.MAX_VALUE;
        for (int i = 0; i < n-1; i++) {
            double v = pointToSegmentDist(Ax, Ay, x[i], y[i], x[i + 1], y[i + 1]);
            if (v<min) {
                min=v;
            }
        }
        System.out.println(min);

    }

    private static double pointToSegmentDist(double px, double py, double ax, double ay, double bx, double by) {
        double ABx = bx - ax;
        double ABy = by - ay;
        double APx = px - ax;
        double APy = py - ay;

        double AB_AP = ABx * APx + ABy * APy;
        double distAB2 = ABx * ABx + ABy * ABy;

        double Dx = ax, Dy = ay;
        if (distAB2 != 0) {
            double t = AB_AP / distAB2;
            if (t >= 1) {
                Dx = bx;
                Dy = by;
            } else if (t > 0) {
                Dx = ax + ABx * t;
                Dy = ay + ABy * t;
            } else {
                Dx = ax;
                Dy = ay;
            }
        }

        double PDx = Dx - px, PDy = Dy - py;

        return Math.sqrt(PDx * PDx + PDy * PDy);
    }
}
