package compassignment2;

/**
 * Sehajpreet Kaur Khurana (101282557)
 * Amandeep hazra (101286346)
 * James Weber De Asis (101299435)
 */

class Player {
    public String name;
    public Weapon[] backpack;
    public int numItems;
    public double money;

    public Player(String n, double m){
            name = n;
            money = m;
            numItems = 0;
            backpack = new Weapon[10];
    }

    public void buy(Weapon w){
        System.out.println(w.weaponName+" bought...");
        backpack[numItems] = w;
        numItems++;
        System.out.println(numItems);
    }
    public void withdraw(double amt){
        money = money - amt;
    }

    public boolean inventoryFull(){
        return (numItems == 10) ;
    }

    public void printCharacter(){
        System.out.println(" Name:"+name+"\n Money:"+money);
        printBackpack();
    }

    public void printBackpack(){
        System.out.println(" "+name+", you own "+numItems+" Weapons:");
        for (int x = 0; x < numItems; x++){
            System.out.println(" "+backpack[x].weaponName);
        }
        System.out.println();
    }
}
