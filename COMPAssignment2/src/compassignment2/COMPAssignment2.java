package compassignment2;

import java.util.Scanner;

/**
 * Sehajpreet Kaur Khurana (101282557)
 * Amandeep hazra (101286346)
 * James Weber De Asis (101299435)
 */

public class COMPAssignment2 {

    public static int getInteger(Scanner sc,String message){
        do{
            System.out.print(message);
            sc.nextLine();
        } while (!sc.hasNextInt());
        return sc.nextInt();
    }
        
    public static double getDouble(Scanner sc,String message){
        System.out.print(message);
        while (!sc.hasNextDouble()) {
            sc.nextLine(); //clear the invalid input ...
            System.out.print(message);
        }
        return sc.nextDouble();
    }
        
    
    public static void addWeapons(ArrayManager h,Scanner sc){
        System.out.println("***********WELCOME TO THE WEAPON ADDING MENU*********");
        String weaponName; int weaponRange = -1; int weaponDamage; double weaponWeight; double weaponCost;
        int quantity;
        System.out.print("Please enter the NAME of the Weapon ('end' to quit):");
        weaponName=sc.next();
        while (weaponName.compareTo("end") != 0){
            if(h.checkExists(weaponName)!= null){
                quantity=getInteger(sc,"Please enter the quantity in stock:");
                Weapon w = new Weapon(weaponName, 0, 0, 0, 0);
                h.put(w,quantity); 
            }
            else{
                while(!(weaponRange >= 0 && weaponRange <= 10)){
                    weaponRange= getInteger(sc,"Please enter the Range of the Weapon (0-10):");
                }
                weaponDamage=getInteger(sc,"Please enter the Damage of the Weapon:"); 
                weaponWeight= getDouble(sc,"Please enter the Weight of the Weapon (in pounds):");
                weaponCost=getDouble(sc,"Please enter the Cost of the Weapon:");
                Weapon w = new Weapon(weaponName, weaponRange, weaponDamage, weaponWeight, weaponCost);
                quantity=getInteger(sc,"Please enter the quantity in stock:"); 
                h.put(w,quantity);    
            }       
            System.out.print("Please enter the NAME of another Weapon ('end' to quit):");
            weaponName = sc.next();
        }
    }
    
    public static void deleteWeapons(ArrayManager h, Scanner sc){
        String weaponName;
        System.out.println("Please type the item you want deleted (case-sensitive)");
        weaponName=sc.next();
        while (weaponName.compareTo("end") != 0){
            h.remove(weaponName);
            h.printTable();
            System.out.print("Please enter the NAME of another Weapon ('end' to quit):");
            weaponName = sc.next();
        }
    }



    public static void showRoomMenu(ArrayManager ht,Player p){
        System.out.println("WELCOME TO THE SHOWROOM!!!!");
        ht.printShop();
        System.out.println("You have "+p.money+" money.");
        System.out.println("Please select a weapon to buy('end' to quit):");
    }
        
    public static void showRoom(ArrayManager ht, Player p,Scanner sc){
        String choice;
        showRoomMenu(ht,p);
        choice=sc.next();
        while (choice.compareTo("end") != 0 && !p.inventoryFull()){
            ShopItem si = ht.checkExists(choice);
            if (si != null){
                if(si.item.cost > p.money || si.numberInStock == 0){
                    System.out.println("Item to expensive or Out of stock");
                }
                else{
                    if(p.buy(si.item.weaponName, si.item.range, si.item.damage, si.item.weight, si.item.cost)){
                        ht.buy(choice);
                    }
                    else {
                        System.out.println("Item too heavy");
                    }
                    
                } 
            }
            else{
                System.out.println(" ** "+choice+" not found!! **" );
            }
            showRoomMenu(ht,p);
            choice = sc.next();
        }
        System.out.println("");
    }
    
    public static void showMainMenu(){
        System.out.println("********WELECOME TO THE MAIN MENU********");
        System.out.println("Type and Enter the number of the function you want to perform");
        System.out.println("1. Add Items to the shop\n2. Delete Items from "
                + "the shop\n3. Buy from the Shop\n4. View Backpack\n5. "
                + "View Player\n6. Exit");
    }
     
    
    public static void runProgram(ArrayManager ht, Player pl, Scanner sc){
        boolean cond = true;
        int input;
        do{
            showMainMenu();
            input = getInteger(sc, "Please enter an integer between 1 - 6: ");
            switch (input){
                case 1:
                    addWeapons(ht, sc);
                    break;
                case 2:
                    ht.printTable();
                    deleteWeapons(ht, sc);
                    break;
                case 3:
                    showRoom(ht, pl, sc);
                    break;
                case 4:
                    pl.printBackpack();
                    break;
                case 5:
                    pl.printCharacter();
                    pl.printBackpack();
                    break;
                case 6:
                    cond = false;
                    break; 
            }
        } while(cond);
    }
        
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String pname;
        System.out.println("Please enter Player name:");
        pname=sc.next();
        Player pl= new Player(pname);
        ArrayManager ht= new ArrayManager(101);
        runProgram(ht, pl, sc);
    }
}
