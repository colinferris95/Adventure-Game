
//imports
import java.util.Scanner;
import java.util.Arrays;
import java.io.*;

public class game {


    //globals
    public static locationClass[] locations; // game locations
    public static gameItems[] itemsArray; //items array
    public static int[][]  locMatrix; // game matrix
    public static int  currentLoc = 0; // the current location of the player
    public static boolean playFlag = true; // bool flag for game status
    public static String input; // player input
    public static int direction  ; // player inputed direction
    public static float gameScore = 0 ; // init game score
    public static float moveCount = 1;// inti move counts
    public static String[] inventory; // creates inventory array
    public static  int idNum = 4;
    public static  int id = 4;
    public static double wallet = 0;


    public static void main(String[] args) {
        System.out.println("Welcome to Dugeon's Keep: The Java adventure"); // intro text
        run();

        display();
       //main game loop
        while(playFlag){

            getCommand();
            move();

        }
    }

    //creates main game objects
    private static void run(){
        //items
        gameItems item0 = new gameItems(0);
        item0.setItemName("Sword of justice");
        item0.setLoc(0);

        gameItems item1 = new gameItems(1);
        item1.setItemName("Staff of peril");
        item1.setLoc(1);

        gameItems item2 = new gameItems(2);
        item2.setItemName("Gray Shield");
        item2.setLoc(2);

        gameItems item3 = new gameItems(3);
        item3.setItemName("Knights Helm");
        item3.setLoc(3);





        locationClass loc0 = new locationClass(0);
        loc0.setName("Dungeon");
        loc0.setItem("map");
        loc0.setHasVisited(true);
        loc0.setCash(25);

        locationClass loc1 = new locationClass(1);
        loc1.setName("Cliffside");
        loc1.setItem(item1.getItemName());

        locationClass loc2 = new locationClass(2);
        loc2.setName("forest");
        loc2.setItem(item2.getItemName());

        locationClass loc3 = new locationClass(3);
        loc3.setName("treasure");
        loc3.setItem(item3.getItemName());
        loc3.setCash(25);

        locationClass loc4 = new locationClass(4);
        loc4.setName("Gate");
        loc4.setItem(item0.getItemName());

        locationClass loc5 = new locationClass(5);
        loc5.setName("Magick Shoppe");


        water loc6 = new water(6);
        loc6.setName("ocean");
        loc6.setWater("water is here");

        locationClass loc7 = new locationClass(7);
        loc7.setName("Open Field");

        locationClass loc8 = new locationClass(8);
        loc8.setName("the nether");



        locations = new locationClass[9];

        locations[0] = loc0; //Dungeon cell
        locations[1] = loc1; //cliff
        locations[2] = loc2; //forest
        locations[3] = loc3; //treasure
        locations[4] = loc4; //gate
        locations[5] = loc5; //magick shoppe
        locations[6] = loc6; //ocean
        locations[7] = loc7; //field
        locations[8] = loc8;

        //linked list navigation

        locationListMan locationList = new locationListMan();

        locationClass locale0 = new locationClass(0);
        loc0.setName("dungeon");
        locationList.add(locale0);

        locationClass locale1 = new locationClass(0);
        loc0.setName("Cliffside");
        locationList.add(locale1);

        locationClass locale2 = new locationClass(0);
        loc0.setName("forest");
        locationList.add(locale2);

        locationClass locale3 = new locationClass(0);
        loc0.setName("treasure");
        locationList.add(locale3);

        locationClass locale4 = new locationClass(0);
        loc0.setName("Gate");
        locationList.add(locale4);

        locationClass locale5 = new locationClass(0);
        loc0.setName("Magick Shoppe");
        locationList.add(locale5);

        locationClass locale6 = new locationClass(0);
        loc0.setName("ocean");
        locationList.add(locale6);

        locationClass locale7 = new locationClass(0);
        loc0.setName("Open Field");
        locationList.add(locale7);

        //inventory
        inventory = new String[6];
        inventory[0] = null;
        inventory[1] = null;
        inventory[2] = null;
        inventory[3] = null;
        inventory[4] = null;// magic item
        inventory[5] = null;// magic item

        // two dimensional matrix
        locMatrix = new int[][] {
                //N  S  E  W
                {4, 8, 1, 2},   //Dungeon cell
                {8, 8, 6, 0},  // cliffside
                {3, 5, 0, 8},  //forest
                {8, 2, 4, 8},   //treasure
                {7, 0, 8, 3},  //gate
                {2, 8, 8, 8},   //magick shoppe
                {8, 8, 8, 1 },   //ocean
                {8, 4, 8, 8}   //open field
        };



    }


    //updates console output with main game info
    private static void display(){
        System.out.println(locations[currentLoc].getName());
        System.out.println(" your score is: " + gameScore + " your move count is " + moveCount + " Your wallet is " + wallet +
        " your achievement ratio is " + gameScore/moveCount + " " + "The item in this location is " + locations[currentLoc].getItem() +
        " The cash here is " + locations[currentLoc].getCash());
        nextMove();
    }

    //allows players to pick up items into their inventory
    private static void takeItem(){
            if (locations[currentLoc].getItem() != null){
                inventory[locations[currentLoc].getId()] = locations[currentLoc].getItem();
                System.out.println("you took an item");
            } else{
                System.out.println("there is no item here.....");
            }
        wallet = wallet + locations[currentLoc].getCash();
        if(locations[currentLoc].getCash() == 0){
            System.out.println("There is no cash here");
        }
        locations[currentLoc].setCash(0);
    }

    //ends game by quiting main game loop
    private static void quitGame(){
        playFlag = false;
        return;
    }

    // shows players possible moves
    private static void nextMove(){
        if (locMatrix[currentLoc][0] != 8){
            System.out.println("you can move north");
        }
        if (locMatrix[currentLoc][1] != 8){
            System.out.println("you can move south");
        }
        if (locMatrix[currentLoc][2] != 8){
            System.out.println("you can move east");
        }
        if (locMatrix[currentLoc][3] != 8){
            System.out.println("you can move west");
        }

    }
    //creates player input from text console
    private static void getCommand() {

        Scanner inputReader = new Scanner(System.in);
        input = inputReader.nextLine();  // command is global.
    }

    private static void move(){

        if (input.equalsIgnoreCase("n") || input.equalsIgnoreCase("north")){
            direction = 0;

        }
        else if (input.equalsIgnoreCase("s") || input.equalsIgnoreCase("south")){
            direction = 1;

        }

        else if (input.equalsIgnoreCase("e") || input.equalsIgnoreCase("east")){
            direction = 2;

        }

        else if (input.equalsIgnoreCase("w") || input.equalsIgnoreCase("west")){
            direction = 3;


        } else if (input.equalsIgnoreCase("h") || input.equalsIgnoreCase("help")){
            System.out.println("The commands to this game are simple type n,s,e, or w to move, i to see your inventory and t to take items");
            return;
        }

        else if (input.equalsIgnoreCase("d") || input.equalsIgnoreCase("dance")){
            System.out.println("You dance the day away...... boy are you tired....");
            return;
        }

        else if (input.equalsIgnoreCase("i") || input.equalsIgnoreCase("inventory")){
            System.out.println(Arrays.toString(inventory));
            return;
        }

        else if (input.equalsIgnoreCase("t") || input.equalsIgnoreCase("take")){
            takeItem();
            return;
        }

        else if (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit")){
            quitGame();
            return;
        } else if (input.equalsIgnoreCase("m") || input.equalsIgnoreCase("map")){
            map();
            return;
        }

        else {
            System.out.println("I do not understand your query");
        }

        int newLoc = 0;

        if(direction >=0){
         newLoc = locMatrix[currentLoc][direction];
        } else{
            System.out.println("something went wrong, ill get back to this");
        }


        if (newLoc >= 0 && newLoc < 8 ){ //valid locations
            currentLoc = newLoc; //set current player location
             // output to console
            moveCount = moveCount + 1; //add to move count

            if (locations[currentLoc].getHasVisited() == false ){
                locations[currentLoc].setHasVisited(true);
                gameScore = gameScore + 5;
                System.out.println("you have found a new location");
                display();
            } else{
                display();
            }

            if (locations[currentLoc].getName().equals("Magick Shoppe")){

                createMagicItems();
                display();

            }


        } else if(newLoc == 8){
            System.out.println("you cannot go this way"); //going the wrong way

        }
    }

    private static void createMagicItems() {


        System.out.print("What item would you like? Or type quit to leave. ");
        listMan magicItems  = new listMan();
        Scanner inputReader = new Scanner(System.in);



        String targetItem = new String();
        targetItem = inputReader.nextLine();
        System.out.println();

        if (targetItem.equalsIgnoreCase("q") || targetItem.equalsIgnoreCase("quit")){
            return;


        }

        final String fileName;
        fileName = "/Users/cfer/Documents/CMPT/Adventure Game/src/items.txt";



        File myFile = new File(fileName);
        try {
            Scanner input = new Scanner(myFile);
            while (input.hasNext()) {

                String itemName = input.nextLine();


                gameItems fileItem = new gameItems(idNum);
                fileItem.setItemName(itemName);
                fileItem.setCost(Math.floor(Math.random() * 50));
                fileItem.setNext(null);


                magicItems.add(fileItem);

                idNum ++;
            }

            input.close();
            System.out.println(magicItems.toString());


        } catch (FileNotFoundException ex) {
            System.out.println("File not found. " + ex.toString());
            createMagicItems();
        }


        gameItems li = new gameItems(idNum);
        li = sequentialSearch(magicItems, targetItem);

        if (li != null) {
            System.out.println(li.toString());
        }

        System.out.println("Would you like to buy?");


        Scanner input = new Scanner(System.in);
        String next = new String();
        next = input.nextLine();
        System.out.println();
        if (next.equals("yes") && wallet >= li.getCost()){
            System.out.println("ok");
            wallet = wallet - li.getCost();
            if(id != 6){
            inventory[id] = li.getItemName();
            id = id + 1;
            }
                else{
                System.out.println("your inventory is full");
            }
        } else{
            System.out.println(wallet);
            System.out.println(next);
            System.out.println(li.getCost());
            System.out.println("ok goodbye");
        }


        createMagicItems();


        // Create the list manager for our magic items.




        /*magicItems.setName("Magic Items");
        magicItems.setDesc("These are the magic items.");
        magicItems.setHead(null);

        // Create some magic items and put them in the list.
        gameItems item4 = new gameItems(4);
        item4.setItemName("Necklace of Trepidation");
        item4.setDesc("this item costs 500 coins");

        gameItems item5 = new gameItems(5);
        item5.setItemName("Ring of Chaos");
        item5.setDesc("this item costs 1000 coins");

        // Link it all up.
        magicItems.setHead(item4);
        item4.setNext(item5);
        item5.setNext(null);*/


        //System.out.println(magicItems.toString());
    }


    private static gameItems sequentialSearch(listMan lm,
                                             String target) {
        gameItems retVal = null;
        System.out.println("Searching for " + target + ".");
        int counter = 0;
        gameItems currentItem = new gameItems(idNum);
        currentItem = lm.getHead();
        boolean isFound = false;
        while ( (!isFound) && (currentItem != null) ) {
            counter = counter +1;
            if (currentItem.getItemName().equalsIgnoreCase(target)) {
                // We found it!
                isFound = true;
                retVal = currentItem;
            } else {
                // Keep looking.
                currentItem = currentItem.getNext();
            }
        }
        if (isFound) {

            System.out.println("Found " + target + " after " + counter + " comparisons." );
            return currentItem;
        } else {
            System.out.println("Could not find " + target + " in " + counter + " comparisons.");
        }

        return retVal;


    }

    private static void map(){

        if (inventory[0].equals("map")){
            System.out.println("               Game Map");
            System.out.println("              ");
            System.out.println("               Open Field");
            System.out.println("                 ^");
            System.out.println("                 |");
            System.out.println("$Treasure$ --->   Gate");
            System.out.println("  ^              ^");
            System.out.println("  |              |");
            System.out.println("Forest  <----- $Dungeon$ ------>  cliffside ------> ocean");
            System.out.println("  |");
            System.out.println("  V");
            System.out.println("Magick Shoppe");
            System.out.println("         ");

        } else{
            System.out.println("you do not have the map yet");
        }
    }
}

/*
Scanner inputReader = new Scanner(System.in);
String next = new String();
next = inputReader.nextLine();
        System.out.println();
        if (next == "yes" && wallet >= currentItem.getCost()){
        wallet = wallet - currentItem.getCost();
        } else{
        System.out.println("ok goodbye");
        }*/
