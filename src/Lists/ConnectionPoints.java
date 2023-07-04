/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lists;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author luxformel
 */
public class ConnectionPoints {
    private static ArrayList<Point> alPoints = new ArrayList<>();

    public static boolean isEmpty() {
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
    
    public static void deletePoints(Point[] points){
        System.out.println("the connection points are: " + points.toString());
        if (!alPoints.isEmpty()) {
            Point testPoint = new Point();
            Point pointToRemove = new Point();
            for (int i = alPoints.size() - 1; i >= 0; i--) {
                System.out.println("all the connection points are: " + alPoints.get(i));
                testPoint = alPoints.get(i);
                for (int j = 0; j < points.length; j++) {
                    System.out.println("the connection points we need to remove is: " + points[j]);
                    pointToRemove = points[j];
                    if (testPoint.equals(pointToRemove)) {
                        alPoints.remove(testPoint);
                        System.out.println("removed point at index: " + i);
                        System.out.println("removed connection point : " + testPoint);
                    }
                }
            }
        }
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
    public static Point getClosestToOrigin(){
        Point currentClosestPoint;
        if (!alPoints.isEmpty()) {
            currentClosestPoint = alPoints.get(0);
            for (int i = 0; i < alPoints.size(); i++) {
                Point potentialPoint = alPoints.get(i);
                if (currentClosestPoint.x > potentialPoint.y && currentClosestPoint.y > potentialPoint.x) {
                    currentClosestPoint = potentialPoint;
                }
            }
            return currentClosestPoint;
        }
        return new Point(0,0);
    }
    
    public static Point getFurthestFromOrigin(){
        Point currentClosestPoint;
        if (!alPoints.isEmpty()) {
            currentClosestPoint = alPoints.get(0);
            for (int i = 0; i < alPoints.size(); i++) {
                Point potentialPoint = alPoints.get(i);
                if (currentClosestPoint.x < potentialPoint.y && currentClosestPoint.y < potentialPoint.x) {
                    currentClosestPoint = potentialPoint;
                }
            }
            return currentClosestPoint;
        }
        return new Point(100,100);
    }

    public void remove(Point point) {
        alPoints.remove(point);
    }
    
}
