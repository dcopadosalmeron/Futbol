import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.FlowLayout;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import java.awt.Toolkit;

public class Ventana {

	private JFrame frmFutbol;
	private ArrayList<Equipo> listaEquipos;
	private JTableModel modelo;
	private JTable table;
	private File ruta;
	private Principal pr1 = new Principal();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
					window.frmFutbol.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFutbol = new JFrame();
		frmFutbol.setIconImage(Toolkit.getDefaultToolkit().getImage(
				Ventana.class.getResource("/icono/balon.png")));
		frmFutbol.setTitle("Futbol");
		frmFutbol.setResizable(false);
		frmFutbol.setBounds(100, 100, 506, 265);
		frmFutbol.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFutbol.getContentPane().setLayout(new BorderLayout(0, 0));
		frmFutbol.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		frmFutbol.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnAnterior = new JButton("Anterior");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modelo.anterior();
			}
		});
		panel.add(btnAnterior);

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_1);

		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modelo.siguiente();
			}
		});
		panel.add(btnSiguiente);

		Component horizontalStrut = Box.createHorizontalStrut(80);
		panel.add(horizontalStrut);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardar();
			}
		});
		panel.add(btnGuardar);

		JPanel panel_1 = new JPanel();
		frmFutbol.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));

		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);

		JMenuBar menuBar = new JMenuBar();
		frmFutbol.setJMenuBar(menuBar);

		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);

		JMenuItem mntmCargarArchivo = new JMenuItem("Cargar");
		mntmCargarArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						"TEXT FILES", "txt", "text");
				chooser.setFileFilter(filter);
				int returnVal = chooser.showOpenDialog(frmFutbol);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File in = chooser.getSelectedFile();
					ruta = in;
					pr1.cargarDatos(ruta);
					listaEquipos = pr1.getListaEquipos();
					modelo = new JTableModel(listaEquipos);
					table = new JTable(modelo);
					scrollPane.setViewportView(table);
				}
			}
		});
		mnArchivo.add(mntmCargarArchivo);

		JMenuItem mntmGuardarArchivo = new JMenuItem("Guardar");
		mntmGuardarArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		mnArchivo.add(mntmGuardarArchivo);

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnArchivo.add(mntmSalir);

		JMenu mnAcercaDe = new JMenu("Acerca de...");
		menuBar.add(mnAcercaDe);

		JMenuItem mntmAutor = new JMenuItem("Autor");
		mntmAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Creado por Daniel Copado Salmerón\n"
								+ "1ºDAM IES Virgen del Carmen", "Autor",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnAcercaDe.add(mntmAutor);
	}

	// metodo que guarda los datos en un fichero con la fecha y hora actual
	private void guardar() {
		try {
			String sinExtension = ruta.getAbsolutePath().replaceFirst(
					"[.][^.]+$", "");
			String fecha = (LocalDate.now().format(
					DateTimeFormatter.ofPattern("dd-MM-yyyy"))
					+ " " + LocalTime.now().format(
					DateTimeFormatter.ofPattern("HH'h'mm'm'ss's'")));
			String rutaFinal = sinExtension + " " + fecha + ".txt";
			File temporal = new File(rutaFinal);
			pr1.guardarDatos(temporal, modelo.getEquipos());
		} catch (Exception x) {
			JOptionPane.showMessageDialog(null,
					"No se ha guardado ningún dato.", "Error",
					JOptionPane.WARNING_MESSAGE);
		}
	}
}
