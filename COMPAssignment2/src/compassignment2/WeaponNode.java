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
public class WeaponNode {
    WeaponNode next;
    Weapon data;
 
    /* Constructor */
    public WeaponNode(Weapon x)
    {
        data = x;
        next = null;
    }
}
