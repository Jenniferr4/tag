package org.improving.tag;

import org.improving.tag.items.Item;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "location")
public class Location {


    @Id
    int id;

    @Column(name = "Name")
    private String name = "";

    @Column(name = "Description")
    private String description = "";


   @OneToMany( fetch = FetchType.EAGER, mappedBy = "originId")
    private List<Exit> exits = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "adversaryId")
    private Adversary adversary;


    @Transient
    private TreasureChest treasureChest = TreasureChest.NO_TREASURE;


    public Adversary getAdversary() {
        return adversary;
    }

    public void setAdversary(Adversary adversary) {
        this.adversary = adversary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public List<Exit> getExits() {
        return exits;
    }

    public void setTreasureChest(TreasureChest treasureChest) {
        this.treasureChest = treasureChest;
    }

    public String getTreasureDescription() {
        return treasureChest.getDescription();
    }

    public Item openTreasureChest() {
        Item treasure = treasureChest.getItem();
        treasureChest = TreasureChest.NO_TREASURE;
        return treasure;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void addExit(Exit exit) {
        this.exits.add(exit);
    }



    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Location) {
            Location location  = (Location) obj;
            return this.getName().equals(location.getName()) &&
                    this.getDescription().equals(location.getDescription());
        }
        return super.equals(obj);
    }

}


