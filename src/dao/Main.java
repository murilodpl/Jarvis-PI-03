package dao;

import classes.Projeto;
import dao.ProjetoDAO;

public class Main {

	public static void main(String[] args) {
	
		//Projeto CRUD
		ProjetoDAO projetoDao = new ProjetoDAO();
		
		//Projeto CREATE
		/*  	
 		Projeto projetoCreate = new Projeto();
		projetoCreate.setNomeProjeto("Mech");
		projetoCreate.setDescricaoProjeto("Para robotica da escola");
		projetoCreate.setEquipeProjeto("Equipe 7");
		projetoCreate.setEmailUser("neymal@bol.com.br");
		projetoDao.create(projetoCreate); 
		 */
		
		//Projeto READ and READALL
		/*
		projetoDao.read(16);
		projetoDao.readAll();
		 */
		
		
		//Projeto UPDATE
		/*
		Projeto projetoUpdate = new Projeto();
		projetoUpdate.setCodProjeto(17);
		projetoUpdate.setEquipeProjeto("Equipe 9");
		projetoDao.update(projetoUpdate);
		*/
		
		//Projeto DELETE
		//projetoDao.delete(13);
		
		
	
		//Tarefa CRUD
		TarefaDAO tarefaDao = new TarefaDAO();
		
		//Tarefa CREATE
		/*
		Tarefa tarefaCreate = new Tarefa();
		tarefaCreate.setnomeTarefa("Checar o backend");
		tarefaCreate.setDescricaoTarefa("Ver se o backend está bem estruturado e funcionando certinho");
		tarefaCreate.setDataInicio("2021-04-29");
		tarefaCreate.setDataFim("2021-05-07");
		tarefaCreate.setCodProjeto(1);
		tarefaCreate.setEmailUser("fabio.gamer@hotmail.com");
		tarefaDao.create(tarefaCreate);
		*/
		
		//Tarefa READ and READALL and READBYPROJECTID
		/*
		tarefaDao.read(5);
		tarefaDao.readAll();
		tarefaDao.readByProjectID(1);
		*/
		
		//Tarefa UPDATE
		/*
		Tarefa tarefaUpdate = new Tarefa();
		tarefaUpdate.setCodTarefa(5);
		tarefaUpdate.setDescricaoTarefa("Os valores da tabela de produtos devem ser verificados com base nos preços fornecidos atualizados!!");
		tarefaDao.update(tarefaUpdate);
		*/
		
		//Tarefa DELETE
		//tarefaDao.delete(6);
		
		
		
		//Usuario CRUD
		UsuarioDAO usuarioDao = new UsuarioDAO();
		
		//Usuario CREATE
		/*
		Usuario usuarioCreate = new Usuario();
		usuarioCreate.setEmail("murilo@gmail.com");
		usuarioCreate.setNome("Murilo Leopoldino");
		usuarioCreate.setSenha("murilinho123");
		usuarioCreate.setTelefone("19982435564");
		usuarioDao.create(usuarioCreate);
		*/
		
		//Usuario READ and READALL
		/*
		usuarioDao.read("murilo@gmail.com");
		usuarioDao.readAll();
		*/
		
		//Usuario UPDATE
		/*
		Usuario usuarioUpdate = new Usuario();
		usuarioUpdate.setEmail("murilo@gmail.com");
		usuarioUpdate.setNome("Murilo de Paula Leopoldino");
		usuarioUpdate.setSenha("Murilinho@123");
		usuarioDao.update(usuarioUpdate);
		*/
		
		//Usuario DELETE
		//usuarioDao.delete("murilo@gmail.com");
		
	}
	
}
