package org.improving.tag;

import org.improving.tag.items.Item;
import org.improving.tag.items.UniqueItems;

import javax.persistence.*;
import java.util.Arrays;


@Entity(name = "adversary")
public class Adversary {

    @Id
    int id;

    @Column(name = "Name")
    private String name;


    @Column(name = "hitPoints")
    private int hitPoints;

    @Column(name = "damageTaken")
    private int damageTaken;

    @Column(name = "attackDamage")
    private int attackDamage;

    @Column(name = "DropItem")
    private String dropItemDb;

//    @Column(name = "ForExercise")
//    private UniqueItems forExercise;

    @Enumerated(EnumType.STRING)
    private UniqueItems dropItem = UniqueItems.NOTHING;
//    @Enumerated(EnumType.ORDINAL)
//    private UniqueItems dropItem;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getDamageTaken() {
        return damageTaken;
    }

    public void setDamageTaken(int damageTaken) {
        this.damageTaken = damageTaken;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public void setItem(UniqueItems dropItem) {
        this.dropItem = dropItem;
    }

    public UniqueItems getItem() {
        return dropItem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDropItemDb() {
        return dropItemDb;
    }

    public void setDropItemDb(String dropItemDb) {
        this.dropItemDb = dropItemDb;
    }

    public Item getDropItem() {
        return dropItem;
    }

    public void setDropItem(UniqueItems dropItem) {
        this.dropItem = dropItem;
    }

    @PostLoad
    public void postLoad() {
        System.out.println("Loaded an adversary");
        if (null != dropItemDb) {
            this.setItem(Arrays
                    .stream(UniqueItems.values())
                    .filter(item -> item.getName().equals(dropItem))
                    .findFirst()
                    .orElse(null)
            );
        }
    }
}