package compassignment2;

/**
 * Sehajpreet Kaur Khurana (101282557)
 * Amandeep hazra (101286346)
 * James Weber De Asis (101299435)
 */

public class Player { // similar to array manager
    public String name;
    public Backpack bp;// will player have array of backapcks or array of weapons
    public int numItems;
    public double money;
    
    public Player(String name) {
        this.name = name;
        this.bp = new Backpack();
        this.numItems = 0;       
        this.money = 45;
    }
        
    public boolean buy(String weaponName, int range , int damage , double weight , double  cost) {
        if(money > cost){
            if( bp.insert(name, range, damage, weight, cost)==true){
                    numItems++;
                    withdraw(cost);
                    return true;
            }
        }
        return false;
    }
        
    public void withdraw(double amt) // delete
        {
            money = money - amt;
        }
        
    public boolean inventoryFull(){
        return (numItems == 30) ;
    }

    public void printCharacter(){
        System.out.println(" Name:"+name+"\n Money:"+money);
        printBackpack();
    }
    
    public void printBackpack(){
        System.out.println(" "+name+", you own "+numItems+" Weapons:");
        for (int x = 0; x < numItems; x++){
//            System.out.println(" "+bp[x].weaponName);
        }
        System.out.println();
    }
}

