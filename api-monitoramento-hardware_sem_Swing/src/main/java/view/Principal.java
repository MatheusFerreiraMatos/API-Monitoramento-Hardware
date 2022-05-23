/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.ControllerComputadores;
import controller.ControllerMonitoramento;
import controller.ControllerProcesso;
import controller.ControllerSlack;
import controller.ControllerUsuario;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import logger.Log;
import model.ModelUsuario;

/**
 *
 * @author mathe
 */
public class Principal {

    public static void main(String[] args) throws UnknownHostException {
        Log log = new Log();
        log.createDirectory();
        log.createFile();
        ControllerUsuario validar = new ControllerUsuario();
        ModelUsuario usuario = new ModelUsuario();
        ControllerComputadores controllerComputadores = new ControllerComputadores();
        ControllerMonitoramento controllerMonitoramento = new ControllerMonitoramento();
        ControllerProcesso controllerProcessos = new ControllerProcesso();
        ControllerSlack controllerNotificacoes = new ControllerSlack();

        System.out.println("-------------------------------[ OnHome ]-------------------------------");
        log.append("-------------------------------[ OnHome ]-------------------------------");
        System.out.println("\nOlá ao terminal da aplicação da OnHome \\(^-^)/\n");
        log.append("\nOlá ao terminal da aplicação da OnHome \\(^-^)/\n");

        String email = "admin@onhome.com";
        String senha = "admin@admin";
        try {
            System.out.println("---------------------------[ Banco de Dados ]---------------------------\n");
            log.append("---------------------------[ Banco de Dados ]---------------------------\n");
            System.out.println("Conectando ao Banco de Dados...\n");
            log.append("Conectando ao Banco de Dados...");
            System.out.println("Banco de Dados Conectado!\n");
            log.append("Banco de Dados Conectado!\n");
            //controllerNotificacoes.enviarNotificacao(email, senha);
            controllerComputadores.insertComputador(email, senha);
            System.out.println("-----------------------------[ Descrição ]------------------------------\n");
            log.append("-----------------------------[ Descrição ]------------------------------\n");
            controllerMonitoramento.insertMonitoramento();
            controllerProcessos.insertProcesso();
        } catch (UnknownHostException ex) {
            log.append(ex.getMessage());
        }

    }

}
