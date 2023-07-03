/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lists;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author luxformel
 */
public class PointDecorations {
    private ArrayList<PointDecoration> alDecorations = new ArrayList<>();

    public void add(PointDecoration e) {
        alDecorations.add(e);
    }

    public void remove(PointDecoration pointDecoration) {
        alDecorations.remove(pointDecoration);
    }

    public void clear() {
        alDecorations.clear();
    }
    public void draw(Graphics g){
        for (int i = 0; i < alDecorations.size(); i++) {
            alDecorations.get(i).draw(g);   
        }
    }
}
