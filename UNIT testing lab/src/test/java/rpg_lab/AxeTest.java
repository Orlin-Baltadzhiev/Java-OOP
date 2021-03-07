package rpg_lab;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static rpg_lab.Axe.DURABILITY_LOSS;

public class AxeTest {

  @Test
    public void testDurabilityLossAfterAttackShouldLooseExactOnePoint(){
      int initialDurability = 1;
      Axe axe = new Axe(0,initialDurability);
      Dummy dummy = new Dummy(100, 100);
      axe.attack(dummy);
      int expectedPoints = initialDurability - DURABILITY_LOSS;
      int actualPoints = axe.getDurabilityPoints();
    assertEquals(expectedPoints, actualPoints);
  }

  @Test (expected = IllegalStateException.class)
    public void testAttackWithBrokenAxeShouldThrow(){

      Axe axe = new Axe(10,0);
      Dummy dummy = new Dummy(100,100);
      axe.attack(dummy);

  }
}
