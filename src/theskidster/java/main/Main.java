package theskidster.java.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JFrame;
import javax.swing.JPanel;
import theskidster.java.weapon.Weapon;

/**
 * @author J Hoffman
 * Created: Jun 22, 2018
 */

public class Main implements KeyListener {
    
    private static final int WIDTH = 320;
    private static final int HEIGHT = 224;
    
    public int[] parts = {
        0,
        1,
        2,
        3
    };
    
    int initPart;
    
    private JFrame jf = new JFrame("RNG02: procedurally generated guns.");
    private Canvas ca = new Canvas();
    private JPanel jp = (JPanel) jf.getContentPane();
    private BufferStrategy bs;
    private Graphics2D g;
    private Dimension di = new Dimension(WIDTH, HEIGHT);
    private MainResource mr = new MainResource();
    
    private Weapon we = new Weapon();
    
    /*
    * program entry point
    */
    public static void main(String args[]) {
        new Main().render();
    }
    
    /*
    * establish window/drawing surface
    */
    public Main() {
        jp.add(ca);
        jp.setPreferredSize(di);
        
        ca.setBounds(0, 0, WIDTH, HEIGHT);
        
        jf.setMinimumSize(di);
        jf.setResizable(false);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        
        ca.setIgnoreRepaint(true);
        ca.createBufferStrategy(2);
        bs = ca.getBufferStrategy();

        ca.requestFocus();
        ca.addKeyListener(this);
        ca.setBackground(Color.decode("#0C46BB"));
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {
        if(KeyEvent.VK_ENTER == e.getKeyCode()) {
            render();
        }
    }

    /*
    * renders weapon
    */
    private void render() {
        g = (Graphics2D) bs.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.WHITE);
        g.drawString("press [ENTER] to generate random weapon", 40, 30);
        
        g.scale(8, 8);
        
        for(int part : parts) {
            generate(part);
        }
        
        g.dispose();
        bs.show();
    }
    
    /*
    * generates random parts based off hashmap keys
    */
    private void generate(int part) {
        int randNum = ThreadLocalRandom.current().nextInt(0, 3 + 1);
        
        switch(part) {
            case 0:
                g.drawImage((Image) we.stocks.get(randNum), 11, 13, null);
            break;
            case 1:
                g.drawImage((Image) we.grips.get(randNum), 17, 14, null);
            break;
            case 2:
                g.drawImage((Image) we.sights.get(randNum), 17, 9, null);
            break;
            case 3:
                g.drawImage((Image) we.barrels.get(randNum), 23, 13, null);
            break;
        }
    }
    
}