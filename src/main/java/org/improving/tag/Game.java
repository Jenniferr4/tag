package org.improving.tag;

import org.improving.tag.commands.*;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;

import java.util.Date;
import java.util.Scanner;

@Component
public class Game {
    private Date startTime;
    private Date endTime;
    private Command[] commands;
    private InputOutput io;
    private Player p;
    private Location startingLocation;


    public Game(Command[] commands, InputOutput io) {
        startingLocation = buildWorld();
        this.commands = commands;
        this.io = io;
        this.p = new Player(startingLocation);

    }

    public Location getStartingLocation() {
        return startingLocation;
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
            io.displayPrompt("> ");
            String input = io.receiveInput();

            Command validCommand = getValidCommand(input);
            if (null != validCommand) {
                validCommand.execute(input, this);
            } else if (input.equalsIgnoreCase("exit")) {
                io.displayText("Goodbye.");
                loop = false;
            } else {
                io.displayText("Huh? I don't understand.");
            }
            this.setEndTime(new Date());

        }
    }

    private Command getValidCommand(String input) {
        for (Command command : commands) {
            if (command.isValid(input, this)) {
                return command;
            }

        }
        return null;
    }

    private Location buildWorld() {
        var tdh = new Location();
        tdh.setName("The Deathly Hallows");

        var td = new Location();
        td.setName("The Desert");

        var ta = new Location();
        ta.setName("The Amazon");

        var tmcs = new Location();
        tmcs.setName("The Mac & Cheese Shop");

        var tvm = new Location();
        tvm.setName("The Velvet Moose");

        var air = new Location();
        air.setName("Airport");

        var ict = new Location();
        ict.setName("The Ice Cream Truck");

        var tm = new Location();
        tm.setName("The Mountains");

        var tr  = new Location();
        tr.setName("The Reef");

        var  mall= new Location();
        mall.setName("The Mall");

        var mntdm = new Location();
        mntdm.setName("Mount Doom");

        var vod = new Location();
        vod.setName("The Volcano of Death");


        tdh.getExits().add(new Exit("Heaven Ave" , tmcs, "h", "heaven", "ave"));
        tdh.getExits().add(new Exit("The Deathly Brownie", td, "tdb", "brownie", "the", "death"));

        td.getExits().add(new Exit("Camel Path" , ta, "cp", "camel", "path"));
        td.getExits().add(new Exit("Rocky Road" ,ict , "RR", "Rock", "RRoad"));
        td.getExits().add(new Exit("The Docks" ,air , "td", "dk", "dock"));

        tmcs.getExits().add(new Exit("Highway 121" , ta, "121", "hwy 121", "h121"));
        tmcs.getExits().add(new Exit("Paradise Rd." ,tr , "Paradise", "Paraiso", "PdRd"));
        tmcs.getExits().add(new Exit("Highway 21" , vod , "h21", "hw21", "21"));

        tr.getExits().add(new Exit("The Reef" ,tvm , "reef", "rf"));
        tr.getExits().add(new Exit("The City Walk" ,mall , "City", "walk", "cwalk", "cityw"));

        tm.getExits().add(new Exit("Path to Doom" ,mntdm , "ptd", "pathtod", "path2d"));
        tm.getExits().add(new Exit("An Escalator of Doom" ,vod , "Edoom", "edoom", "aedoom"));

        tvm.getExits().add(new Exit("The Front Door",ta,"fdoor", "Fdoor", "tfdoor"));
        tvm.getExits().add(new Exit("The Pudding Slide" ,air , "pud", "slide", "tps"));

        mntdm.getExits().add(new Exit("Jump Into Lava" ,vod , "jintolava", "jilava", "lava"));
        mntdm.getExits().add(new Exit("The Cab" ,mall , "cab", "taxi", "tcab"));

        ta.getExits().add(new Exit("Amaz-ing Moose" ,tvm , "moose", "amoose"));

        air.getExits().add(new Exit("Flight 121" ,tm , "f121", "F121", "fly121"));
        air.getExits().add(new Exit("Flight to the mall" ,mall , "fmall", "flymall", "flym"));

        ict.getExits().add(new Exit("Magic Portal" ,mntdm , "magic", "portal", "mp"));

        tm.getExits().add(new Exit("The Plane" ,ta , "plane", "tplane", "thep"));
        tm.getExits().add(new Exit("The Narrow Trail " ,mntdm , "narrow", "tntrail", "tnt"));
        tm.getExits().add(new Exit("The Lava Flow" ,vod , "lava f", "lavaf", "flava"));
        tm.getExits().add(new Exit("Bike Trail" ,tr , "bike", "btrail", "rail"));


        return tdh;
    }
}
