public class SumaFrac implements Sumar {

  @Override
  public DatoMateComp sumar (DatoMateComp d1, DatoMateComp d2){
    System.out.println(d1.valor1 * d2.valor2);
    System.out.println(d1.valor2 * d2.valor1);
    d1.valor1 = (d1.valor1 * d2.valor2) + (d1.valor2 * d2.valor1);
    d1.valor2 = d1.valor2 * d2.valor2;
    return d1;
  }

}
