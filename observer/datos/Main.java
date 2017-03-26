public class Main {
  public static void main(String args []){
    //creas un sujeto
    ConjuntoDatos s1 = new ConjuntoDatos();
    //crear un(os) observador(es) y lo suscribes a ese sujeto
    Observador o1 = new Imprimir(s1);
    Observador o2 = new Promediar(s1);
    Observador o3 = new Graficar(s1);
    //agregas datos, y el observer debe imprimirlos
    s1.agregar(10);
    s1.agregar(2);
    // s1.removerObs(o2);
    s1.agregar(40);
    // s1.agregar(4);
    // s1.agregar(5);
    // s1.agregar(6);
  }
}
