/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
//
 */
package OODCwk;

/**
 *
 * @author Wayne
 */
public class Wing extends ASF_Force {
    private int strikers;
    
    /**
     *
     * @param fullname
     * @param reference
     * @param no_strikers
     */
    public Wing(String fullname, String reference, int no_strikers) {
        super(fullname, reference, 200, no_strikers*20);
        
        this.strikers = no_strikers;
        
    }


    @Override
    public String getDetails() {
        return "Number of Strikers: " + this.strikers;
    }

    @Override
    public boolean gameRule(Fight fight) {
        boolean result = false;
        switch(fight.getFightType()) {
            case SKIRMISH:
                result = true;
                break;
            case AMBUSH:
                result = true;
                break;
            case BATTLE:
                result = false;
                break;
                
        }
        
        return result;
    }
   
    
}
