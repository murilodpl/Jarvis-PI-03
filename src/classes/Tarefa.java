package classes;


/**
 * Essa classe realiza o mapeamento de uma tarefa em relação a tabela do banco de dados.
 * 
 * @author Caio Rodrigues, Carlos Junior, Gabriel Zecchi, Murilo Leopoldino
 * @date 01/05/2021	
 */

public class Tarefa {
	private int codTarefa, codProjeto;
	private String nomeTarefa, descricaoTarefa, dataInicio, dataFim, emailUser;
	
	//Getters
	public int getCodTarefa() {
		return codTarefa;
	}
	public String getNomeTarefa() {
		return nomeTarefa;
	}
	public String getDescricaoTarefa() {
		return descricaoTarefa;
	}
	public String getDataInicio() {
		return dataInicio;
	}
	public String getDataFim() {
		return dataFim;
	}
	public String getEmailUser() {
		return emailUser;
	}
	public int getCodProjeto() {
		return codProjeto;
	}
	
	//Setters
	public void setCodTarefa(int codTarefa) {
		this.codTarefa = codTarefa;	
	}
	public void setnomeTarefa(String nomeTarefa) {
		this.nomeTarefa = nomeTarefa;	
	}
	public void setDescricaoTarefa(String descricaoTarefa) {
		this.descricaoTarefa = descricaoTarefa; 
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio; 
	}
	public void setDataFim(String dataFim) {
		this.dataFim = dataFim; 
	}
	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser; 
	}
	public void setCodProjeto(int codProjeto) {
		this.codProjeto = codProjeto;
	}
	
	public Tarefa() {
		this.codTarefa = 0;	
		this.nomeTarefa = "";			
		this.descricaoTarefa = ""; 
		this.dataInicio = ""; 
		this.dataFim = ""; 
		this.codProjeto = 0;
		this.emailUser = "";
	}
	
	public Tarefa(int codTarefa, String nomeTarefa, int codProjeto, String emailUser) {
		this.codTarefa = codTarefa;	
		this.nomeTarefa = nomeTarefa;
		this.codProjeto = codProjeto;
		this.emailUser = emailUser;
	}
	
	public Tarefa(int codTarefa, String nomeTarefa, String descricaoTarefa, String dataInicio, String dataFim, int codProjeto, String emailUser) {
		this.codTarefa = codTarefa;	
		this.nomeTarefa = nomeTarefa;
		this.descricaoTarefa = descricaoTarefa;
		this.dataInicio = dataInicio; 
		this.dataFim = dataFim;
		this.codProjeto = codProjeto;
		this.emailUser = emailUser;
	}
	
	/**
	 * Essa classe altera as informações da tarefa.
	 * 
	 * @param nomeTarefa        - Nome da tarefa
	 * @param descricaoTarefa   - Descrição da tarefa
	 * @param dataInicio        - Data de inicio da tarefa
	 * @param dataFim           - Data de termino da tarefa
	 * @param codProjeto        - Codigo do projeto que a tarefa pertence
	 * @param emailUser         - Email do usuário cadastrado
	 */
	public void alterTarefa(String nomeTarefa, String descricaoTarefa, String dataInicio, String dataFim, int codProjeto, String emailUser) {
		this.nomeTarefa = nomeTarefa;
		this.descricaoTarefa = descricaoTarefa;
		this.dataInicio = dataInicio; 
		this.dataFim = dataFim; 
		this.codProjeto = codProjeto;
		this.emailUser = emailUser;
	}
}
