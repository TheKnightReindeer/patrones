public class SingletonClasico {

  private static SingletonClasico instancia;
  private static int numIns = 0;

  //static {
  //instancia = new SingletonClasico();
  //}

  protected SingletonClasico(){
    //Existe sólo para evitar que se cree con new fuera de aquí
    numIns++;
  }
  
  public static SingletonClasico getInstancia(){
    if(instancia == null){
      instancia = new SingletonClasico();
    }
    // System.out.println("\n Se creó una instancia");
    return instancia;
  }

  public int numInstancia(){
    return numIns;
  }

}
