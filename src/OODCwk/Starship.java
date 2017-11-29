/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OODCwk;


public class Starship extends ASF_Force {
    int laserCannons;
    int photonTorpedos;
    
    public Starship(String fullname, String reference, int lasers, int photon) {
        super(fullname, reference, 0, 0);
        this.setActivationFee(30*lasers);
        this.setBattleStrength(5*photon + 10*lasers);
        this.laserCannons = lasers;
        this.photonTorpedos = photon;
    }

    @Override
    public String getDetails() {
        return "Laser Cannons: " + laserCannons + " Photon Torpedos: " + photonTorpedos;
    }

    @Override
    public boolean gameRule(Fight fight) {
        boolean result = false;
        switch(fight.getFightType()) {
            case SKIRMISH:
                result = true;
            case BATTLE:
                result = true;
            default:
                result = false;
                
        }
        
        return result;
    }
}
