package model;

import java.time.LocalDate;

/**
 *
 * @author Matheus Mattos
 */
public class Usuario {

    private Integer idUser;
    private String nomeUser;
    private String emailUser;
    private String senhaUser;
    private String cargo;
    private LocalDate dataCadastro;
    private LocalDate dataDateAtualizacao;
    private Integer fkEmpresa;

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getNomeUser() {
        return nomeUser;
    }

    public void setNomeUser(String nomeUser) {
        this.nomeUser = nomeUser;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDate getDataDateAtualizacao() {
        return dataDateAtualizacao;
    }

    public void setDataDateAtualizacao(LocalDate dataDateAtualizacao) {
        this.dataDateAtualizacao = dataDateAtualizacao;
    }

    public Integer getFkEmpresa() {
        return fkEmpresa;
    }

    public void setFkEmpresa(Integer fkEmpresa) {
        this.fkEmpresa = fkEmpresa;
    }

}
