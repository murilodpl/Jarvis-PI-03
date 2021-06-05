package classes;


/**
 * Essa classe realiza o mapeamento de um projeto em relação a tabela do banco de dados.
 * 
 * @author Caio Rodrigues, Carlos Junior, Gabriel Zecchi, Murilo Leopoldino
 * @date 01/05/2021	
 */

public class Projeto {
	private int codProjeto;
	private String nomeProjeto, descricaoProjeto, equipeProjeto, emailUser;
	
	//Getters
	public double getCodProjeto() {
		return codProjeto;
	}
	public String getNomeProjeto() {
		return nomeProjeto;
	}
	public String getDescricaoProjeto() {
		return descricaoProjeto;
	}
	public String getEquipeProjeto() {
		return equipeProjeto;
	}
	public String getEmailUser() {
		return emailUser;
	}
	
	//Setters
	public void setCodProjeto(int codProjeto) {
		this.codProjeto = codProjeto;	
	}
	public void setNomeProjeto(String nomeProjeto) {
		this.nomeProjeto = nomeProjeto;	
	}
	public void setDescricaoProjeto(String descricaoProjeto) {
		this.descricaoProjeto = descricaoProjeto; 
	}
	public void setEquipeProjeto(String equipeProjeto) {
		this.equipeProjeto = equipeProjeto; 
	}
	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser; 
	}
	
	public Projeto() {
		this.codProjeto = 0;	
		this.nomeProjeto = "";			
		this.descricaoProjeto = ""; 
		this.equipeProjeto = ""; 
		this.emailUser = "";
	}
	
	public Projeto(int codProjeto, String nomeProjeto, String emailUser) {
		this.codProjeto = codProjeto;	
		this.nomeProjeto = nomeProjeto;
		this.emailUser = emailUser;
	}
	
	public Projeto(int codProjeto, String nomeProjeto, String descricaoProjeto, String equipeProjeto) {
		this.codProjeto = codProjeto;	
		this.nomeProjeto = nomeProjeto;
		this.descricaoProjeto = descricaoProjeto;
		this.equipeProjeto = equipeProjeto; 
	}
	
	public Projeto(String nomeProjeto, String descricaoProjeto, String equipeProjeto, String emailUser) {
		this.nomeProjeto = nomeProjeto;
		this.descricaoProjeto = descricaoProjeto;
		this.equipeProjeto = equipeProjeto; 
		this.emailUser = emailUser;
	}
	
	public Projeto(int codProjeto, String nomeProjeto, String descricaoProjeto, String equipeProjeto, String emailUser) {
		this.codProjeto = codProjeto;	
		this.nomeProjeto = nomeProjeto;
		this.descricaoProjeto = descricaoProjeto;
		this.equipeProjeto = equipeProjeto; 
		this.emailUser = emailUser;
	}

	/**
	 * Essa classe altera as informações da projeto.
	 * 
	 * @param nomeProjeto        - Nome do projeto
	 * @param descricaoProjeto   - Descrição do projeto
	 * @param equipeProjeto      - Integrantes da equipe do projeto
	 * @param emailUser         - Email do usuário cadastrado
	 */
	public void alterarProjeto(String nomeProjeto, String descricaoProjeto, String equipeProjeto, String emailUser) {
		this.nomeProjeto = nomeProjeto;
		this.descricaoProjeto = descricaoProjeto;
		this.equipeProjeto = equipeProjeto; 
		this.emailUser = emailUser;
	}
}
