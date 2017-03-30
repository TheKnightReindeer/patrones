import java.util.ArrayList;
public interface Sujeto {
  public void agregarObs(Observador o);
  public void removerObs(Observador o);
  public void notificar();
  public void notificarAliados();
  public void notificarEnemigos();
  public String getColor();
  public String getNombre();
  public ArrayList getDatos();
}
