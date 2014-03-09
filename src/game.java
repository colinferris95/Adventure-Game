/**
 * Created by cfer on 3/1/14.
 */

import java.util.Scanner;

public class game {


    //globals
    public static locationClass[] locations; // game locations
    public static gameItems[] itemsArray; //items array
    public static int[][]  locMatrix; // game matrix
    public static int  currentLoc = 0; // the current location of the player
    public static boolean playFlag = true; // bool flag for game status
    public static String input; // player input
    public static int direction; // player inputed direction
    public static int gameScore = 0; // init game score
    public static int moveCount = 1;// inti move counts
    public static int scoreRatio = gameScore/moveCount; // score ratio
    public static String[] inventory;
    public static int length = 1;

    public static void main(String[] args) {
        System.out.println("Welcome to Dugeon's Keep: The Java adventure");

        run();
        display();

        while(playFlag){
            getCommand();
            move();

        }
    }

    private static void run(){
        //items
        gameItems item0 = new gameItems(0);
        item0.setItemName("Sword of justice");

        gameItems item1 = new gameItems(1);
        item1.setItemName("Staff of peril");

        gameItems item2 = new gameItems(2);
        item2.setItemName("Gray Shield");

        gameItems item3 = new gameItems(3);
        item3.setItemName("Knights Helm");

        //magic items
        gameItems item4 = new gameItems(4);
        item4.setItemName("Necklace of Trepidation");

        gameItems item5 = new gameItems(5);
        item5.setItemName("Ring of Chaos");



        locationClass loc0 = new locationClass(0);
        loc0.setName("Dungeon");
        loc0.setItem(item1.getItemName());

        locationClass loc1 = new locationClass(1);
        loc1.setName("Maze");

        locationClass loc2 = new locationClass(2);
        loc2.setName("East Bridge");

        locationClass loc3 = new locationClass(3);
        loc3.setName("Troll");

        locationClass loc4 = new locationClass(4);
        loc4.setName("West Gate");

        locationClass loc5 = new locationClass(5);
        loc5.setName("Magick Shoppe");

        locationClass loc6 = new locationClass(6);
        loc6.setName("Golden Gate");

        locationClass loc7 = new locationClass(7);
        loc7.setName("Open Field");

        locationClass loc8 = new locationClass(8);
        loc8.setName("the nether");



        locations = new locationClass[9];

        locations[0] = loc0; //Dungeon cell
        locations[1] = loc1; // Maze to Nowhere
        locations[2] = loc2; //East Bridge
        locations[3] = loc3; //Troll
        locations[4] = loc4; //West Gate
        locations[5] = loc5; //Golden Key
        locations[6] = loc6; //Golden Gate
        locations[7] = loc7; //Open Field
        locations[8] = loc8;


        itemsArray = new gameItems[6];
        itemsArray[0] = item0;
        itemsArray[1] = item1;
        itemsArray[2] = item2;
        itemsArray[3] = item3;
        itemsArray[4] = item4;
        itemsArray[5] = item5;




        //inventory
        inventory = new String[6];
        inventory[0] = null;
        inventory[1] = null;
        inventory[2] = null;
        inventory[3] = null;
        inventory[4] = null;// magic item
        inventory[5] = null;// magic item


        locMatrix = new int[][] {
                //N  S  E  W
                {6, 1, 2, 4},   //Dungeon cell
                {0,8,8,8},  // Maze to Nowhere
                {8,3,8, 0},  //east bridge
                {2,8,8,8},   //Troll
                {8,8,0, 5},  //west gate
                {8,8,4,8},   //golden key
                {7,0,8,8 },   //golden gate
                {8,6,8,8}   //open field
        };



    }

    private static void display(){
        System.out.println(locations[currentLoc].getName());
        System.out.println(" your score is: " + gameScore + " your move count is " + moveCount + " your ratio is " + scoreRatio + " " + locations[currentLoc].getItem());
    }

    private static void getCommand() {

        Scanner inputReader = new Scanner(System.in);
        input = inputReader.nextLine();  // command is global.



    }

    private static void move(){

        if (input.equalsIgnoreCase("n")){
            direction = 0;

        }
        else if (input.equalsIgnoreCase("s")){
            direction = 1;

        }

        else if (input.equalsIgnoreCase("e")){
            direction = 2;

        }

        else if (input.equalsIgnoreCase("w")){
            direction = 3;
            //opens inventory
        } else if (input.equalsIgnoreCase("i")){

        }

        int newLoc = locMatrix[currentLoc][direction];

        if (newLoc >= 0 && newLoc < 8){ //valid locations
            currentLoc = newLoc; //set current player location
             // output to console
            moveCount = moveCount + 1; //add to move count
        } else if(newLoc == 8){
            System.out.println("you cannot go this way"); //going the wrong way

        }

        if (locations[currentLoc].getHasVisited() == false ){
            locations[currentLoc].setHasVisited(true);
            gameScore = gameScore + 5;
            System.out.println("you have found a new location");
            display();
        } else{
            display();
        }

    }


}
