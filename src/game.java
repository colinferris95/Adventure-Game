/**
 * Created by cfer on 3/1/14.
 */

import java.util.Scanner;
import java.util.Arrays;

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

        //magic items
        gameItems item4 = new gameItems(4);
        item4.setItemName("Necklace of Trepidation");

        gameItems item5 = new gameItems(5);
        item5.setItemName("Ring of Chaos");



        locationClass loc0 = new locationClass(0);
        loc0.setName("Dungeon");
        loc0.setItem(item0.getItemName());
        loc0.setHasVisited(true);

        locationClass loc1 = new locationClass(1);
        loc1.setName("Maze");
        loc1.setItem(item1.getItemName());

        locationClass loc2 = new locationClass(2);
        loc2.setName("East Bridge");
        loc2.setItem(item2.getItemName());

        locationClass loc3 = new locationClass(3);
        loc3.setName("Troll");
        loc3.setItem(item3.getItemName());

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
        System.out.println(" your score is: " + gameScore + " your move count is " + moveCount + " your ratio is " + scoreRatio + " " + "The item in this location is " + locations[currentLoc].getItem());
    }

    private static void takeItem(){
            if (locations[currentLoc].getName() == "Dungeon"){
                inventory[0] = locations[currentLoc].getItem();
            }


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

        } else if (input.equalsIgnoreCase("h") || input.equalsIgnoreCase("help")){
            System.out.println("The commands to this game are simple type n,s,e, or w to move");
            return;//weird bug
        } else if (input.equalsIgnoreCase("d") || input.equalsIgnoreCase("dance")){
            System.out.println("You dance the day away...... boy are you tired....");
            return;//weird bug
        } else if (input.equalsIgnoreCase("i")){
            System.out.println(Arrays.toString(inventory));
            return;
        } else if (input.equalsIgnoreCase("t")){
            takeItem();
            return;
        }

        else {
            System.out.println("I do not understand your query");
        }

        int newLoc = locMatrix[currentLoc][direction];

        if (newLoc >= 0 && newLoc < 8){ //valid locations
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

        } else if(newLoc == 8){
            System.out.println("you cannot go this way"); //going the wrong way

        }



    }


}
