package compassignment2;

/**
 * Sehajpreet Kaur Khurana (101282557)
 * Amandeep hazra (101286346)
 * James Weber De Asis (101299435)
 */

public class ArrayManager {
    
        int maxItems;    // records the max size of the table
        int numItems;       // records number of items in the list
        double loadFactor;
        ShopItem[] table; //hashtable itself

        public ArrayManager()
        {
            maxItems = 101;
            numItems = 0;
            loadFactor = 0.80;
            table = new ShopItem[maxItems];
        }
        
        public ArrayManager(int size)
        {
            maxItems = size;
            numItems = 0;
            loadFactor = 0.80;
            table = new ShopItem[maxItems];
        }
        
        private int hashFunction(String weaponName){        
            int value=0 ,weight =1 ;
            for(int x=0;x<weaponName.length();x++){
                value+=(weaponName.charAt(x)-'a'+1)*weight;
                weight++;
            }
            return value %maxItems;
        }
        
        public ShopItem checkExists(String key)
        {
            int loc = hashFunction(key); //gets location in table based on key
            int i = 0;
            while(table[loc] != null && table[loc].item.weaponName.compareTo(key)!=0){
                loc = (loc + (i*i))%maxItems; 
                i++;
            }
            if(table[loc] == null){
                return null;
            }
            return table[loc];          
        }

        public void put(Weapon item,int quantity)
        {
            if(checkExists(item.weaponName) != null){
                checkExists(item.weaponName).numberInStock += quantity;
            }
            else if(numItems/maxItems < loadFactor){
                int loc = hashFunction(item.weaponName);
                int i = 1;
                
                while(table[loc] != null && table[loc].item.weaponName.compareTo("DELETED") !=0){
                    loc = (loc + (i*i))%maxItems; 
                    i++;
                }
                table[loc]= new ShopItem(item,quantity);
                numItems++;
            }
        }
        
        public boolean buy(String item){
            if(checkExists(item) != null){
                if(checkExists(item).numberInStock > 0){
                    checkExists(item).numberInStock--;
                    return true;
                } 
                else{
                    System.out.println("Not enough stock or Non-available");
                }         
            }
            return false;
        }
        
        public void remove(String item){
            if(checkExists(item) != null){
                checkExists(item).item.weaponName = "DELETED";
                numItems --;
            } 
            else{
                System.out.println("Item does not exist");
            }           
        }
        
         
        public void printTable()
        {
            int i = 0;
            System.out.println("********List of Items from the shop********");
            for (ShopItem sc : this.table)
            {
                if(sc != null && sc.item.weaponName != "DELETED"){
                    System.out.println("Name: " +sc.item.weaponName+"   Damage:"+sc.item.damage+"    Cost:"+sc.item.cost+"     Quantity in stock:"+sc.numberInStock + " ");
                } 
                i++;
            }
        }
        
        public void printShop()
        {
            int i = 0;
            
            for (ShopItem sc : this.table)
            {
                if(sc != null && sc.numberInStock > 0 && sc.item.weaponName != "DELETED"){
                    System.out.println("Name: " +sc.item.weaponName+"   Damage:"+sc.item.damage+"    Cost:"+sc.item.cost+"     Quantity in stock:"+sc.numberInStock + " ");
                } 
                i++;
            }
        }
}

