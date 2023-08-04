package Interfaces;

import java.awt.EventQueue;
import java.time.LocalTime;
import java.time.LocalDate;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import App.FramePrincipal;
import Gestores.ConexionBDD;
import Gestores.GestorProducto;
import Gestores.GestorSucursal;
import POJO.Sucursal;
import POJO.Producto;


import java.awt.Color;
import javax.swing.ListSelectionModel;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalTime;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JComboBox;

public class CrearOrden extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table2;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JButton btnNewButton_2;
	private JButton btnNewButton_4;
	private JComboBox comboBox;
	private JButton btnNewButton;
	private JButton btnNewButton_3;
	private JScrollPane scrollPane_1;
	private JLabel lblNewLabel_4;

	
	public CrearOrden(int id, String nombre) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{50, 0, 100, 100, 100, 15, 150, 81, 77, 77, 75, 50, 0};
		gbl_contentPane.rowHeights = new int[]{50, 50, 50, 50, 25, 25, 0, 50, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		lblNewLabel_5 = new JLabel("Orden de Provisión");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 0;
		contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 3;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Fecha\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 6;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_1 = new JTextField("yyyy-mm-dd");
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 4;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 7;
		gbc_textField_1.gridy = 1;
		contentPane.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Sucursal");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 2;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);

		GestorSucursal gestorSucursal = GestorSucursal.getInstance();
		ArrayList<String> listaNombres = (ArrayList<String>) gestorSucursal.getAllSucursal().stream().map(s -> s.getNombre()).collect(Collectors.toList());
	
		listaNombres.add(0, "");
		listaNombres.remove(nombre);
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(listaNombres.toArray()));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 3;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 2;
		contentPane.add(comboBox, gbc_comboBox);

		
		lblNewLabel_3 = new JLabel("Tiempo máximo\r\n");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 6;
		gbc_lblNewLabel_3.gridy = 2;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.gridwidth = 4;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 7;
		gbc_textField_3.gridy = 2;
		contentPane.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		
		lblNewLabel_6 = new JLabel("Lista de Productos\r\n");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 5;
		contentPane.add(lblNewLabel_6, gbc_lblNewLabel_6);

		
		
		
		lblNewLabel_4 = new JLabel("Productos en orden");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_4.gridwidth = 2;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 6;
		gbc_lblNewLabel_4.gridy = 5;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		btnNewButton_2 = new JButton("Eliminar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestorSucursal gestor =GestorSucursal.getInstance();
				gestor.deleteProductFromOrder((int)table.getModel().getValueAt(table.getSelectedRow(),0), Integer.parseInt(textField.getText()));
				CrearOrden.this.actualizarTabla();
				CrearOrden.this.repaint();
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.gridwidth = 2;
		gbc_btnNewButton_2.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 9;
		gbc_btnNewButton_2.gridy = 5;
		contentPane.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 6;
		contentPane.add(scrollPane, gbc_scrollPane); //copiar acá
		
		btnNewButton_1 = new JButton("Crear");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
			
		});
		
		scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridwidth = 5;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 6;
		gbc_scrollPane_1.gridy = 6;
		contentPane.add(scrollPane_1, gbc_scrollPane_1);
		
		btnNewButton = new JButton("Volver");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 7;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CrearOrden.this.setVisible(false);
				
				FrameStock gestionarStock = new FrameStock( id , nombre);
 
				try {
					gestionarStock.setVisible(true);
				} catch(Exception er) {
					er.printStackTrace();
				}
				
				CrearOrden.this.dispose();
				
			}
		});
		
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridwidth = 2;
		gbc_btnNewButton_1.gridx = 10;
		gbc_btnNewButton_1.gridy = 7;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		
		
		btnNewButton_3 = new JButton("Confirmar");
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton_3.gridwidth = 2;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 9;
		gbc_btnNewButton_3.gridy = 3;
		contentPane.add(btnNewButton_3, gbc_btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestorSucursal gestor = GestorSucursal.getInstance();
				

				int idSucursalPedir = Integer.parseInt(textField.getText());
				gestor.createOrden(idSucursalPedir, LocalDate.parse(textField_1.getText()), comboBox.getSelectedItem().toString(), LocalTime.parse(textField_3.getText()));
				try {
					
					String[] columnNames = { "ID", "Producto", "Precio", "Cantidad"};
					
					HashMap<Producto, Integer> listaProductos = new HashMap<Producto, Integer>();
					
					try {
						listaProductos = GestorSucursal.getInstance().getStock(id);
					} catch (Exception e1) {
					
						e1.printStackTrace();
					}

					DefaultTableModel model = new DefaultTableModel(null, columnNames);
					cargarModelo(model,listaProductos);
					table = new JTable(model);
					table.setBackground(new Color(255, 255, 255));
					table.setForeground(new Color(0, 0, 0));
					table.setFont(new Font("Tahoma", Font.PLAIN, 15));
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					table.setBorder(new LineBorder(new Color(0, 0, 0), 0));
					table.setToolTipText("");
					scrollPane.setViewportView(table);
					
					GestorSucursal.getInstance().getStock(idSucursalPedir);
					
				} catch(Exception er) {
					System.out.println("El ID ingresado ya ha sido utilizado.");
				}
			
			}});
		btnNewButton_4 = new JButton("Agregar");
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 4;
		gbc_btnNewButton_4.gridy = 5;
		contentPane.add(btnNewButton_4, gbc_btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AgregarProductoOrden agregarProducto= new AgregarProductoOrden(CrearOrden.this, (int)table.getModel().getValueAt(table.getSelectedRow(),0), Integer.parseInt(textField.getText()));
				agregarProducto.setVisible(true);
				
				
			
			//	CrearOrden.this.dispose();
				
			}
		});
		
	}
	
	
	
	
	private void cargarModelo(DefaultTableModel model, HashMap<Producto, Integer> listaProductos){
		for (HashMap.Entry<Producto, Integer> entry : listaProductos.entrySet()) {
			Object[] aux = {entry.getKey().getId(), entry.getKey().getNombre(), entry.getKey().getPrecio(), entry.getValue()};
			model.addRow(aux);
		}
		
	}
	
	public void actualizarTabla(){
		String[] columnNames = { "ID", "Producto", "Precio", "Cantidad"};
		
		HashMap<Producto, Integer> listaProductos = new HashMap<Producto, Integer>();
		
		try {
			listaProductos = GestorSucursal.getInstance().getProductosOrden(Integer.parseInt(textField.getText()));
		} catch (Exception e1) {
		
			e1.printStackTrace();
		}

		DefaultTableModel model = new DefaultTableModel(null, columnNames);
		cargarModelo(model,listaProductos);
		table2 = new JTable(model);
		table2.setBackground(new Color(255, 255, 255));
		table2.setForeground(new Color(0, 0, 0));
		table2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table2.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		table2.setToolTipText("");
		scrollPane_1.setViewportView(table2);
	}
	
}
	
