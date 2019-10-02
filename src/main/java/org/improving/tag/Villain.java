package org.improving.tag;

public class Villain {
    private String name;
    private int hitPoints;
    private int damageTaken;
    private int attackDamage;
    private int maxHitPoints;

    public Villain(String name) {
        this.name = name;
        this.maxHitPoints = 100;
        this.hitPoints = this.maxHitPoints - this.damageTaken;
        this.damageTaken = 0;
        this.attackDamage = 1;
        this.maxHitPoints = 100;
    }

    public int getDamageTaken() {
        return damageTaken;
    }

    public void setDamageTaken(int damageTaken) {
        this.damageTaken = damageTaken;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public String getName() {
        return name;
    }
}
