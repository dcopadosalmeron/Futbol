import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class JTableModel extends AbstractTableModel {
	private int numeroFilas = 9;
	private int indice = 0;
	private ArrayList<Equipo> equipos;
	public static String[] nombreColumnas = { "Equipo", "P.J.", "P.G.", "P.E.",
			"P.P.", "G.F.", "G.C.", "Ptos" };

	public ArrayList<Equipo> getEquipos() {
		return equipos;
	}

	public JTableModel(ArrayList<Equipo> lista) {
		this.equipos = lista;
	}

	@Override
	public int getRowCount() {
		int resto = equipos.size() - indice;
		if (resto > numeroFilas) {
			return numeroFilas;
		} else {
			return resto;
		}
	}

	public void siguiente() {
		if (indice + numeroFilas < equipos.size()) {
			indice += numeroFilas;
			fireTableChanged(null);
		}
	}

	public void anterior() {
		if (indice - numeroFilas >= 0) {
			indice -= numeroFilas;
			fireTableChanged(null);
		}
	}

	@Override
	public int getColumnCount() {
		return 8;
	}

	public String getColumnName(int col) {
		return nombreColumnas[col];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Equipo e = equipos.get(rowIndex + indice);
		if (columnIndex == 0)
			return e.getNombre();
		else if (columnIndex == 1)
			return e.getPJ();
		else if (columnIndex == 2)
			return e.getPG();
		else if (columnIndex == 3)
			return e.getPE();
		else if (columnIndex == 4)
			return e.getPP();
		else if (columnIndex == 5)
			return e.getGF();
		else if (columnIndex == 6)
			return e.getGC();
		else if (columnIndex == 7)
			return e.getPuntos();
		else
			return "";
	}

	@Override
	public void setValueAt(Object equipo, int rowIndex, int columnIndex) {
		Equipo e = equipos.get(rowIndex + indice);
		String celda = (String) equipo;
		if (columnIndex == 0)
			e.setNombre(celda);
		else if (columnIndex == 1) {
			try {
				e.setPJ(Integer.parseInt(celda));
			} catch (Exception x) {
			}
		} else if (columnIndex == 2) {
			try {
				e.setPG(Integer.parseInt(celda));
			} catch (Exception x) {
			}
		} else if (columnIndex == 3) {
			try {
				e.setPE(Integer.parseInt(celda));
			} catch (Exception x) {
			}
		} else if (columnIndex == 4) {
			try {
				e.setPP(Integer.parseInt(celda));
			} catch (Exception x) {
			}
		} else if (columnIndex == 5) {
			try {
				e.setGF(Integer.parseInt(celda));
			} catch (Exception x) {
			}
		} else if (columnIndex == 6) {
			try {
				e.setGC(Integer.parseInt(celda));
			} catch (Exception x) {
			}
		} else if (columnIndex == 7) {
			try {
				e.setPuntos(Integer.parseInt(celda));
			} catch (Exception x) {
			}
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

}
