import java.util.Observer;
public class Main {
  public static void main(String args []){
    //crear observable
    ConjuntoDatos s1 = new ConjuntoDatos();
    //crear observador
    Observer o1 = new Imprimir(s1);
    s1.addObserver(o1);
    s1.agregar(1);
  }
}
