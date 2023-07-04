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
public abstract class TwoPointDecoration {

    private Point position1, position2;
    
    public TwoPointDecoration(Point position1, Point position2){
        this.position1 = position1;
        this.position2 = position2;
    }
    public abstract void draw(Graphics g);
}
