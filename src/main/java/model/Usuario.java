/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mathe
 */
public class Usuario {
    private Integer idUsuario;
    private String nomeUsuario;
    private String emailUser;
    private String senhaUser;
    private Integer fkEmpresa;
    private Integer fkPermissao;
    private Integer fkEspecialidade;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getSenhaUser() {
        return senhaUser;
    }

    public void setSenhaUser(String senhaUser) {
        this.senhaUser = senhaUser;
    }

    public Integer getFkEmpresa() {
        return fkEmpresa;
    }

    public void setFkEmpresa(Integer fkEmpresa) {
        this.fkEmpresa = fkEmpresa;
    }

    public Integer getFkPermissao() {
        return fkPermissao;
    }

    public void setFkPermissao(Integer fkPermissao) {
        this.fkPermissao = fkPermissao;
    }

    public Integer getFkEspecialidade() {
        return fkEspecialidade;
    }

    public void setFkEspecialidade(Integer fkEspecialidade) {
        this.fkEspecialidade = fkEspecialidade;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nomeUsuario=" + nomeUsuario + ", emailUser=" + emailUser + ", senhaUser=" + senhaUser + ", fkEmpresa=" + fkEmpresa + ", fkPermissao=" + fkPermissao + ", fkEspecialidade=" + fkEspecialidade + '}';
    }
    
    
}
