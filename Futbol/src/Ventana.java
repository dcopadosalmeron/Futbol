import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.BorderLayout;

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
import javax.swing.JTable;
import javax.swing.BoxLayout;


public class Ventana {

	private JFrame frmFutbol;
	private JTable table;

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
		frmFutbol.setTitle("Futbol");
		frmFutbol.setResizable(false);
		frmFutbol.setBounds(100, 100, 587, 321);
		frmFutbol.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFutbol.getContentPane().setLayout(new BorderLayout(0, 0));
		frmFutbol.setLocationRelativeTo(null);
		Principal pr1 = new Principal();
		
		JPanel panel = new JPanel();
		frmFutbol.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnAnterior = new JButton("Anterior");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			pr1.anterior();
			}
		});
		panel.add(btnAnterior);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_1);
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pr1.siguiente();
			}
		});
		panel.add(btnSiguiente);
		
		Component horizontalStrut = Box.createHorizontalStrut(80);
		panel.add(horizontalStrut);
		
		JButton btnGuardar = new JButton("Guardar");
		panel.add(btnGuardar);
		
		JPanel panel_1 = new JPanel();
		frmFutbol.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		Component verticalGlue = Box.createVerticalGlue();
		panel_1.add(verticalGlue);
		
		table = new JTable(12,8);


		panel_1.add(table);
		
		Component verticalGlue_1 = Box.createVerticalGlue();
		panel_1.add(verticalGlue_1);
		
		JMenuBar menuBar = new JMenuBar();
		frmFutbol.setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmCargarArchivo = new JMenuItem("Cargar archivo");
		mntmCargarArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
			    FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
			    chooser.setFileFilter(filter);
			    int returnVal = chooser.showOpenDialog(frmFutbol);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			    	File in = chooser.getSelectedFile();
			    	pr1.cargarDatos(in);
			    	pr1.siguiente();
			    }
			}
		});
		mnArchivo.add(mntmCargarArchivo);
		
		JMenuItem mntmGuardarArchivo = new JMenuItem("Guardar archivo");
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
				JOptionPane.showMessageDialog (null, "Creado por Daniel Copado Salmerón\n"
						+"1ºDAM IES Virgen del Carmen", "Autor", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnAcercaDe.add(mntmAutor);
	}

}
