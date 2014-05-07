//TO DO LIST:
/*
modulate code
fix next moves
fix moves(add brick walls)
project 4 objectives
 */



//imports
import java.util.Scanner;
import java.util.Arrays;
import java.io.*;

public class game {


    //globals
    public static locationClass[] locations; // game locations
    public static gameItems[] itemsArray; //items array
    public static int[][]  locMatrix; // game matrix
    public static String  currentLoc = "starting space"; // the current location of the player
    public static String locItem = "map";
    public static String currentLocList;
    public static boolean playFlag = true; // bool flag for game status
    public static String input; // player input
    public static int direction  ; // player inputed direction
    public static float gameScore = 0 ; // init game score
    public static float moveCount = 1;// inti move counts
    public static String[] inventory; // creates inventory array
    public static  int idNum = 4;
    public static  int id = 4;
    public static  int itemNum = 0;
    public static double wallet = 0;
    public static boolean isFound;
    public static boolean stackPop = false;
    public static boolean tryQueue = false;
    public static locationStack myStack = new locationStack();
    public static locationQueue myQueue = new locationQueue();


    public static void main(String[] args) {

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



        //inventory
        inventory = new String[6];
        inventory[0] = null;
        inventory[1] = null;
        inventory[2] = null;
        inventory[3] = null;
        inventory[4] = null;// magic item
        inventory[5] = null;// magic item




    }


    //updates console output with main game info
    private static void display(){
        locationStackTester();
        locationQueueTester();
        if(moveCount == 1){
            System.out.println("Welcome to Star Trek: The Next Generation, the text adventure ");
            System.out.println("This game is loosly based on season 6 episode 20, The Chase");
            System.out.println("The goal of the game is to find the 3 DNA fragments before the romulans do");
            System.out.println("You have 20 turns to gather the fragments and head to the vilmoran system");
            System.out.println("If you have any trouble, type help or h to bring up the help menu. Enjoy!");
            System.out.println(" ");
        }

        //System.out.println("end of stack test");

        System.out.println(" your score is: " + gameScore + " your move count is " + moveCount + " Your wallet is " + wallet +
        " your achievement ratio is " + gameScore/moveCount + " " + "The item in this location is " + locItem   );
        System.out.println(currentLoc);


        //nextMove();

    }
    //ends game by quiting main game loop
    private static void quitGame(){
        playFlag = false;
        return;
    }




    //creates player input from text console
    private static void getCommand() {

        Scanner inputReader = new Scanner(System.in);
        input = inputReader.nextLine();  // command is global.
    }



    public static void move(){
        gameItems item0 = new gameItems(0);
        item0.setItemName("DNA fragment 1");
        item0.setLoc(2);

        gameItems item1 = new gameItems(1);
        item1.setItemName("DNA fragment 2");
        item1.setLoc(3);

        gameItems item2 = new gameItems(2);
        item2.setItemName("DNA fragment 3");
        item2.setLoc(5);




        //linked list navigation

        locationListMan locationList = new locationListMan();

        locationClass locale0 = new locationClass(0);
        locale0.setName("starting space");
        locale0.setItem("map");
        locale0.setCash(25);
        locationList.add(locale0);

        locationClass locale1 = new locationClass(0);
        locale1.setName("space quadrant 1");
        locale1.setItem(item1.getItemName());
        locale1.setCash(25);
        locationList.add(locale1);

        locationClass locale2 = new locationClass(0);
        locale2.setName("Ruah IV");
        locale2.setItem(item0.getItemName());
        locationList.add(locale2);

        locationClass locale3 = new locationClass(0);
        locale3.setName("Indri VIII");
        locale3.setItem(item1.getItemName());
        locationList.add(locale3);

        locationClass locale4 = new locationClass(0);
        locale4.setName("Magick Shop Planet");
        locationList.add(locale4);

        locationClass locale5 = new locationClass(0);
        locale5.setName("Loren III");
        locale5.setItem(item2.getItemName());
        locationList.add(locale5);

        locationClass locale6 = new locationClass(0);
        locale6.setName("space quadrant 3");
        locationList.add(locale6);

        locationClass locale7 = new locationClass(0);
        locale7.setName("Vilmoran system");
        locationList.add(locale7);

        locationClass locale8 = new locationClass(0);
        locale8.setName("Brick Wall");
        locationList.add(locale8);

        if(currentLocList == "starting space"){
            locationList.setHead(locale0);
        }

        if(currentLocList == "space quadrant 1"){
            locationList.setHead(locale1);
        }

        if(currentLocList == "Ruah IV"){
            locationList.setHead(locale2);
        }

        if(currentLocList == "Indri VIII"){
            locationList.setHead(locale3);
        }

        if(currentLocList == "space quadrant 2"){
            locationList.setHead(locale4);
        }

        if(currentLocList == "Loren III"){
            locationList.setHead(locale5);
        }

        if(currentLocList == "space quadrant 3"){
            locationList.setHead(locale6);
        }

        if(currentLocList == "Vilmoran system"){
            locationList.setHead(locale7);
        }

        if(currentLocList == "Brick Wall"){
            locationList.setHead(locale8);
        }



        if (input.equalsIgnoreCase("n") || input.equalsIgnoreCase("north")){
            direction = 0;
            locale0.setNext(locale5);
            locale4.setNext(locale0);
            locale5.setNext(locale8);
            locale2.setNext(locale8);
            locale3.setNext(locale2);
            locale1.setNext(locale6);
            locale7.setNext(locale8);
            locale6.setNext(locale8);

        }
        else if (input.equalsIgnoreCase("s") || input.equalsIgnoreCase("south")){
            direction = 1;
            locale7.setNext(locale8);
            locale4.setNext(locale8);
            locale3.setNext(locale8);
            locale2.setNext(locale3);
            locale5.setNext(locale0);
            locale0.setNext(locale4);
            locale1.setNext(locale8);
            locale6.setNext(locale1);
        }

        else if (input.equalsIgnoreCase("e") || input.equalsIgnoreCase("east")){
            direction = 2;
            locale3.setNext(locale4);
            locale2.setNext(locale0);
            locale0.setNext(locale1);
            locale1.setNext(locale7);
            locale6.setNext(locale8);
            locale5.setNext(locale6);
            locale4.setNext(locale8);
            locale7.setNext(locale8);

        }

        else if (input.equalsIgnoreCase("w") || input.equalsIgnoreCase("west")){
            direction = 3;
            locale6.setNext(locale5);
            locale1.setNext(locale0);
            locale0.setNext(locale2);
            locale3.setNext(locale8);
            locale2.setNext(locale8);
            locale5.setNext(locale8);



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
            if (locItem != null){
                inventory[itemNum] = locItem;
                System.out.println("you took an item");
                itemNum = itemNum + 1;
            } else{
                System.out.println("there is no item here.....");
            }
            wallet = wallet + locationList.getHead().getCash();
            if(locationList.getHead().getCash() == 0){
                System.out.println("There is no cash here");
            }
            locationList.getHead().setCash(0);
            return;
        }
        else if(input.equalsIgnoreCase("stack")){
        stackPop = true;
        locationStackTester();
        return;
        }
        else if(input.equalsIgnoreCase("queue")){
            tryQueue = true;
            locationQueueTester();
            return;
        }
        else if (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit")){
            //quitGame();
            return;
        } else if (input.equalsIgnoreCase("m") || input.equalsIgnoreCase("map")){
            map();
            return;
        }

        else {
            System.out.println("I do not understand your query");
        }



        locItem = locationList.getHead().getNext().getItem();

        String newLoc = "";

        if(direction >=0){
          newLoc = locationList.getHead().getName();
            System.out.println("newloc =  " + newLoc);
        } else{
            System.out.println("something went wrong, ill get back to this");
        }


        if (newLoc.equals("Brick Wall") == false ){ //valid locations

            //currentLoc = newLoc; //set current player location
             // output to console
            moveCount = moveCount + 1; //add to move count

            if (locationList.getHead().getHasVisited() == false ){
                locationList.getHead().setHasVisited(true);
                gameScore = gameScore + 5;
                //locationList.setHead(locationList.getHead().getNext());
                currentLoc =locationList.getHead().getNext().getName();
                System.out.println("you have found a new location");
                display();
            } else{
                display();
            }

            if (locationList.getHead().getNext().getName().equals("Magick Shoppe")){

                createMagicItems();
                display();

            }


        } else if(newLoc == "Brick Wall"){
            System.out.println("you cannot go this way"); //going the wrong way

        }


        if (locationList.getHead().getId() >= 0 && locationList.getHead().getNext().getName() != "Brick Wall" ){

        locationList.setHead(locationList.getHead().getNext());
        System.out.println("Your current location is " + locationList.getHead().getName());
        currentLocList = locationList.getHead().getName();
        }
        else{
            System.out.println("you cannot go this way");
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


        if(isFound){
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
            System.out.println("your wallet" + wallet);

            System.out.println("item cost" + li.getCost());
            System.out.println("you dont have enough money, goodbye");
        }
    } else{
            System.out.println("item was not found, bye");
        }

        createMagicItems();



    }

    private static void locationStackTester() {

        //System.out.println("Stack tester.");

        if (stackPop == false){
        try {
            //System.out.println("adding to stack");
            //System.out.println(currentLoc);
            if(currentLoc.equals("dungeon")){
                myStack.push(0);
            }
            else if(currentLoc.equals("Cliffside")){
                myStack.push(1);
            }
            else if(currentLoc.equals("forest")){
                myStack.push(2);
            }
            else if(currentLoc.equals("treasure")){
                myStack.push(3);
            }
            else if(currentLoc.equals("Gate")){
                myStack.push(4);
            }
            else if(currentLoc.equals("Magick Shoppe")){
                myStack.push(5);
            }
            else if(currentLoc.equals("ocean")){
                myStack.push(6);
            }
            else if(currentLoc.equals("Open Field")){
                myStack.push(7);
            }
        }catch (Exception ex) {
            System.out.println("Caught exception: " + ex.getMessage());
        }
        }

        //System.out.println(myStack.isEmpty());

        if(stackPop == true){


            try {

                for(int i = 0; i < moveCount; i++){
                    System.out.println(myStack.pop());
                }

            }
            catch (Exception ex) {
                System.out.println("Caught exception: " + ex.getMessage());
            }

            //System.out.println(myStack.isEmpty());
        }

    }


    private static void locationQueueTester() {

        //System.out.println("Queue tester.");

        if (tryQueue == false){
            try {
                //System.out.println("adding to Queue");
                //System.out.println(currentLoc);
                if(currentLoc.equals("dungeon")){
                    myQueue.enqueue(0);
                }
                else if(currentLoc.equals("Cliffside")){
                    myQueue.enqueue(1);
                }
                else if(currentLoc.equals("forest")){
                    myQueue.enqueue(2);
                }
                else if(currentLoc.equals("treasure")){
                    myQueue.enqueue(3);
                }
                else if(currentLoc.equals("Gate")){
                    myQueue.enqueue(4);
                }
                else if(currentLoc.equals("Magick Shoppe")){
                    myQueue.enqueue(5);
                }
                else if(currentLoc.equals("ocean")){
                    myQueue.enqueue(6);
                }
                else if(currentLoc.equals("Open Field")){
                    myQueue.enqueue(7);
                }
            }catch (Exception ex) {
                System.out.println("Caught exception: " + ex.getMessage());
            }
        }

        //System.out.println(myQueue.isEmpty());

        if(tryQueue == true){


            try {

                for(int i = 0; i < moveCount; i++){
                    System.out.println(myQueue.dequeue());
                }

            }
            catch (Exception ex) {
                System.out.println("Caught exception: " + ex.getMessage());
            }

            //System.out.println(myQueue.isEmpty());
        }

    }




    private static gameItems sequentialSearch(listMan lm,
                                             String target) {
        gameItems retVal = null;
        System.out.println("Searching for " + target + ".");
        int counter = 0;
        gameItems currentItem = new gameItems(idNum);
        currentItem = lm.getHead();

        isFound = false;
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
            System.out.println("               Galaxy Map");
            System.out.println("              ");
            System.out.println("              Loren III ---------------> Space Quadrant 3");
            System.out.println("                 ^                               ^");
            System.out.println("                 |                               |");
            System.out.println("Ruah IV  <----- $Starting Space$ ------>  Space Quadrant 1 ------> Vilmoran system");
            System.out.println("  |                     ^");
            System.out.println("  V                     |");
            System.out.println("Indri VIII -----> Magic Shop Planet");
            System.out.println("         ");

        } else{
            System.out.println("you do not have the map yet");
        }
    }
}

