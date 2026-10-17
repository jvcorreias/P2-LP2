package app;

import modelo.*;

public class AppRoteiro {
	public static void main(String [] args) {
		Instituicao UERJ = new Instituicao("UERJ");
		System.out.println(UERJ);
		UERJ.criarAluno("Gabriel Henrique", "209naoemeucpf-82");
		UERJ.exibirAlunos();
		UERJ.exibirDisciplinas();
		Aluno eu = UERJ.getAluno(1);
		eu.ordenarMatriculas();
		
		UERJ.criarDisciplina("LP2", "202020", 2, 10);
		UERJ.exibirDisciplinas();
		UERJ.criarDisciplina("LP1", "202020", 0, 0);
		UERJ.criarDisciplina("AED2", "666666", 3, 12);
		UERJ.criarDisciplina("Cálculo 3" , "número :-)", 4, 5);
		
		UERJ.exibirDisciplinas();
		
		eu.matricular(UERJ.getDisciplina(1));
		eu.matricular(UERJ.getDisciplina(2));
		eu.matricular(UERJ.getDisciplina(3));
		
		eu.listarMatriculas();
		eu.ordenarMatriculas();
		eu.listarMatriculas();
		eu.desmatricular(UERJ.getDisciplina(2));
		eu.listarMatriculas();
		eu.matricular(UERJ.getDisciplina(2));
		eu.listarMatriculas();
		eu.ordenarMatriculas();
		eu.listarMatriculas();
		
		UERJ.getDisciplina(2).adicionarPresencas(eu, 20);
		UERJ.getDisciplina(2).cadastrarAvaliacao(eu, 6);
		UERJ.getDisciplina(2).cadastrarAvaliacao(eu, 6);
		UERJ.getDisciplina(2).cadastrarAvaliacao(eu, 5);
		UERJ.getDisciplina(2).cadastrarAvaliacao(eu, 6);
		UERJ.getDisciplina(2).encerrar(eu);
		
		eu.listarMatriculas();
		eu.ordenarMatriculas();
		eu.listarMatriculas();
		
		eu.desmatricular(3);
		eu.desmatricular(1);
		eu.listarMatriculas();
	}
}
