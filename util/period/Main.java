import java.time.LocalDate;
import java.time.Period;
public class Main {
  public static void main(String args []){
    LocalDate hoy = LocalDate.now();
    LocalDate fechaNacimiento = LocalDate.of(1994, 8, 28);
    Period p = Period.between(fechaNacimiento, hoy);
    int edad = p.getYears();

    System.out.println(hoy);
    System.out.println(fechaNacimiento);
    System.out.println(edad);
  }
}
