package modelo;

import java.util.HashSet;

public class PostoSaude {
	private HashSet<Medico> medicos = new HashSet<>();
	private HashSet<Paciente> pacientes = new HashSet<>();

	public boolean cadastrarMedico();

	public boolean cadastrarPaciente(
