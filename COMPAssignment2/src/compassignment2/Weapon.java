package compassignment2;

/**
 * Sehajpreet Kaur Khurana (101282557)
 * Amandeep hazra (101286346)
 * James Weber De Asis (101299435)
 */

class Weapon {
    public String weaponName; 
    public int range;
    public int damage;
    public double weight;
    public double cost;

    public Weapon(String n, int rang, int dam, double w, double c){
        weaponName = n;
        damage = dam;
        range = rang;
        weight = w;
        cost = c;
    }
}


