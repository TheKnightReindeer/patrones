import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class Main {
  public static void main(String args []){
    LocalDate hoy = LocalDate.now();
    LocalDate fechaNacimiento = LocalDate.of(1994, 8, 28);
    Period p = Period.between(fechaNacimiento, hoy);
    int edad = p.getYears();

    Date d = new Date();
    // System.out.println(hoy);
    // System.out.println(fechaNacimiento);
    // System.out.println(edad);
    System.out.println(d.getYear()+1900 + " " + d.getMonth() + " " + d.getDate());
    LocalDate prueba = LocalDate.of(d.getYear()+1900, d.getMonth()+1, d.getDate());
    System.out.println(prueba);

  }
}
