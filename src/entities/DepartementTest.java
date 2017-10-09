/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

/**
 *
 * @author formation
 */
public class DepartementTest {
    public static void main(String[] args) {
        Departement d75 = new Departement(1, "75", "Scène");
        System.out.println(d75);
        
        System.out.println(d75.getCodeDepartement());
        System.out.println(d75.getIdDepartement());
        System.out.println(d75.getNomDepartement());
    }
}
