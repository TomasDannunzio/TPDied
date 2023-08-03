package Interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import App.FramePrincipal;
import Gestores.GestorRuta;
import Gestores.GestorSucursal;
import POJO.Sucursal;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class CrearRuta extends JFrame {

	private JPanel contentPane;
	private JTextField tiempoText;
	private JTextField capacidadText;
	private JTextField idText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearRuta frame = new CrearRuta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CrearRuta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{54, 578, 51, 0};
		gbl_contentPane.rowHeights = new int[]{70, 262, 45, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Nueva ruta");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{40, 206, 40, 242, 40, 0};
		gbl_panel.rowHeights = new int[]{42, 44, 15, 43, 15, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		GestorSucursal gestorSucursal = GestorSucursal.getInstance();
		
		ArrayList<String> listaNombres = (ArrayList<String>) gestorSucursal.getAllSucursal().stream().map(s -> s.getNombre()).collect(Collectors.toList());
		
		listaNombres.add(0,"");
		
		JLabel id = new JLabel("ID:");
		id.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_id = new GridBagConstraints();
		gbc_id.anchor = GridBagConstraints.SOUTHWEST;
		gbc_id.insets = new Insets(0, 0, 5, 5);
		gbc_id.gridx = 1;
		gbc_id.gridy = 0;
		panel.add(id, gbc_id);
		
		JLabel lblNewLabel_1 = new JLabel("Sucursal Origen:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		idText = new JTextField();
		idText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		idText.setColumns(10);
		GridBagConstraints gbc_idText = new GridBagConstraints();
		gbc_idText.insets = new Insets(0, 0, 5, 5);
		gbc_idText.fill = GridBagConstraints.HORIZONTAL;
		gbc_idText.gridx = 1;
		gbc_idText.gridy = 1;
		panel.add(idText, gbc_idText);
		
		JComboBox origen = new JComboBox();
		origen.setModel(new DefaultComboBoxModel(listaNombres.toArray()));
		GridBagConstraints gbc_origen = new GridBagConstraints();
		gbc_origen.insets = new Insets(0, 0, 5, 5);
		gbc_origen.fill = GridBagConstraints.HORIZONTAL;
		gbc_origen.gridx = 3;
		gbc_origen.gridy = 1;
		panel.add(origen, gbc_origen);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tiempo de Transito:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_2.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2.gridx = 1;
		gbc_lblNewLabel_1_2.gridy = 2;
		panel.add(lblNewLabel_1_2, gbc_lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Sucursal Destino:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 3;
		gbc_lblNewLabel_1_1.gridy = 2;
		panel.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		tiempoText = new JTextField();
		tiempoText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tiempoText.setColumns(10);
		GridBagConstraints gbc_tiempoText = new GridBagConstraints();
		gbc_tiempoText.fill = GridBagConstraints.HORIZONTAL;
		gbc_tiempoText.insets = new Insets(0, 0, 5, 5);
		gbc_tiempoText.gridx = 1;
		gbc_tiempoText.gridy = 3;
		panel.add(tiempoText, gbc_tiempoText);
		
		JComboBox destino = new JComboBox();
		destino.setModel(new DefaultComboBoxModel(listaNombres.toArray()));
		GridBagConstraints gbc_destino = new GridBagConstraints();
		gbc_destino.insets = new Insets(0, 0, 5, 5);
		gbc_destino.fill = GridBagConstraints.HORIZONTAL;
		gbc_destino.gridx = 3;
		gbc_destino.gridy = 3;
		panel.add(destino, gbc_destino);
		
		JLabel lblNewLabel_1_3 = new JLabel("Capacidad:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1_3 = new GridBagConstraints();
		gbc_lblNewLabel_1_3.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_1_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_3.gridx = 1;
		gbc_lblNewLabel_1_3.gridy = 4;
		panel.add(lblNewLabel_1_3, gbc_lblNewLabel_1_3);
		
		JLabel lblNewLabel_2 = new JLabel("Está operativa?");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 3;
		gbc_lblNewLabel_2.gridy = 4;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		capacidadText = new JTextField();
		capacidadText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		capacidadText.setColumns(10);
		GridBagConstraints gbc_capacidadText = new GridBagConstraints();
		gbc_capacidadText.insets = new Insets(0, 0, 5, 5);
		gbc_capacidadText.fill = GridBagConstraints.HORIZONTAL;
		gbc_capacidadText.gridx = 1;
		gbc_capacidadText.gridy = 5;
		panel.add(capacidadText, gbc_capacidadText);
		
		JComboBox operativaSeleccionada = new JComboBox();
		operativaSeleccionada.setModel(new DefaultComboBoxModel(new String[] {"No", "Si"}));
		operativaSeleccionada.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_operativaSeleccionada = new GridBagConstraints();
		gbc_operativaSeleccionada.insets = new Insets(0, 0, 5, 5);
		gbc_operativaSeleccionada.fill = GridBagConstraints.HORIZONTAL;
		gbc_operativaSeleccionada.gridx = 3;
		gbc_operativaSeleccionada.gridy = 5;
		panel.add(operativaSeleccionada, gbc_operativaSeleccionada);
		
		JButton btnNewButton = new JButton("Crear");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 6;
		panel.add(btnNewButton, gbc_btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				if(origen.getSelectedItem()==null || destino.getSelectedItem()==null || 
						tiempoText.getText().equals("") || capacidadText.getText().equals("")) throw new Exception();
				} catch(Exception e1) {
					System.out.println("Debe completar todos los campos");
					
				}
				
				String idString = idText.getText();
				String origenString = origen.getSelectedItem().toString();
				String destinoString = destino.getSelectedItem().toString();
				
				String capacidad = capacidadText.getText();
				LocalTime tiempoTransito = LocalTime.parse(tiempoText.getText());
				
				boolean operativa = false;
				
				if(operativaSeleccionada.getSelectedItem().equals("Si")) operativa=true; else operativa=false;
				
				try {
					
					GestorRuta.getInstance().createRuta(Integer.parseInt(idString), origenString, destinoString, tiempoTransito,Float.parseFloat(capacidad),operativa);
					
					CrearRuta.this.setVisible(false);
					
					FrameCamino principal = new FrameCamino();
					
					principal.setVisible(true);
					
					CrearRuta.this.dispose();
					
				} catch(Exception er) {
					System.out.println("El ID ingresado ya ha sido utilizado.");
				}
				
				
			}
		});
		
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 2;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CrearRuta.this.setVisible(false);
				
				FrameCamino principal = new FrameCamino();
				
				try {
					principal.setVisible(true);
				} catch(Exception er) {
					er.printStackTrace();
				}
				
				CrearRuta.this.dispose();
				
			}
		});
		
		
	}

}
