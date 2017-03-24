import java.util.ArrayList;
public interface Sujeto {
  public void agregarObs(Observador o);
  public void removerObs(Observador o);
  public void notificar();
  public ArrayList getDatos();
}
