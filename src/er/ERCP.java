/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package er;

/**
 *
 * @author formation
 */
public class ERCP {
    public static void main(String[] args) {
       // --- Un cp
        String motif = "[0-9]{5}";
        String cp = "75011";
        if (cp.matches(motif)) {
            System.out.println("CP OK");
        } else {
            System.out.println("CP KO");
        }        
    }
}
