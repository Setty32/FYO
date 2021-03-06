package src;


import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Setty
 */
public class mainWindow extends javax.swing.JFrame{

    /**
     * Creates new form mainWindow
     */
    DrawPlane draw;
    
    List<SpectralLine> hydrogenSpectrum;
    List<SpectralLine> heliumSpectrum;
    List<SpectralLine> carbonSpectrum;
    List<SpectralLine> lithiumSpectrum;
    List<SpectralLine> neonSpectrum;
    List<SpectralLine> oxygenSpectrum;
    List<SpectralLine> siliconSpectrum;
    List<SpectralLine> sodiumSpectrum;
    List<SpectralLine> sulfurSpectrum;
    List<List<SpectralLine>> spectrums;
    
    public mainWindow() {
        initComponents();
        
        try
        {

            hydrogenSpectrum = Emittor.GetHydrogen();
            heliumSpectrum = Emittor.GetHelium();
            carbonSpectrum = Emittor.GetCarbon();
            lithiumSpectrum = Emittor.GetLithium();
            neonSpectrum = Emittor.GetNeon();
            oxygenSpectrum = Emittor.GetOxygen();
            siliconSpectrum = Emittor.GetSilicon();
            sodiumSpectrum = Emittor.GetSodium();
            sulfurSpectrum = Emittor.GetSulfur();
        }
        catch (Exception e)
        {
            System.err.println("Error");
        }
        
        spectrums = new ArrayList<List<SpectralLine>>();
        
        TriangleWidth.setMinimum(100);
        TriangleWidth.setMaximum(600);
        TriangleWidth.setValue(200);
        drawPlane1.setTriangleWidth(200);
        
        ImpactAngle.setMinimum(0);
        ImpactAngle.setMaximum(90);
        ImpactAngle.setValue(30);
        drawPlane1.setImpactAngle(30);
        
        drawPlane1.setPrismAngleOutputLabel(label4);
                
        ChangeListener triangleChange = new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                drawPlane1.setTriangleWidth(TriangleWidth.getValue());
//                System.out.print("chyceno!\n");
            }
        };
        TriangleWidth.addChangeListener(triangleChange);
        
        ChangeListener imputLightChange = new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                drawPlane1.setImpactAngle(ImpactAngle.getValue());
                label6.setText(ImpactAngle.getValue() + "°");
            }
        };
        ImpactAngle.addChangeListener(imputLightChange);
        
        ItemListener button1Change = new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    spectrums.add(hydrogenSpectrum);  
                }
                else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    spectrums.remove(hydrogenSpectrum);
                }
                drawPlane1.getLines(spectrums);
            }
        };
        
        ItemListener button2Change = new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    spectrums.add(heliumSpectrum);  
                }
                else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    spectrums.remove(heliumSpectrum);
                }
                drawPlane1.getLines(spectrums);
            }
        };
        
        ItemListener button3Change = new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    spectrums.add(carbonSpectrum);  
                }
                else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    spectrums.remove(carbonSpectrum);
                }
                drawPlane1.getLines(spectrums);
            }
        };
        
        ItemListener button4Change = new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    spectrums.add(lithiumSpectrum);  
                }
                else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    spectrums.remove(lithiumSpectrum);
                }
                drawPlane1.getLines(spectrums);
            }
        };
        
        ItemListener button5Change = new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    spectrums.add(neonSpectrum);  
                }
                else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    spectrums.remove(neonSpectrum);
                }
                drawPlane1.getLines(spectrums);
            }
        };
        
        ItemListener button6Change = new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    spectrums.add(oxygenSpectrum);  
                }
                else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    spectrums.remove(oxygenSpectrum);
                }
                drawPlane1.getLines(spectrums);
            }
        };
        
        ItemListener button7Change = new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    spectrums.add(siliconSpectrum);  
                }
                else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    spectrums.remove(siliconSpectrum);
                }
                drawPlane1.getLines(spectrums);
            }
        };
        
        ItemListener button8Change = new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    spectrums.add(sodiumSpectrum);  
                }
                else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    spectrums.remove(sodiumSpectrum);
                }
                drawPlane1.getLines(spectrums);
            }
        };
        
        ItemListener button9Change = new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    spectrums.add(sulfurSpectrum);  
                }
                else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    spectrums.remove(sulfurSpectrum);
                }
                drawPlane1.getLines(spectrums);
            }
        };
           
        jRadioButton1.addItemListener(button1Change);
        jRadioButton2.addItemListener(button2Change);
        jRadioButton3.addItemListener(button3Change);
        jRadioButton4.addItemListener(button4Change);
        jRadioButton5.addItemListener(button5Change);
        jRadioButton6.addItemListener(button6Change);
        jRadioButton7.addItemListener(button7Change);
        jRadioButton8.addItemListener(button8Change);
        jRadioButton9.addItemListener(button9Change);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TriangleWidth = new javax.swing.JSlider();
        label1 = new java.awt.Label();
        ImpactAngle = new javax.swing.JSlider();
        label2 = new java.awt.Label();
        drawPlane1 = new src.DrawPlane();
        label3 = new java.awt.Label();
        label4 = new java.awt.Label();
        label5 = new java.awt.Label();
        label6 = new java.awt.Label();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label1.setText("Set prism angle:");

        label2.setText("Set impact agnle:");

        javax.swing.GroupLayout drawPlane1Layout = new javax.swing.GroupLayout(drawPlane1);
        drawPlane1.setLayout(drawPlane1Layout);
        drawPlane1Layout.setHorizontalGroup(
            drawPlane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 721, Short.MAX_VALUE)
        );
        drawPlane1Layout.setVerticalGroup(
            drawPlane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        label3.setText("Value set to:");

        label5.setText("Value set to:");

        jRadioButton1.setText("Hydrogen");

        jRadioButton2.setText("Helium");

        jRadioButton3.setText("Carbon");

        jRadioButton4.setText("Lithium");

        jRadioButton5.setText("Neon");

        jRadioButton6.setText("Oxygen");

        jRadioButton7.setText("Silicon");

        jRadioButton8.setText("Sodium");

        jRadioButton9.setText("Sulfur");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(drawPlane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TriangleWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ImpactAngle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(label4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton1)
                                    .addComponent(jRadioButton3)
                                    .addComponent(jRadioButton5)
                                    .addComponent(jRadioButton7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton8)
                                    .addComponent(jRadioButton6)
                                    .addComponent(jRadioButton4)
                                    .addComponent(jRadioButton2)))
                            .addComponent(jRadioButton9))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TriangleWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(ImpactAngle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(104, 104, 104)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton5)
                    .addComponent(jRadioButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton7)
                    .addComponent(jRadioButton8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton9)
                .addContainerGap(139, Short.MAX_VALUE))
            .addComponent(drawPlane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ImpactAngle.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * 
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSlider ImpactAngle;
    private javax.swing.JSlider TriangleWidth;
    private src.DrawPlane drawPlane1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    // End of variables declaration//GEN-END:variables
}
