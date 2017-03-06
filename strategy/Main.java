public class Main {

  public static void sumaPunto (){
    DatoMateComp punto1 = new Punto(1.0, 2.0);
    DatoMateComp punto2 = new Punto(2.0, 3.0);
    punto1.mostrar();
    punto2.mostrar();
    punto1.ejeSumar(punto2);
    punto1.mostrar();
    System.out.println(punto1.equals(punto2));
  }

  public static void sumaFraccion(){
    DatoMateComp d1 = new Fraccion(3, 2);
    DatoMateComp d2 = new Fraccion(1, 5);
    d1.mostrar();
    d2.mostrar();
    d1.ejeSumar(d2);
    d1.mostrar();
    System.out.println(d1.equals(d2));
  }

  public static void  dimensiones(){
    DatoMateComp d1 = new DimensionLineal(10, 30);
    DatoMateComp d2 = new DimensionLineal(10, 30);
    d1.mostrar();
    d2.mostrar();
    System.out.println("iguales? " + d1.equals(d2));
  }

  public static void  areas(){
    DatoMateComp d1 = new DimensionArea(10, 30);
    DatoMateComp d2 = new DimensionArea(5, 30);
    d1.mostrar();
    d2.mostrar();
    System.out.println("iguales? " + d1.equals(d2));
  }

  public static void tiempos(){
    DatoMateComp d1 = new Tiempo(10, 30);
    DatoMateComp d2 = new Tiempo(5, 30);
    d1.mostrar();
    d2.mostrar();
    System.out.println("iguales? " + d1.equals(d2));
  }

  public static void main(String [] args){
    // sumaPunto();
    // sumaFraccion();
    dimensiones();
    areas();
    tiempos();
  }

}
