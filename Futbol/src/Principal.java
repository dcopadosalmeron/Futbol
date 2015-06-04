import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
	// variables utilizadas por los metodos
	private ArrayList<Equipo> listaEquipos = new ArrayList<Equipo>();
	private String cabecera=JTableModel.nombreColumnas[0]+"\t"+JTableModel.nombreColumnas[1]
			+"\t"+JTableModel.nombreColumnas[2]+"\t"+JTableModel.nombreColumnas[3]+"\t"
			+JTableModel.nombreColumnas[4]+"\t"+JTableModel.nombreColumnas[5]+"\t"
			+JTableModel.nombreColumnas[6]+"\t"+JTableModel.nombreColumnas[7];

	// metodo cargar datos
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

			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void guardarDatos(File f,ArrayList<Equipo> lista) {
		try (PrintWriter out = new PrintWriter(f)) {
			out.println(cabecera);
			for (Equipo equipo : lista) {
				out.println(equipo);
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
	}

	public ArrayList<Equipo> getListaEquipos() {
		return listaEquipos;
	}

}
