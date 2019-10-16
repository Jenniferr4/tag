package org.improving.tag;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


@Entity(name = "exits")
public class Exit {

    @Id
    int id;

    @Column(name = "Name")
    private String name;

    @Transient
    private List<String> aliases = new ArrayList<>();

    @Column(name="Aliases")
    private String aliasesDb;

    @OneToOne
    @JoinColumn(name = "DestinationId")
    private Location destination;

    @ManyToOne
    @JoinColumn(name = "OriginId")
    private Location originId;

    public Exit() { }

    public Exit(String name, Location destination, String...aliases) {
        this.name = name;
        this.destination = destination;
        this.aliases.addAll(Arrays.asList(aliases));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public void addAlias(String alias) {
        this.aliases.add(alias);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

//    public int getOriginId() {
//        return originId;
//    }
//
//    public void setOriginId(int originId) {
//        this.originId = originId;
//    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, destination);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Exit) {
            Exit exit = (Exit) obj;
            return this.getName().equals(exit.getName()) &&
                    this.getDestination().equals(exit.getDestination());
        }
        return super.equals(obj);
    }

    @PostLoad
    public void postLoad() {
        var aliasesArr = aliasesDb.split(",");
        for(String alias : aliasesArr) {
            aliases.add(alias.trim());
        }
    }

}