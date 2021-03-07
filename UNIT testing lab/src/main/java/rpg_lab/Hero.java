package rpg_lab;

import java.util.Random;

public class Hero {

    private String name;
    private int experience;
    private Weapon weapon;

    public Hero(String name) {
        this.name = name;
        this.experience = 0;
        this.weapon = new Axe(10, 10);
    }


    public Hero(String name,Weapon weapon) {
        this.name = name;
        this.experience = 0;
        this.weapon = weapon;
    }

    public String getName() {
        return this.name;
    }

    public int getExperience() {
        return this.experience;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public void attack(Dummy target) {
        this.weapon.attack(target);

        if (target.isDead()) {
            this.experience += target.giveExperience();
        }
    }
}
