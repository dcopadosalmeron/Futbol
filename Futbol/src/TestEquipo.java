import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class TestEquipo {

	public static void main(String[] args) {
        Scanner scanner;
		try {
			scanner = new Scanner(new File("C:/Users/mañana/Desktop/futbol.txt"),"UTF-8");
			scanner.useDelimiter("\t");
		        while(scanner.hasNext()){
		            System.out.print(scanner.next().trim()+"|");
		        }
		        scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
    }

}
