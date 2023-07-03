/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lists;

import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author luxformel
 */
public abstract class PointDecoration {
    private Point position;
    
    public PointDecoration(Point position){
        this.position = position;
    }
    public abstract void draw(Graphics g);
}
