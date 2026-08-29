
import java.util.Scanner;

public class Greetings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = sc.nextLine();
        System.out.println("Hell, "+name + " Welcome to the program");
        sc.close();
  }
}