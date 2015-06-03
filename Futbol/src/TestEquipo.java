import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class TestEquipo {

	public static void imprimir(File in) {
       Scanner scanner;
       String lineaLeida;
       ArrayList<Equipo> listaEquipos = new ArrayList<Equipo>();
		try {
			
			scanner = new Scanner(in,"UTF-8");
			scanner.nextLine();
		        while(scanner.hasNext()){
		        
		           lineaLeida=scanner.nextLine().trim();
		           
		           String[] campos=lineaLeida.split("\t");
		           listaEquipos.add(new Equipo(campos[0].trim(), Integer.parseInt(campos[1].trim()),
		        	Integer.parseInt(campos[2].trim()), Integer.parseInt(campos[3].trim()),
		        	Integer.parseInt(campos[4].trim()), Integer.parseInt(campos[5].trim()),
		        	Integer.parseInt(campos[6].trim()), Integer.parseInt(campos[7].trim())));
		        }
		        System.out.println(listaEquipos.get(0).getNombre());
		        scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
    }

}
