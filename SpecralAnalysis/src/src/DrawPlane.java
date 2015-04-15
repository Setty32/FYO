package src;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.lang.Double;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Setty
 */
public class DrawPlane extends javax.swing.JPanel {

    Label prismAngleValue;
    Label impactAngleValue;
    
    /**
     * Creates new form DrawPlane
     */
    int triangleXPoints[];
    int triangleYPoints[];
    
    int inputLightXPoints[];
    int inputLightYPoints[];
    
    List<List<SpectralLine>> lines;
    List<Integer> lineTypes;
    
    
    int triangleWidth;
    double prismAngle;
    
    double impactAngle;
    
    //c = omega / k = lambda / T
    
    public DrawPlane() {
        initComponents();
        
        triangleXPoints = new int[4];
        triangleYPoints = new int[4];
        inputLightXPoints = new int[2];
        inputLightYPoints = new int[2];
        
        setBackground(Color.black);
    }
    
    public void setPrismAngleOutputLabel(Label p){
        prismAngleValue = p;
    }
    
    public void setImpactAngleOutputLabel(Label p){
        impactAngleValue = p;
    }
    
    public void getLines(List<List<SpectralLine>> in){
        lines = in;
        repaint();
    }
    
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        this.setBaseWidth();
        g.setColor(Color.GREEN);
        g.drawPolygon(triangleXPoints, triangleYPoints, 3);
        
        this.setInputLight();
        
        Graphics2D g2d = (Graphics2D)g;
        g2d.setStroke(new BasicStroke(10));
        g2d.setColor(Color.white);
        g2d.drawLine(inputLightXPoints[0], inputLightYPoints[0], inputLightXPoints[1], inputLightYPoints[1]);
        
        if(lines != null)
        {
            
            for (List<SpectralLine> a: lines)
            {
                for (SpectralLine m : a) {
                    drawSpecralLine(m.wavelength, m.strength, m.n, g2d);
                    System.out.print("n "+m.n + "\n" );
                }
            }
        }
//        drawSpecralLine(700, 10, 1.9, g2d);
    }
    
    public void drawSpecralLine(double lambda, double strenght, double refractive, Graphics2D g){
        int positionXPoints[] = new int[2];
        int positionYPoints[] = new int[2];
        
        positionXPoints[0] = inputLightXPoints[0];
        positionYPoints[0] = inputLightYPoints[0];
        
        double insideAngle = Math.asin(Math.sin(Math.PI / 2 - impactAngle) / refractive);
        
        positionXPoints[1] = positionXPoints[0] + (int)(300 * Math.sin(Math.PI/2 + prismAngle - insideAngle));
        positionYPoints[1] = positionYPoints[0] - (int)(300 * Math.cos(Math.PI/2 + prismAngle - insideAngle));
        
        double x1,x2,x3,x4;
        double y1,y2,y3,y4;
        x1 = (double) positionXPoints[0];
        x2 = (double)positionXPoints[1];
        x3 = (double)triangleXPoints[0];
        x4 = (double)triangleXPoints[2];
        y1 = (double)positionYPoints[0];
        y2 = (double)positionYPoints[1];
        y3 = (double)triangleYPoints[0];
        y4 = (double)triangleYPoints[2];
                
        
        double ua = ((x4 - x3)*(y1 - y3)-(y4 - y3)*(x1 - x3))/((y4 - y3)*(x2 - x1)-(x4 - x3)*(y2 - y1));
        
        int posX[] = new int[2];
        int posY[] = new int[2];
        
        posX[0] = (int)(x1 + ua*(x2-x1));
        posY[0] = (int)(y1 + ua*(y2-y1));
        
        g.setStroke(new BasicStroke(1));
        int col[] = LightColor.waveLengthToRGB(lambda);
        int alfa = (int)((strenght / 500) * 255);
        g.setColor(new Color(col[0],col[1],col[2],alfa));
        g.drawLine(positionXPoints[0], positionYPoints[0], posX[0], posY[0]);
        
        double outsideAngle = Math.asin(Math.sin(2*prismAngle - insideAngle) * refractive);
//        System.out.print("in " + Math.toDegrees(insideAngle) + "\n" );
//        System.out.print("out " + Math.toDegrees(outsideAngle) + "\n" );
//        System.out.print("cely uhel: " + Math.toDegrees(Math.PI/2 + prismAngle - insideAngle) + "\n");
        if(outsideAngle <= Math.asin(1/refractive)){
        
        double dist = 200 / Math.sin(Math.PI/2 - prismAngle + outsideAngle);
        posX[1] = posX[0] + (int)(dist * Math.sin(Math.PI/2 - prismAngle + outsideAngle));
        posY[1] = posY[0] - (int)(dist * Math.cos(Math.PI/2 - prismAngle + outsideAngle));
        
        g.drawLine(posX[0], posY[0], posX[1], posY[1]);
        
        g.drawLine(posX[1]+1, posY[1], posX[1] + 200, posY[1]);
        }
    }
    
    private void setBaseWidth(){
        triangleXPoints[0] = 350;
        triangleYPoints[0] = 100;
        triangleYPoints[1] = 400;
        triangleYPoints[2] = 400;
        triangleXPoints[1] = triangleXPoints[0] - triangleWidth / 2;
        triangleXPoints[2] = triangleXPoints[0] + triangleWidth / 2;
        
        prismAngle = Math.atan((double)triangleWidth / 600);
        prismAngleValue.setText(String.format("%.2f", 2 * Math.toDegrees(prismAngle)) + "°");
//        System.err.print(prismAngle + "\n");
    }
    
    private void setInputLight(){
        inputLightYPoints[0] = 250;
        inputLightXPoints[0] = 350 - triangleWidth / 4;
        inputLightXPoints[1] = inputLightXPoints[0] - (int)(300 * Math.sin(prismAngle + impactAngle));
        inputLightYPoints[1] = inputLightYPoints[0] + (int)(300 * Math.cos(prismAngle + impactAngle));
        
    }
    
    public void setTriangleWidth(int value){
       triangleWidth = value;
       repaint();
    }
    
    public void setImpactAngle(double value){
        impactAngle = Math.PI / 2 - Math.toRadians(value);
        repaint();
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
