package rpg_lab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DummyTest {
    private static final int HEALTH=10;
    private static final int EXPERIENCE=10;


    private Dummy dummy;
    @Before
    public void setUp() {

        this.dummy = new Dummy(HEALTH,EXPERIENCE);
    }
    @Test
    public void testDummyLosesHealthIfAttacked() {

        dummy.takeAttack(5);

        assertEquals(5, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testDeadDummyThrowsIfAttacked() {
        dummy.takeAttack(HEALTH);
        dummy.takeAttack(HEALTH);

    }

    @Test(expected = IllegalStateException.class)
    public void testDeadDummyThrowsIfAttackedIfHealthIsBelowZero() {
        dummy.takeAttack(HEALTH + 1);
        dummy.takeAttack(HEALTH );
    }

    @Test
    public void testDeadDummyCanGiveXp() {
        int expected = 10;
        dummy.takeAttack(HEALTH );
        int actual  = dummy.giveExperience();
        assertEquals(expected,actual);
    }
    @Test (expected = IllegalStateException.class )
    public void testAliveDummyWontGiveXP() {
        dummy.giveExperience();
    }

    @Test
    public void testIsDeadShouldReturnFalse(){
        assertFalse(dummy.isDead());
    }
}