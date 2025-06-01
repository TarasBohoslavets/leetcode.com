package Problem_List.Q478_Generate_Random_Point_in_a_Circle;

import java.util.Random;

class Solution {
    private double radius, x_center, y_center;
    private Random rand;

    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
        this.rand = new Random();
    }

    public double[] randPoint() {
        double angle = rand.nextDouble() * 2 * Math.PI;
        double r = Math.sqrt(rand.nextDouble()) * radius;
        double x = x_center + r * Math.cos(angle);
        double y = y_center + r * Math.sin(angle);
        return new double[]{x, y};
    }
}
