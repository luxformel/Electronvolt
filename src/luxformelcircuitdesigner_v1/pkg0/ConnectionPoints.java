/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package luxformelcircuitdesigner_v1.pkg0;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author luxformel
 */
public class ConnectionPoints {
    private static ArrayList<Point> alPoints = new ArrayList<>();

    public boolean isEmpty() {
        return alPoints.isEmpty();
    }

    public static Point get(int index) {
        return alPoints.get(index);
    }

    public static void add(Point e) {
        alPoints.add(e);
    }

    public static void clear() {
        alPoints.clear();
    }
    
    public static Point findColsestPoint(Point point){
        Point closestPoint = point;
        int X = 3_000;
        int Y = 3_000;
        int index = 0;
        if (!alPoints.isEmpty()) {
            for (int i = 0; i < alPoints.size(); i++) {
                Point potentialPoint = alPoints.get(i);
                int A = Math.abs(closestPoint.x - potentialPoint.x);
                int B = Math.abs(closestPoint.y - potentialPoint.y);
                if (A < X || B < Y) {
                    X = A;
                    Y = B;
                    index = i;
                }
            }
        }
        return alPoints.get(index);
    }
}
