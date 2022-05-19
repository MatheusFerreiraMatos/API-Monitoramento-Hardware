/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.ControllerUsuario;

/**
 *
 * @author mathe
 */
public class Teste {
    public static void main(String[] args) {
        //Usuario usuario = new Usuario();
        ControllerUsuario controllerUsuario = new ControllerUsuario();
              
        controllerUsuario.logar("admin@onhome.com.br", "admin@admin");
        //System.out.println(usuario.getNomeUsuario());
    }
}
