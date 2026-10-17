package modelo;

public class Prontuario {
  private String tipoSanguineo;
  private String alergias = "Nenhuma registrada";

  public Prontuario(String tipoSanguineo){
    this.tipoSanguineo = tipoSanguineo;
  }

  public void adicionarAlergia(String alergia){
    this.alergia += ", " + alergia;
  }
}
