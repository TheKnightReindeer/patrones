import java.time.LocalDate;
public class Main {
  public static void main(String args []){
    LocalDate actual = LocalDate.now();
    int numDia = actual.getDayOfWeek().getValue();
    int numDiaMes = actual.getDayOfMonth();
    int diasMes = actual.lengthOfMonth();

    System.out.println("L   M   M   J   V   S   D");
      int dow = 1; //day of week
    for(int i = numDiaMes; i <= diasMes; i++){
      if(numDia == dow){
        System.out.print(i + "  ");
        dow++;
        numDia++;
        if(dow == 8){
          dow = 1;
          numDia = 1;
          System.out.println();
        }
      }else{
        System.out.print("    ");
        dow++;
        i = numDiaMes-1;
      }
    }
  }
}
