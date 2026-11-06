package modelo;

public class Tarefa {

    private final int id;
    private String descricao;
    private int responsavelId;
    private StatusTarefa status;

    public Tarefa(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
        this.responsavelId = 0;
        this.status = StatusTarefa.PENDENTE;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getResponsavelId() {
        return responsavelId;
    }

    public void setResponsavelId(int responsavelId) {
        this.responsavelId = responsavelId;
    }

    public StatusTarefa getStatus() {
        return status;
    }

    public void setStatus(StatusTarefa status) {
        this.status = status;
    }

    @Override
    public String toString() {
        String responsavel = responsavelId == 0 ? "sem responsavel" : "responsavel=" + responsavelId;
        return "Tarefa [id=" + id + ", descricao=" + descricao + ", status=" + status + ", " + responsavel + "]";
    }
}
