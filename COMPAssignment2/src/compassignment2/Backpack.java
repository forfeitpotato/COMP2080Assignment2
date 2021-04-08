/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compassignment2;

/**
 *
 * @author James
 */
public class Backpack {
    
   public  WeaponNode[]table;
   public int numItems;
   public int maxItems;
   public double currWeight;
   public double maxWeight;
   //stores the weapon  in a hash table 

    public Backpack() {
        this.table = new WeaponNode[41];
        this.numItems = 0;
        this.maxItems = 41;
        this.currWeight = 0;
        this.maxWeight = 90;
    }
   
    
     private int hashFunction(String weaponName){
        
        int value=0 ,weight =1 ;
        for(int x=0;x<weaponName.length();x++){
        value+=(weaponName.charAt(x)-'a'+1)*weight;
        weight++;
        }
        
       return value %maxItems;
    
    
}
      public boolean insert(String weaponName, int range, int damage, double weight, double cost)
    {
        //90pounds add here 
        
        if(currWeight + weight < maxWeight && numItems<maxItems ){
            currWeight+=weight;
            numItems++;
            Weapon w = new Weapon(weaponName, range, damage,  weight,  cost);
            int pos = hashFunction( weaponName);       //no while loop as we dont need to find when null comes , if its null then put otherwise add front  
            WeaponNode nptr = new WeaponNode(w);                
            if (table[pos] == null){
                table[pos] = nptr; 
            }            
            else {
            nptr.next = table[pos];
            table[pos] = nptr;
            } 
            return true;
        }
        return false;
    }
       public void printHashTable ()
    {
        System.out.println();
        for (int i = 0; i < table.length; i++)
        {
            System.out.print ("Weapon " + i + ":  ");             
            WeaponNode start = table[i];
            while(start != null)
            {
                System.out.print(start.data.weaponName +" ");
                start = start.next;
            }
            if(table[i]==null){
                System.out.println("empty");
            }
            
            System.out.println();
        }
    }
   
     
     
     
     
     
     
     
}