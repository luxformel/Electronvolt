/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Electronvolt;

import Lists.ConnectionPoints;
import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author luxformel
 */
public class ImageGenerator {
    private JPanel drawPanel;
    
    public static void exportAsPNG(JPanel panel, String outputPath) {
        // Create a BufferedImage with the same dimensions as the JPanel
        int width = ConnectionPoints.getFurthestFromOrigin().x;
        int height = ConnectionPoints.getFurthestFromOrigin().y;
        // adds a buffer 
        width += 50;
        height += 50;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        // Get the Graphics object of the BufferedImage
        Graphics g = image.getGraphics();

        // Call the paint() method of the JPanel, passing the Graphics object
        panel.paint(g);

        // Dispose the Graphics object to release resources
        g.dispose();

        // Create a File object for the output PNG file
        File outputFile = new File(outputPath);

        try {
            // Write the BufferedImage to the output file
            ImageIO.write(image, "png", outputFile);
            System.out.println("Panel exported as PNG successfully!");
        } catch (IOException e) {
            System.out.println("Error exporting panel as PNG: " + e.getMessage());
        }
    }
}
