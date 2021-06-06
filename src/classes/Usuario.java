package classes;


/**
 * Essa classe realiza realiza o mapeamento de um usuário em relação a tabela do
 * banco de dados
 * 
 * @author Caio Rodrigues, Carlos Junior, Gabriel Zecchi, Murilo Leopoldino
 * @date 01/05/2021
 * 
 */
 
public class Usuario {

    private String email, senha, nome, telefone;

    // Getters
    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    // Setters
    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Usuario() {
        this.email = "";
        this.senha = "";
        this.nome = "";
        this.telefone = "";
    }

    public Usuario(String email, String senha, String nome, String telefone) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.telefone = telefone;
    }
}