/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OODCwk;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jp14adn
 */
public class BattleTest {
    SWAT game;
    
    public BattleTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        game = new SpaceWars("Jean");
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void wingFacingSkirmishWins() {
        int expected = 900;
        game.activateForce("IW1");
        game.fight(6);
        int actual = game.getWarchest();
        assertEquals(expected, actual);
    }
    
    @Test
    public void wingFacingSkirmishLoseOnStrength() {
        int expected = 600;
        game.activateForce("IW1");
        game.fight(2);
        int actual = game.getWarchest();
        assertEquals(expected, actual);
    }
    
    @Test
    public void wingFacingAmbushWins() {
        int expected = 950;
        game.activateForce("IW1");
        game.fight(3);
        int actual = game.getWarchest();
        assertEquals(expected, actual);
    }
    
    @Test
    public void wingFacingAmbushLoseOnSkill() {
        int expected = 400;
        game.activateForce("IW1");
        game.fight(5);
        int actual = game.getWarchest();
        assertEquals(expected, actual);
    }
    
    @Test
    public void wingFacingBattleNotAllowed() {
        int expected = 500;
        game.activateForce("IW1");
        game.fight(1);
        int actual = game.getWarchest();
        assertEquals(expected, actual);
    }
    
    @Test
    public void starshipFacingSkirmishWins() {
        int expected = 650;
        game.activateForce("SS6");
        game.fight(6);
        int actual = game.getWarchest();
        assertEquals(expected, actual);
    }
    
    @Test
    public void starshipFacingSkirmishLoseOnStrength() {
        int expected = 500;
        game.activateForce("SS2");
        game.fight(2);
        int actual = game.getWarchest();
        assertEquals(expected, actual);
    }
    
    @Test
    public void starshipFacingAmbushNotAllowed() {
        int expected = 300;
        game.activateForce("SS2");
        game.fight(3);
        int actual = game.getWarchest();
        assertEquals(expected, actual);
    }
    
    @Test
    public void starshipFacingBattleWins() {
        int expected = 650;
        game.activateForce("SS6");
        game.fight(1);
        int actual = game.getWarchest();
        assertEquals(expected, actual);
    }
    
    @Test
    public void starshipFacingBattleLoseOnStrength() {
        int expected = 580;
        game.activateForce("SS7");
        game.fight(1);
        int actual = game.getWarchest();
        assertEquals(expected, actual);
    }
    
    @Test
    public void warbirdFacingSkirmishNotAllowed() {
        int expected = 600;
        game.activateForce("WB9");
        game.fight(6);
        int actual = game.getWarchest();
        assertEquals(expected, actual);
    }
    
    @Test
    public void warbirdNoCloakingFacingAmbushNotAllowed() {
        int expected = 300;
        game.activateForce("WB9");
        game.fight(3);
        int actual = game.getWarchest();
        assertEquals(expected, actual);
    }
    
    @Test
    public void warbirdWithCloakingFacingAmbushWins() {
        int expected = 750;
        game.activateForce("WB5");
        game.fight(3);
        int actual = game.getWarchest();
        assertEquals(expected, actual);
    }
    
    @Test
    public void warbirdWithCloakingFacingAmbushLoseOnStrength() {
        int expected = 200;
        game.activateForce("WB5");
        game.fight(5);
        int actual = game.getWarchest();
        assertEquals(expected, actual);
    }
    
    @Test
    public void warbirdFacingBattleWinsOnStrength() {
        int expected = 700;
        game.activateForce("WB5");
        game.fight(1);
        int actual = game.getWarchest();
        assertEquals(expected, actual);
    }
    
    @Test
    public void warbirdFacingBattleLoseOnStrength() {
        int expected = 100;
        game.activateForce("WB3");
        game.fight(4);
        int actual = game.getWarchest();
        assertEquals(expected, actual);
    }
    
    @Test
    public void recallingDestroyedForceInFightDoesntAffectWarchest() {
        int expected = 600;
        game.activateForce("IW1");
        game.fight(2);
        game.recallForce("IW1");
        int actual = game.getWarchest();
        assertEquals(expected, actual);
    }
    
    @Test
    public void recallingDestroyedInFightForceDoesntAffectWarchestOnReactivation() {
        int expected = 600;
        game.activateForce("IW1");
        game.fight(2);
        game.activateForce("IW1");
        int actual = game.getWarchest();
        assertEquals(expected, actual);
    }
    
    @Test
    public void checkNotDefeatedWhileStillActiveForces() {
        game.activateForce("IW1");
        game.activateForce("SS2");
        game.activateForce("WB3");
        game.fight(4);
        System.out.println("get fight: " + Fight.getFight(4) );
        game.fight(5);    
        System.out.println("Game: " + game.toString());
        System.out.println("The actual result " + game.isDefeated());
        System.out.println("Get all forces " + game.getASFleet());
        assertFalse(game.isDefeated());
    }
    
    @Test
    public void checkDefeatedWhenGoingBust() {
        game.activateForce("IW1");
        game.activateForce("SS2");
        game.activateForce("WB3");
        game.fight(4);
        game.fight(5);
        game.fight(4);
        assertTrue(game.isDefeated());
    }
}