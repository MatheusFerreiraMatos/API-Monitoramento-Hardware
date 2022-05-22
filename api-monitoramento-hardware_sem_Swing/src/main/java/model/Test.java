/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mathe
 */
public class Test {
    public static void main(String[] args) {
        ModelUsuario user = new ModelUsuario();
        
        user.recuperar("admin@onhome.com", "admin@admin");
        
        System.out.println(user.getEmailUser());
    }
}
