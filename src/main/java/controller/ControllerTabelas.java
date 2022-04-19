package controller;

import connection.Connection;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Matheus Mattos
 */
public class ControllerTabelas {

    //Instanciando conexão com o banco de dados e jdbc;
    Connection config = new Connection();
    JdbcTemplate connect = new JdbcTemplate(config.getDataSource());

    public void criarTabelas() {

        //Variaveis com o comando para criação das tabelas do sistema;
        String tabelaPlanos = "CREATE TABLE IF NOT EXISTS Licenca ("
                + "idLicenca INT PRIMARY KEY AUTO_INCREMENT,"
                + "tipo VARCHAR(45),"
                + "quantComputadores INT,"
                + "dataAquisicao DATETIME,"
                + "valor DOUBLE)";

        String tabelaEmpresa = "CREATE TABLE IF NOT EXISTS Empresa ("
                + "idEmpresa INT PRIMARY KEY AUTO_INCREMENT,"
                + "nomeFantasia VARCHAR(100),"
                + "cnpj CHAR(14),"
                + "fkLicenca INT)";

        String tabelaEnderecos = "CREATE TABLE IF NOT EXISTS Endereco ("
                + "idEndereco INT PRIMARY KEY AUTO_INCREMENT,"
                + "cep CHAR(8),"
                + "logadouro VARCHAR(100),"
                + "numero INT,"
                + "bairro VARCHAR(45),"
                + "complemento VARCHAR(30),"
                + "estado VARCHAR(100),"
                + "cidade VARCHAR(100),"
                + "fkEmpresa INT)";

        String tabelaContatos = "CREATE TABLE IF NOT EXISTS Contatos ("
                + "idContatos INT PRIMARY KEY AUTO_INCREMENT,"
                + "telefoneEmpresa VARCHAR(11),"
                + "emailEmpresa VARCHAR(45),"
                + "fkEmpresa INT)";

        String tabelaUsuario = "CREATE TABLE IF NOT EXISTS Usuario ("
                + "idUsuario INT PRIMARY KEY AUTO_INCREMENT,"
                + "nomeUsuario VARCHAR(50),"
                + "emailUser VARCHAR(50),"
                + "senhaUser VARCHAR(50),"
                + "fkEmpresa INT,"
                + "fkPermissao INT)";

        String tabelaComputadores = "CREATE TABLE IF NOT EXISTS Computadores ("
                + "idComputador INT PRIMARY KEY AUTO_INCREMENT,"
                + "sistemaOperacional VARCHAR(20),"
                + "modeloProcessador VARCHAR(50),"
                + "idProcessador VARCHAR(30),"
                + "tamanhoDisco VARCHAR(25),"
                + "tamanhoDiscoSecundario VARCHAR(25),"
                + "tamanhoRam VARCHAR(25),"
                + "fkUsuario INT)";

        String tabelaMonitoramento = "CREATE TABLE IF NOT EXISTS Monitoramento ("
                + "idMonitoramento int primary key auto_increment,"
                + "processadorLogico int,"
                + "processadorFisico int,"
                + "usandoCpu double,"
                + "usandoDisco double,"
                + "usandoRam double,"
                + "dataHoraCaptura datetime,"
                + "tempoLigada time,"
                + "fkComputador int)";

        String tabelaProcesso = "CREATE TABLE IF NOT EXISTS Processo ("
                + "idProcesso int primary key auto_increment,"
                + "nomeProcesso varchar(100),"
                + "usoCpu double,"
                + "usoMemoria double,"
                + "usoGpu double,"
                + "dataCaptura datetime,"
                + "fkComputador int);";

        //Criando as tabelas no Banco de Dados local (OBS: só irá ser criado a 
        //tabela se o banco de dados estiver criado), tabelas configuradas para
        //casos a tabela já exista o sistema não precisar criar;
        System.out.println("Criando tabelas... \n"
                + tabelaPlanos + "\n"
                + tabelaEmpresa + "\n"
                + tabelaEnderecos + "\n"
                + tabelaContatos + "\n"
                + tabelaUsuario + "\n"
                + tabelaComputadores + "\n"
                + tabelaMonitoramento + "\n"
                + tabelaProcesso + "\n");

        connect.update(tabelaPlanos);
        connect.update(tabelaEmpresa);
        connect.update(tabelaEnderecos);
        connect.update(tabelaContatos);
        connect.update(tabelaUsuario);
        connect.update(tabelaComputadores);
        connect.update(tabelaMonitoramento);
        connect.update(tabelaProcesso);
        
        System.out.println("Tabelas criadas com sucesso!");

    }
}
