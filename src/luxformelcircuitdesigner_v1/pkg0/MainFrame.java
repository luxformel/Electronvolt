/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package luxformelcircuitdesigner_v1.pkg0;

import Components.Transistor;
import Components.Resistor;
import Components.Inductor;
import Components.LightBulb;
import Components.Diode;
import Components.Battery;
import Components.Capacitor;
import Components.OLDInductor;
import Components.PowerSource;
import Components.Switch;
import Components.ToggleSwitch;
import Components.Transformer;
import Components.Connector;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;


/**
 *
 * @author luxformel
 */

public class MainFrame extends javax.swing.JFrame {
    
    private Components components = new Components();
    private Wires wires = new Wires();
    private ImageGenerator imagegenerator;
    private Point position;
    private Point connection1 = new Point();
    private Point connection2 = new Point();
    private int mousePressedCounter = 0;
    private Stack redoStack = new Stack();
    private Stack undoStack = new Stack();
    /**
     * Creates new form MainFrame
     */
    // Declares the tree view
    DefaultTreeModel model;
       
    public MainFrame() {
        initComponents();
        loadJTree();
        loadComboBox();
        setTitle("Electronvolt");
        drawPanel.setComponents(components);
        drawPanel.setWires(wires);
        componentsList.setListData(components.toArray());
        
        //Logo
        ImageIcon icon = new ImageIcon("Icon.png");
        setIconImage(icon.getImage()); //change icon of frame
        //this.getContentPane().setBackground(new Color(0x123456)); //change color of background }
    }
    
    public void updateView(){
        drawPanel.setComponents(components);
        drawPanel.setWires(wires);
        componentsList.setListData(components.toArray());
        repaint();
    }
    
    public void loadComboBox(){
        UIManager.LookAndFeelInfo[] lafInfo = UIManager.getInstalledLookAndFeels();
        
        String name;
        String[] names = new String[lafInfo.length];
        for (int i = 0; i < lafInfo.length; i++) {
            name = lafInfo[i].getName();
            names[i] = name;
            System.out.println(name);
        }
        jThemeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(names));
    }
    
    DefaultMutableTreeNode componentNode2 = new DefaultMutableTreeNode("Bauteile");
    
    public void loadJTree(){
        DefaultMutableTreeNode componentNode = new DefaultMutableTreeNode("Bauteile");
        componentNode.add(new DefaultMutableTreeNode("Widerstand"));
        componentNode.add(new DefaultMutableTreeNode("Diode"));
        componentNode.add(new DefaultMutableTreeNode("Spule"));
        componentNode.add(new DefaultMutableTreeNode("Kondensator"));
        componentNode.add(new DefaultMutableTreeNode("Transistor"));
        componentNode.add(new DefaultMutableTreeNode("Transformator"));
        
        DefaultMutableTreeNode lightNodes = new DefaultMutableTreeNode("Lichtquellen");
        lightNodes.add(new DefaultMutableTreeNode("Glühlampe"));
             
        DefaultMutableTreeNode switchesNode = new DefaultMutableTreeNode("Schalter");
        switchesNode.add(new DefaultMutableTreeNode("Schalter"));
        switchesNode.add(new DefaultMutableTreeNode("Umschalter"));
        
        DefaultMutableTreeNode powerSourceNode = new DefaultMutableTreeNode("Spannungsquellen");
        powerSourceNode.add(new DefaultMutableTreeNode("Batterie"));
        powerSourceNode.add(new DefaultMutableTreeNode("Wechselspannungsquelle"));
        
        DefaultMutableTreeNode oldComponentNode = new DefaultMutableTreeNode("Veraltet Schreibweisen");
        oldComponentNode.add(new DefaultMutableTreeNode("Inductor"));
        
        DefaultMutableTreeNode connectorNode = new DefaultMutableTreeNode("Anschlüsse");
        connectorNode.add(new DefaultMutableTreeNode("Anschluss"));
        
        componentNode2.add(componentNode);
        componentNode2.add(switchesNode);
        componentNode2.add(powerSourceNode);
        componentNode2.add(oldComponentNode);
        componentNode2.add(connectorNode);
        componentNode2.add(lightNodes);
        
        model = (DefaultTreeModel)jTree.getModel();
        model.setRoot(componentNode2);
        jTree.setModel(model);
    }
    
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jDialog1 = new javax.swing.JDialog();
        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTree = new javax.swing.JTree();
        drawPanel = new luxformelcircuitdesigner_v1.pkg0.DrawPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        componentsList = new javax.swing.JList();
        jThemeComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        deleteSelectedComponentButton = new javax.swing.JButton();
        jMenuBar = new javax.swing.JMenuBar();
        jFileMenu = new javax.swing.JMenu();
        jExportMenuItem = new javax.swing.JMenuItem();
        jDeleteAllMenuItem = new javax.swing.JMenuItem();
        jEditMenu = new javax.swing.JMenu();
        jRedoMenuItem = new javax.swing.JMenuItem();
        jUndoMenuItem = new javax.swing.JMenuItem();
        jHelpMenu = new javax.swing.JMenu();
        jHowToUseMenuItem = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        jTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane2.setViewportView(jTree);

        drawPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                drawPanelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout drawPanelLayout = new javax.swing.GroupLayout(drawPanel);
        drawPanel.setLayout(drawPanelLayout);
        drawPanelLayout.setHorizontalGroup(
            drawPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1171, Short.MAX_VALUE)
        );
        drawPanelLayout.setVerticalGroup(
            drawPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Electronvolt");

        componentsList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(componentsList);

        jThemeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Windows", " " }));
        jThemeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemeComboBoxActionPerformed(evt);
            }
        });

        jLabel2.setText("Change Look and Feel:");

        deleteSelectedComponentButton.setText("Delete Selected Component");
        deleteSelectedComponentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteSelectedComponentButtonActionPerformed(evt);
            }
        });

        jFileMenu.setText("File");
        jFileMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileMenuActionPerformed(evt);
            }
        });

        jExportMenuItem.setText("Export");
        jExportMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jExportMenuItemActionPerformed(evt);
            }
        });
        jFileMenu.add(jExportMenuItem);

        jDeleteAllMenuItem.setText("Delete All");
        jDeleteAllMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDeleteAllMenuItemActionPerformed(evt);
            }
        });
        jFileMenu.add(jDeleteAllMenuItem);

        jMenuBar.add(jFileMenu);

        jEditMenu.setText("Edit");

        jRedoMenuItem.setText("Redo");
        jRedoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRedoMenuItemActionPerformed(evt);
            }
        });
        jEditMenu.add(jRedoMenuItem);

        jUndoMenuItem.setText("Undo");
        jUndoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUndoMenuItemActionPerformed(evt);
            }
        });
        jEditMenu.add(jUndoMenuItem);

        jMenuBar.add(jEditMenu);

        jHelpMenu.setText("Help");

        jHowToUseMenuItem.setText("How To Use");
        jHowToUseMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jHowToUseMenuItemActionPerformed(evt);
            }
        });
        jHelpMenu.add(jHowToUseMenuItem);

        jMenuBar.add(jHelpMenu);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(deleteSelectedComponentButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jThemeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2))
                        .addGap(24, 24, 24)
                        .addComponent(drawPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jThemeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteSelectedComponentButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(drawPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jFileMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFileMenuActionPerformed

    private void jExportMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jExportMenuItemActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setDialogTitle("Save Your Circuit as .png");
        
        int response = fileChooser.showSaveDialog(null);
        if (response == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            if (selectedFile != null) {
                // Save button clicked without selecting a file
                String fileName = fileChooser.getSelectedFile().getName();
                File newFile = new File(fileChooser.getCurrentDirectory(), fileName);
                System.out.println("New file: " + newFile.getAbsolutePath());
                
                String path = selectedFile.getAbsolutePath() + ".png";
            
                imagegenerator = new ImageGenerator();
                imagegenerator.exportAsPNG(drawPanel, path);
            }   
        }
    }//GEN-LAST:event_jExportMenuItemActionPerformed

    private void jDeleteAllMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDeleteAllMenuItemActionPerformed
        // TODO add your handling code here:
        int response = JOptionPane.showConfirmDialog(
                this, 
                "If You continue your sketch will be deleted!",
                "Confirm", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE
        );
        
        if (response == JOptionPane.YES_OPTION) {
            components.clear();
            wires.clear();
            redoStack.clear();
            ConnectionPoints.clear();
        }
        mousePressedCounter = 0;
        updateView();
    }//GEN-LAST:event_jDeleteAllMenuItemActionPerformed

    private void drawPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drawPanelMousePressed
        // TODO add your handling code here:
        int X = evt.getX();
        int Y = evt.getY();
        
        if (evt.getButton() == MouseEvent.BUTTON1 && !jTree.isSelectionEmpty()) {
            
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) jTree.getSelectionPath().getLastPathComponent();
            String selectedComponent = selectedNode.getUserObject().toString();
           

            position = new Point(X, Y);
            Component component;

            // switch statement to check what was selected
            switch (selectedComponent) {
                case "Widerstand":
                    component = new Resistor(position);
                    break;
                case "Spule":
                    component = new Inductor(position);
                    break;
                case "Kondensator":
                    component = new Capacitor(position);
                    break;
                case "Diode":
                    component = new Diode(position);
                    break;
                case "Transistor":
                    component = new Transistor(position);
                    break;  
                case "Glühlampe":
                    component = new LightBulb(position);
                    break;    
                case "Batterie":
                    component = new Battery(position);
                    break;
                case "Inductor":
                    component = new OLDInductor(position);
                    break;
                case "Schalter":
                    component = new Switch(position);
                    break;
                case "Umschalter":
                    component = new ToggleSwitch(position);
                    break;  
                case "Transformator":
                    component = new Transformer(position);
                    break;
                case "Wechselspannungsquelle":
                    component = new PowerSource(position);
                    break; 
                case "Anschluss":
                    component = new Connector(position);
                    break;    
                default:
                    throw new AssertionError();
            }
            
            components.add(component);
            undoStack.push(new StackItem(component));
           
        }else if(mousePressedCounter == 1 && evt.getButton() == MouseEvent.BUTTON3){  
            connection2 = new Point(X, Y);
            wires.add(new Wire(connection1, connection2));       
            mousePressedCounter = 0;
         
        }else if (mousePressedCounter == 0 && evt.getButton() == MouseEvent.BUTTON3) {
            mousePressedCounter++;
            connection1 = new Point(X, Y);
        }
        updateView();
    }//GEN-LAST:event_drawPanelMousePressed

    private void jThemeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jThemeComboBoxActionPerformed
        // TODO add your handling code here:
        String lookAndFeelName =  String.valueOf(jThemeComboBox.getSelectedItem());
        System.out.println(lookAndFeelName);
            if (lookAndFeelName != null) {
                for (UIManager.LookAndFeelInfo info:UIManager.getInstalledLookAndFeels()) {
                    if (lookAndFeelName.equals(info.getName())) {
                        try {
                            UIManager.setLookAndFeel(info.getClassName());
                            SwingUtilities.updateComponentTreeUI(this);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(LuxformelCircuitDesigner_v10.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (InstantiationException ex) {
                            Logger.getLogger(LuxformelCircuitDesigner_v10.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IllegalAccessException ex) {
                            Logger.getLogger(LuxformelCircuitDesigner_v10.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (UnsupportedLookAndFeelException ex) {
                            Logger.getLogger(LuxformelCircuitDesigner_v10.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    }       
                }
            }
    }//GEN-LAST:event_jThemeComboBoxActionPerformed

    private void deleteSelectedComponentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteSelectedComponentButtonActionPerformed
        // TODO add your handling code here:
        int index = componentsList.getSelectedIndex();
        System.out.println("selected index: " + index);
        if (index != -1) {
            Component component = components.get(index);
            StackItem deletedItem = new StackItem(component);
            redoStack.push(deletedItem);
            components.remove(component);
            Point position = components.get(index).getPosition();
            updateView();
        }
        System.out.println("Stack nbr 0: " + redoStack.peek());
    }//GEN-LAST:event_deleteSelectedComponentButtonActionPerformed

    private void jHowToUseMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jHowToUseMenuItemActionPerformed
        // TODO add your handling code here:
       HelpFrame helpFrame = new HelpFrame();
       helpFrame.show();
    }//GEN-LAST:event_jHowToUseMenuItemActionPerformed

    private void jRedoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRedoMenuItemActionPerformed
        // TODO add your handling code here:
        if (!redoStack.empty()) {
            StackItem item = (StackItem) redoStack.pop();
            if (item.getIsComponent()) {
                Component component = item.getComponent();
                components.add(component);
                undoStack.push(component);
            }else if (item.getIsWire()) {
                Wire wire = item.getWire();
                wires.add(wire);
                undoStack.push(wire);
            }
        }
        updateView();
    }//GEN-LAST:event_jRedoMenuItemActionPerformed

    private void jUndoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUndoMenuItemActionPerformed
        // TODO add your handling code here:
        if (!undoStack.empty()) {
            StackItem item = (StackItem) undoStack.pop();
            System.out.println("  Cast item  " + undoStack.pop());
            if (item.getIsComponent()) {
                Component component = item.getComponent();
                components.remove(component);
                redoStack.push(component);
            }else if (item.getIsWire()) {
                Wire wire = item.getWire();
                wires.remove(wire);
                redoStack.push(wire);
            }
        }
        updateView();
    }//GEN-LAST:event_jUndoMenuItemActionPerformed
    int number = 69;
    int newNumver = (int) number;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList componentsList;
    private javax.swing.JButton deleteSelectedComponentButton;
    private luxformelcircuitdesigner_v1.pkg0.DrawPanel drawPanel;
    private javax.swing.JMenuItem jDeleteAllMenuItem;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JMenu jEditMenu;
    private javax.swing.JMenuItem jExportMenuItem;
    private javax.swing.JMenu jFileMenu;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JMenu jHelpMenu;
    private javax.swing.JMenuItem jHowToUseMenuItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jRedoMenuItem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox<String> jThemeComboBox;
    private javax.swing.JTree jTree;
    private javax.swing.JMenuItem jUndoMenuItem;
    // End of variables declaration//GEN-END:variables
}
