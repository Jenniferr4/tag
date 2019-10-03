package org.improving.tag;

import org.improving.tag.commands.Command;
import org.improving.tag.items.UniqueItems;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@Component
public class Game {
    private Date startTime;
    private Date endTime;
    private Command[] commands;
    private InputOutput io;
    private Player p;

    private Location startingLocation;
    private List<Location> locationList = new ArrayList<>();
    private final SaveGameFactory saveFactory;


    public Game(Command[] commands, InputOutput io, SaveGameFactory saveFactory) {
        startingLocation = buildWorld();
        this.commands = commands;
        this.io = io;
        this.p = new Player(startingLocation);


        this.saveFactory = saveFactory;
    }

    public Player getPlayer() {
        return p;
    }

    public Date getStartTime() {
        return startTime;
    }

    private void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    private void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void run() {
        this.setStartTime(new Date());

        boolean loop = true;
        while (loop) {

            try {
                io.displayPrompt( "> ");
                String input = io.receiveInput();
                Command validCommand = getValidCommand(input);

                if (null != validCommand) {
                    validCommand.execute(input, this);
                } else if (input.equalsIgnoreCase("exit")) {
                    io.displayText("Goodbye.");
                    saveFactory.save(this);
                } else {
                    io.displayText("Huh? I don't understand.");
                }
            } catch (GameExitException ex) {
                loop = false;
            }


            this.setEndTime(new Date());

        }
    }

    private Command getValidCommand(String input) {
        return Stream.of(commands).filter(c -> c.isValid(input, this)).findFirst().orElse(null);
//        for (Command command : commands) {
//            if (command.isValid(input, this)) {
//                return command;
//            }
        // }
        // return null;
    }

    private Location buildWorld() {
        var tdh = new Location();
        tdh.setName("The Deathly Hallows");
        tdh.setTreasureChest(new TreasureChest(UniqueItems.BLUE_SHELL, "A Deadly Shell "));
        this.locationList.add(tdh);


        var td = new Location();
        td.setName("The Desert");
        this.locationList.add(td);

        var ta = new Location();
        ta.setName("The Amazon");
        this.locationList.add(ta);

        var tmcs = new Location();
        tmcs.setName("The Mac & Cheese Shop");
        tmcs.setTreasureChest(new TreasureChest(UniqueItems.THE_ONE_RING, "A Kraft Box "));

        this.locationList.add(tmcs);

        var tvm = new Location();
        tvm.setName("The Velvet Moose");
        this.locationList.add(tvm);
        tvm.setAdversary(new Adversary("Mad Moose"));
        tvm.getAdversary().getInventory().addItem(UniqueItems.THE_UNFORGETTABLE_MUSHROOM);
        tvm.setTreasureChest(new TreasureChest(UniqueItems.BLUE_SHELL, "A Deadly Shell "));


        var air = new Location();
        air.setName("Airport");
        this.locationList.add(air);

        var ict = new Location();
        ict.setName("The Ice Cream Truck");
        this.locationList.add(ict);

        var tm = new Location();
        tm.setName("The Mountains");
        this.locationList.add(tm);

        var tr = new Location();
        tr.setName("The Reef");
        this.locationList.add(tr);

        var mall = new Location();
        mall.setName("The Mall");
        this.locationList.add(mall);

        var mntdm = new Location();
        mntdm.setName("Mount Doom");
        this.locationList.add(mntdm);
        mntdm.setAdversary(new Adversary("Sauron"));


        var vod = new Location();
        vod.setName("The Volcano of Death");
        this.locationList.add(vod);


        tdh.getExits().add(new Exit("Heaven Ave", tmcs, "h", "heaven", "ave"));
        tdh.getExits().add(new Exit("The Deathly Brownie", td, "tdb", "brownie", "the", "death"));

        td.getExits().add(new Exit("Camel Path", ta, "cp", "camel", "path"));
        td.getExits().add(new Exit("Rocky Road", ict, "RR", "Rock", "RRoad"));
        td.getExits().add(new Exit("The Docks", air, "td", "dock", "docks"));

        tmcs.getExits().add(new Exit("Highway 121", ta, "121", "hwy 121", "h121"));
        tmcs.getExits().add(new Exit("Paradise Rd.", tr, "Paradise", "Paraiso", "PdRd"));
        tmcs.getExits().add(new Exit("Highway 21", vod, "h21", "hw21", "21"));

        tr.getExits().add(new Exit("The Reef", tvm, "reef", "rf"));
        tr.getExits().add(new Exit("The City Walk", mall, "City", "walk", "cwalk", "cityw"));

        tm.getExits().add(new Exit("Path to Doom", mntdm, "ptd", "pathtod", "path2d"));
        tm.getExits().add(new Exit("An Escalator of Doom", vod, "Edoom", "edoom", "aedoom"));

        tvm.getExits().add(new Exit("The Front Door", ta, "fdoor", "Fdoor", "tfdoor", "door", "front"));
        tvm.getExits().add(new Exit("The Pudding Slide", air, "pud", "slide", "tps"));

        mntdm.getExits().add(new Exit("Jump Into Lava", vod, "jintolava", "jilava", "lava"));
        mntdm.getExits().add(new Exit("The Cab", mall, "cab", "taxi", "tcab"));

        ta.getExits().add(new Exit("Amaz-ing Moose", tvm, "moose", "amoose"));

        air.getExits().add(new Exit("Flight 121", tm, "f121", "F121", "fly121"));
        air.getExits().add(new Exit("Flight to the mall", mall, "fmall", "flymall", "flym"));

        ict.getExits().add(new Exit("Magic Portal", mntdm, "magic", "portal", "mp"));

        tm.getExits().add(new Exit("The Plane", ta, "plane", "tplane", "thep"));
        tm.getExits().add(new Exit("The Narrow Trail ", mntdm, "narrow", "tntrail", "tnt"));
        tm.getExits().add(new Exit("The Lava Flow", vod, "lava f", "lavaf", "flava"));
        tm.getExits().add(new Exit("Bike Trail", tr, "bike", "btrail", "rail"));


        return tdh;
    }

    public Location getLocationOf(final String intendedLocationName) {
        for (Location location : locationList) {
            if (intendedLocationName.equalsIgnoreCase(location.getName())) {
                return location;
            }
        }
        return null;
    }
}
