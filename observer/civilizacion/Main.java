public class Main {
  public static void main(String args []){
    //crear un sujeto
    Civilizacion c1 = new Civilizacion("mayas", "rojo");
    Civilizacion c2 = new Civilizacion("aztecas", "rojo");
    Civilizacion c3 = new Civilizacion("españoles", "azul");
    Civilizacion c4 = new Civilizacion("japoneses", "azul");
    Civilizacion c5 = new Civilizacion("rusos", "verde");
    Civilizacion c6 = new Civilizacion("toltecas", "rojo");
    //crear observador
    Observador o1 = new Visitados(c1); //este observador sólo verá a Civilizacion c1
    Observador o2 = new Aliados(c1);
    Observador o3 = new Enemigos(c1);
    c1.explorar(c2); 
    c1.explorar(c3);
    // c1.explorar(c4);
    // c1.explorar(c5);
    // c1.explorar(c6);
    Observador o4 = new Visitados(c3); //este observador sólo verá a Civilizacion c1
    Observador o5 = new Aliados(c3);
    Observador o6 = new Enemigos(c3);
    c3.explorar(c1); 
    c3.explorar(c2);

  }
}
