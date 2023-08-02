package Interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import App.FramePrincipal;
import Gestores.GestorRuta;
import Gestores.GestorSucursal;
import POJO.Ruta;
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

public class EditarRuta extends JFrame {

	private JPanel contentPane;
	private JTextField tiempoTransitoText;
	private JTextField capacidadText;

	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarSucursal frame = new EditarSucursal();
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
	public EditarRuta(Ruta r) {
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
		
		JLabel lblNewLabel = new JLabel("Nueva sucursal");
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
		
		JLabel lblNewLabel_1 = new JLabel("Sucursal Origen:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Sucursal Destino:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 3;
		gbc_lblNewLabel_1_1.gridy = 0;
		panel.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		GestorSucursal gestorSucursal = GestorSucursal.getInstance();
		
		ArrayList<String> listaNombres = (ArrayList<String>) gestorSucursal.getAllSucursal().stream().map(s -> s.getNombre()).collect(Collectors.toList());
		
		listaNombres.add("");
		
		JComboBox origen = new JComboBox();
		origen.setModel(new DefaultComboBoxModel(listaNombres.toArray()));
		origen.setSelectedItem(r.getOrigen().getNombre());
		GridBagConstraints gbc_origen = new GridBagConstraints();
		gbc_origen.insets = new Insets(0, 0, 5, 5);
		gbc_origen.fill = GridBagConstraints.HORIZONTAL;
		gbc_origen.gridx = 1;
		gbc_origen.gridy = 1;
		panel.add(origen, gbc_origen);
		
		JComboBox destino = new JComboBox();
		destino.setModel(new DefaultComboBoxModel(listaNombres.toArray()));
		destino.setSelectedItem(r.getDestino().getNombre());
		GridBagConstraints gbc_destino = new GridBagConstraints();
		gbc_destino.insets = new Insets(0, 0, 5, 5);
		gbc_destino.fill = GridBagConstraints.HORIZONTAL;
		gbc_destino.gridx = 3;
		gbc_destino.gridy = 1;
		panel.add(destino, gbc_destino);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tiempo de tránsito:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_2.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2.gridx = 1;
		gbc_lblNewLabel_1_2.gridy = 2;
		panel.add(lblNewLabel_1_2, gbc_lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Capacidad:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1_3 = new GridBagConstraints();
		gbc_lblNewLabel_1_3.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_1_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_3.gridx = 3;
		gbc_lblNewLabel_1_3.gridy = 2;
		panel.add(lblNewLabel_1_3, gbc_lblNewLabel_1_3);
		
		tiempoTransitoText = new JTextField();
		tiempoTransitoText.setText(r.getTiempoTransito().toString());
		GridBagConstraints gbc_tiempoTransitoText = new GridBagConstraints();
		gbc_tiempoTransitoText.insets = new Insets(0, 0, 5, 5);
		gbc_tiempoTransitoText.fill = GridBagConstraints.HORIZONTAL;
		gbc_tiempoTransitoText.gridx = 1;
		gbc_tiempoTransitoText.gridy = 3;
		panel.add(tiempoTransitoText, gbc_tiempoTransitoText);
		tiempoTransitoText.setColumns(10);
		
		capacidadText = new JTextField();
		capacidadText.setText(String.valueOf(r.getCapacidad()));
		GridBagConstraints gbc_capacidadText = new GridBagConstraints();
		gbc_capacidadText.insets = new Insets(0, 0, 5, 5);
		gbc_capacidadText.fill = GridBagConstraints.HORIZONTAL;
		gbc_capacidadText.gridx = 3;
		gbc_capacidadText.gridy = 3;
		panel.add(capacidadText, gbc_capacidadText);
		capacidadText.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Está operativa?");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 4;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JComboBox operativaCombo = new JComboBox();
		operativaCombo.setModel(new DefaultComboBoxModel(new String[] {"No", "Si"}));
		operativaCombo.setSelectedItem(r.esOperativa());
		operativaCombo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_operativaCombo = new GridBagConstraints();
		gbc_operativaCombo.insets = new Insets(0, 0, 5, 5);
		gbc_operativaCombo.fill = GridBagConstraints.HORIZONTAL;
		gbc_operativaCombo.gridx = 1;
		gbc_operativaCombo.gridy = 5;
		panel.add(operativaCombo, gbc_operativaCombo);
		
		JButton btnNewButton = new JButton("Editar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 6;
		panel.add(btnNewButton, gbc_btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sucursalOrigen= origen.getSelectedItem().toString();
				String sucursalDestino = destino.getSelectedItem().toString();
				String tiempoTransito = tiempoTransitoText.getText();
				String capacidad = capacidadText.getText();
				String operativaSeleccionada = operativaCombo.getSelectedItem().toString();
				
				boolean operativa = false;
				
				if(operativaSeleccionada.equals("Si")) operativa=true; else operativa=false;
				
				try {
				GestorRuta.getInstance().updateRuta(r.getId(),sucursalOrigen,sucursalDestino,
						LocalTime.parse(tiempoTransito),Float.valueOf(capacidad),operativa);
				
				EditarRuta.this.setVisible(false);
				
				FrameCamino gestionRuta = new FrameCamino();	
				
				gestionRuta.setVisible(true);
				
				EditarRuta.this.dispose();
				
				} catch(Exception err) {
					err.printStackTrace();
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
				
				EditarRuta.this.setVisible(false);
				
				FrameCamino camino = new FrameCamino();
				
				try {
					camino.setVisible(true);
				} catch(Exception er) {
					er.printStackTrace();
				}
				
				EditarRuta.this.dispose();
				
			}
		});
		
		
	}

}
