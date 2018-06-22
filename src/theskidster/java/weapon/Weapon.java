package theskidster.java.weapon;

import java.util.HashMap;
import theskidster.java.main.MainResource;

/**
 * @author J Hoffman
 * Created: May 15, 2018
 */

public class Weapon {
    
    public HashMap stocks = new HashMap();
    public HashMap grips = new HashMap();
    public HashMap sights = new HashMap();
    public HashMap barrels = new HashMap();
    
    private MainResource mr = new MainResource();
    
    /*
    * initalize collections, this should probably be automated but im too lazy.
    */
    public Weapon() {
        stocks.put(0, mr.bi2[0]);
        stocks.put(1, mr.bi2[1]);
        stocks.put(2, mr.bi2[2]);
        stocks.put(3, mr.bi2[3]);
        
        grips.put(0, mr.bi2[4]);
        grips.put(1, mr.bi2[5]);
        grips.put(2, mr.bi2[6]);
        grips.put(3, mr.bi2[7]);
        
        sights.put(0, mr.bi2[8]);
        sights.put(1, mr.bi2[9]);
        sights.put(2, mr.bi2[10]);
        sights.put(3, mr.bi2[11]);
        
        barrels.put(0, mr.bi2[12]);
        barrels.put(1, mr.bi2[13]);
        barrels.put(2, mr.bi2[14]);
        barrels.put(3, mr.bi2[15]);
    }
    
}