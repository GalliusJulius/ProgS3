package logo;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * La classe MyImage permet d'ouvrir une fenetre 
 * avec une image de base et de lui ajouter des accessoires
 * 
 */
public class MyImage extends JPanel {
    BufferedImage image;
    Dimension size = new Dimension();

    public MyImage(String path) {
        try{
            this.image = ImageIO.read(new File(path));
            size.setSize(image.getWidth(), image.getHeight());
        }
        catch(Exception e)
        {
            System.out.println("Error creating image with path "+path);
            System.out.println(e);
        }            
    }
    
    
    /**
     * Affichage de l'image dans le JPanel
     */
    protected void paintComponent(Graphics g) {
        int x = (getWidth() - size.width)/2;
        int y = (getHeight() - size.height)/2;
        g.drawImage(image, x, y, this);
    }

    
    /**
     * Ouverture d'une fenetre (JFrame) avec le JPanel
     * contenant l'image
     */
    public void display(){
        try{
            JFrame f = new JFrame();
            f.setLayout(new BorderLayout());
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.add(new JScrollPane(this),BorderLayout.CENTER);
            //Ajout
            JPanel boutons= new JPanel();
            boutons.setSize(new Dimension(image.getWidth(),50));
            JButton b1 = new JButton("Lunette");
            JButton b2 = new JButton("Chapeau");
            JButton b3 = new JButton("Texte");
            JButton b4 = new JButton("Reset");
            boutons.add(b1);
            boutons.add(b2);
            boutons.add(b3);
            boutons.add(b4);
            EventsBoutons ev = new EventsBoutons(this);
            b1.addActionListener(ev);
            b2.addActionListener(ev);
            b3.addActionListener(ev);
            b4.addActionListener(ev);
            f.add(boutons,BorderLayout.SOUTH);
            
            
            f.setSize(new Dimension(image.getWidth(),image.getHeight()+50));
            f.setLocation(40,40);
            f.setVisible(true);
            f.setResizable(false);
        }
        catch(Exception e){}
    }
    
    
    /**
     * Superposition d'une autre image sur l'image courante
     * Modification de l'image courante
     */
    public void paintOver(String otherimage, int decalx, int decaly){
    	BufferedImage newImage=null;
        
        try{
            newImage = ImageIO.read(new File(otherimage));
        }
        catch(Exception e){
            System.out.println("Error creating image with path "+otherimage);
            System.out.println(e);
        }
        
        int sizex = newImage.getWidth();
        int sizey = newImage.getHeight();
        
		Graphics g=this.image.getGraphics();
		g.drawImage(newImage, decalx, decaly, decalx+sizex, decaly+sizey, 0, 0, sizex, sizey, null);
		g.dispose();
    }
    
    
    /**
     * Superposition d'un texte sur l'image courante
     * Modification de l'image courante
     */
    public void textOver(String txt, int x, int y){     
        Graphics g=this.image.getGraphics();
        
		g.drawString(txt,x,y);
		g.dispose();
    }
}