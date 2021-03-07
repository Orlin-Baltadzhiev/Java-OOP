package rpg_lab;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HeroTest {

    @Test
    public void testHeroGainsExperienceWhenTargetIsKilled(){
        Weapon weapon= new Weapon() {
            @Override
            public int getAttackPoints() {
                return 10;
            }

            @Override
            public int getDurabilityPoints() {
                return 0;
            }

            @Override
            public void attack(Dummy target) {
                target.takeAttack(target.getHealth());
            }
        };

        Hero hero = new Hero("Hercules",weapon);
        hero.attack(new Dummy(10,100));

        assertEquals(100,hero.getExperience());

    }
}
