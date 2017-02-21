public class Prueba {

  public static void main(String [] args){
    // de esta forma no se alcanza el constructor privado
    // SingletonClasico sc1 = new SingletonClasico();
    // como getInstancia es estático, no se le debe llamar desde un objeto
    // System.out.println(sc1.getInstancia());
    SingletonClasico os = SingletonClasico.getInstancia();
    System.out.println(os.numInstancia());
    SingletonClasico os1 = SingletonClasico.getInstancia();
    System.out.println(os1.numInstancia());
    // System.out.println(os == os1);
  }
  
}
