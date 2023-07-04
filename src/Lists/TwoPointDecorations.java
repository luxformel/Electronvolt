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
public class TwoPointDecorations {
    private ArrayList<TwoPointDecoration> alTwoPointDecorations = new ArrayList<>();

    public void add(TwoPointDecoration e) {
        alTwoPointDecorations.add(e);
    }

    public void remove(TwoPointDecoration twoPointDecoration) {
        alTwoPointDecorations.remove(twoPointDecoration);
    }

    public void clear() {
        alTwoPointDecorations.clear();
    }
    public void draw(Graphics g){
        for (int i = 0; i < alTwoPointDecorations.size(); i++) {
            alTwoPointDecorations.get(i).draw(g);   
        }
    }
}
