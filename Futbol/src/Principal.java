import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
	//variables y constantes utilizadas por los metodos
	private int longitud;
	private int inicio = 0;
	private ArrayList<Equipo> listaEquipos = new ArrayList<Equipo>();
	private int numeroPaginas = 0;
	private final int numerodefilas=7;
	
	
	//metodo cargar datos 
	public void cargarDatos(File in) {
		Scanner scanner;
		String lineaLeida;

		try {

			scanner = new Scanner(in, "UTF-8");
			scanner.nextLine();
			while (scanner.hasNext()) {

				lineaLeida = scanner.nextLine().trim();

				String[] campos = lineaLeida.split("\t");
				listaEquipos.add(new Equipo(campos[0].trim(), Integer
						.parseInt(campos[1].trim()), Integer.parseInt(campos[2]
						.trim()), Integer.parseInt(campos[3].trim()), Integer
						.parseInt(campos[4].trim()), Integer.parseInt(campos[5]
						.trim()), Integer.parseInt(campos[6].trim()), Integer
						.parseInt(campos[7].trim())));
			}

			this.longitud = listaEquipos.size();
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	// metodo para recorrer la coleccion de objetos
	public void siguiente() {
		if (this.longitud >= numerodefilas) {
			for (int i = this.inicio; i < (this.inicio + numerodefilas); i++) {
				System.out.println(listaEquipos.get(i).toString());
			}
			this.inicio += numerodefilas;
			this.longitud -= numerodefilas;
			this.numeroPaginas++;
			
		} else if (this.longitud < numerodefilas && this.longitud > 0) {
			for (int i = this.inicio; i < (listaEquipos.size()); i++) {
				System.out.println(listaEquipos.get(i).toString());
			}
			this.longitud = 0;
			this.numeroPaginas++;
			
		}
	}
	
	public void anterior() {
		
	}

}
