public class Main {

  public static void sumaPunto (){
    DatoMateComp punto1 = new Punto(1.0, 2.0);
    DatoMateComp punto2 = new Punto(2.0, 3.0);
    punto1.mostrar();
    punto2.mostrar();
    punto1.ejeSumar(punto2);
    punto1.mostrar();
  }

  public static void sumaFraccion(){
    DatoMateComp d1 = new Fraccion(3, 2);
    DatoMateComp d2 = new Fraccion(1, 5);
    d1.mostrar();
    d2.mostrar();
    d1.ejeSumar(d2);
    d1.mostrar();
  }

  public static void main(String [] args){
    sumaPunto();
    sumaFraccion();
  }

}
