package model;

/**
 *
 * @author mathe
 */
public class Contador {

    private Integer insertComputadores;
    private Integer insertMonitoramento;
    private Integer insertProcessos;
    private Integer totalInsert;
    private Integer totalSelect;

    public Integer getInsertComputadores() {
        return insertComputadores;
    }

    public void setInsertComputadores(Integer insertComputadores) {
        this.insertComputadores = insertComputadores;
    }

    public Integer getInsertMonitoramento() {
        return insertMonitoramento;
    }

    public void setInsertMonitoramento(Integer insertMonitoramento) {
        this.insertMonitoramento = insertMonitoramento;
    }

    public Integer getInsertProcessos() {
        return insertProcessos;
    }

    public void setInsertProcessos(Integer insertProcessos) {
        this.insertProcessos = insertProcessos;
    }

    public Integer getTotalInsert() {
        totalInsert = insertComputadores + insertMonitoramento + insertProcessos;
        return totalInsert;
    }

    public void setTotalInsert(Integer totalInsert) {
        this.totalInsert = totalInsert;
    }

    public Integer getTotalSelect() {
        return totalSelect;
    }

    public void setTotalSelect(Integer totalSelect) {
        this.totalSelect = totalSelect;
    }

    @Override
    public String toString() {
        return String.format("Comandos executados no Banco de Dados: \n\n"
                + "Total de INSERTs: %d \n"
                + "Total de SELECTs: %d \n", totalInsert, totalSelect);
    }

    
}
