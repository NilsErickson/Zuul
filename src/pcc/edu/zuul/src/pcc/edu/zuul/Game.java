package pcc.edu.zuul;

public class Game {
    private Parser parser;
    private Room currentRoom;

    public Game() {
        this.createRooms();
        this.parser = new Parser();
    }

    private void createRooms() {
        Room ninjaRoom = new Room("in the main enterence to the camp. You'll need to walk 10000 steps to get to the next room.");
        Room weaponroom = new Room("in the Weapon's room. Normally this is where you go to grab your Nunchaku, but not today.");
        Room meetingRoom = new Room("in the Meeting room. This is where classes are normally held. We will be here tomorrow to be sure");
        Room zenTemple = new Room("in the Meditation room. When done for the day, this is where you clear your head.");
        Room stealthRoom = new Room("in the Stealth training room. Ninja are made here, slow but steady will keep you alive.");
        Room restRoom = new Room("in the Barracks. When I am done for th day, I will come back here for some rest.");
        Room masterRoom = new Room("in the Master's room. Master is current meditating right now. Better leave him alone.");
        weaponroom.addItem(new Item("Katana", 3));
        weaponroom.addItem(new Item("Nunchaku", 1));
        weaponroom.addItem(new Item("Bo", 2));
        weaponroom.addItem(new Item("Sai", 2));
        ninjaRoom.addItem(new Item("Master's Keys", 1));
        meetingRoom.addItem(new Item("Secret Plans", 1));
        zenTemple.addItem(new Item("Prayer beads", 1));
        stealthRoom.addItem(new Item("Throwing Star", 2));
        restRoom.addItem(new Item("Risque magazines", 1));
        masterRoom.addItem(new Item("Ancient Shinobi Scroll", 5));
        ninjaRoom.setExits("north", weaponroom);
        weaponroom.setExits("north", meetingRoom);
        meetingRoom.setExits("north", stealthRoom);
        meetingRoom.setExits("east", restRoom);
        meetingRoom.setExits("south", weaponroom);
        meetingRoom.setExits("west", zenTemple);
        zenTemple.setExits("east", meetingRoom);
        stealthRoom.setExits("south", meetingRoom);
        restRoom.setExits("east", masterRoom);
        restRoom.setExits("west", meetingRoom);
        masterRoom.setExits("west", restRoom);
        this.currentRoom = ninjaRoom;
    }

    public void play() {
        this.printWelcome();

        Command command;
        for(boolean finished = false; !finished; finished = this.processCommand(command)) {
            command = this.parser.getCommand();
        }

        System.out.println("Tomorrow is another day, better get some sleep.");
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the World of Ninja: Zed!!!");
        System.out.println("World of Ninja: Zed is a new adventure game.");
        System.out.println("Setting: NINJA TRAINING CAMP, IGA PROVENCE, JAPAN Time: 1597");
        System.out.println("Since you were born, you have lived in this camp.");
        System.out.println("Today is your day off, your allowed to move around the camp.");
        System.out.println("Take a look around the camp to get your bearing.");
        System.out.println("Press quit to get some rest as tomorrow is another training day");
        System.out.println("Type 'help' if you need help remembering.");
        System.out.println();
        this.printLocationInfo();
    }

    private boolean processCommand(Command command) {
        boolean wantToQuit = false;
        if(command.isUnknown()) {
            System.out.println("Uhhhh...what was that");
            return false;
        } else {
            String commandWord = command.getCommandWord();
            if(commandWord.equals("help")) {
                this.printHelp();
            } else if(commandWord.equals("go")) {
                this.goRoom(command);
            } else if(commandWord.equals("look")) {
                this.look();
            } else if(commandWord.equals("quit")) {
                wantToQuit = this.quit(command);
            } else if(commandWord.equals("meditate")) {
                this.meditate();
            }

            return wantToQuit;
        }
    }

    private void printHelp() {
        System.out.println("Your command words are:");
        System.out.println(this.parser.showCommands());
    }

    private void goRoom(Command command) {
        if(!command.hasSecondWord()) {
            System.out.println("Go where?");
        } else {
            String direction = command.getSecondWord();
            Room nextRoom = this.currentRoom.getExit(direction);
            if(nextRoom == null) {
                System.out.println("There is no door!");
            } else {
                this.currentRoom = nextRoom;
                this.printLocationInfo();
            }

        }
    }

    private boolean quit(Command command) {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;
        }
    }

    private void printLocationInfo() {
        System.out.println("You are " + this.currentRoom.getLongDescription());
        System.out.print("Exits: ");
        this.currentRoom.getExitString();
    }

    private void look() {
        System.out.println(this.currentRoom.getLongDescription());
    }

    private void meditate() {
        System.out.println("You spend a few moments reflecting on what you have learned...");
    }
}