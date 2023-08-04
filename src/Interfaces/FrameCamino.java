package Interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.util.ArrayList;
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
import Gestores.GestorRuta;
import Gestores.GestorSucursal;
import POJO.Ruta;
import POJO.Sucursal;

import java.awt.Color;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FrameCamino extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;
	private JTextField tiempoTransitoText;
	private JTextField capacidadText;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_4;
	private JCheckBox checkboxOperativa;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JComboBox origenCombo;
	private JComboBox destinoCombo;
	private JLabel lblNewLabel_7;
	private JTextField idText;
	private JButton btnNewButton_5;
	
	public FrameCamino() {
		setTitle("Gestionar caminos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{50, 0, 290, 15, 89, 145, 145, 50, 50, 0};
		gbl_contentPane.rowHeights = new int[]{50, 50, 50, 50, 25, 25, 0, 50, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		lblNewLabel_5 = new JLabel("Filtros");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 0;
		contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		GestorSucursal gestorSucursal = GestorSucursal.getInstance();
		
		ArrayList<String> listaNombres = (ArrayList<String>) gestorSucursal.getAllSucursal().stream().map(s -> s.getNombre()).collect(Collectors.toList());
		
		listaNombres.add(0, "");
		
		lblNewLabel_7 = new JLabel("ID:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 1;
		gbc_lblNewLabel_7.gridy = 1;
		contentPane.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		idText = new JTextField();
		idText.setColumns(10);
		GridBagConstraints gbc_idText = new GridBagConstraints();
		gbc_idText.insets = new Insets(0, 0, 5, 5);
		gbc_idText.fill = GridBagConstraints.HORIZONTAL;
		gbc_idText.gridx = 2;
		gbc_idText.gridy = 1;
		contentPane.add(idText, gbc_idText);
		
		lblNewLabel = new JLabel("Sucursal origen");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 4;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		origenCombo = new JComboBox();
		origenCombo.setModel(new DefaultComboBoxModel(listaNombres.toArray()));
		GridBagConstraints gbc_origenCombo = new GridBagConstraints();
		gbc_origenCombo.gridwidth = 2;
		gbc_origenCombo.insets = new Insets(0, 0, 5, 5);
		gbc_origenCombo.fill = GridBagConstraints.HORIZONTAL;
		gbc_origenCombo.gridx = 5;
		gbc_origenCombo.gridy = 1;
		contentPane.add(origenCombo, gbc_origenCombo);
		
		lblNewLabel_2 = new JLabel("Tiempo de tránsito");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 2;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		tiempoTransitoText = new JTextField();
		GridBagConstraints gbc_tiempoTransitoText = new GridBagConstraints();
		gbc_tiempoTransitoText.insets = new Insets(0, 0, 5, 5);
		gbc_tiempoTransitoText.fill = GridBagConstraints.HORIZONTAL;
		gbc_tiempoTransitoText.gridx = 2;
		gbc_tiempoTransitoText.gridy = 2;
		contentPane.add(tiempoTransitoText, gbc_tiempoTransitoText);
		tiempoTransitoText.setColumns(10);
		
		btnNewButton = new JButton("Buscar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = (idText.getText());
				
				String nombreOrigen = origenCombo.getSelectedItem().toString();
				
				String nombreDestino = destinoCombo.getSelectedItem().toString();
				
				String tiempoTransito = tiempoTransitoText.getText();
				
				String capacidad = capacidadText.getText();
				
				boolean operativa = checkboxOperativa.isSelected();
				
				ArrayList<Ruta> listaBusqueda = null;
				
				try {
					listaBusqueda = 
							GestorRuta.getInstance().getRuta(id, nombreOrigen, nombreDestino, tiempoTransito, capacidad, operativa);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//System.out.println(listaBusqueda);
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				
				model.setRowCount(0);
				
				cargarModelo(model,listaBusqueda);
				
			}
		});
		
		lblNewLabel_1 = new JLabel("Sucursal Destino");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 4;
		gbc_lblNewLabel_1.gridy = 2;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		destinoCombo = new JComboBox();
		destinoCombo.setModel(new DefaultComboBoxModel(listaNombres.toArray()));
		GridBagConstraints gbc_destinoCombo = new GridBagConstraints();
		gbc_destinoCombo.gridwidth = 2;
		gbc_destinoCombo.insets = new Insets(0, 0, 5, 5);
		gbc_destinoCombo.fill = GridBagConstraints.HORIZONTAL;
		gbc_destinoCombo.gridx = 5;
		gbc_destinoCombo.gridy = 2;
		contentPane.add(destinoCombo, gbc_destinoCombo);
		
		lblNewLabel_3 = new JLabel("Capacidad");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 3;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		capacidadText = new JTextField();
		GridBagConstraints gbc_capacidadText = new GridBagConstraints();
		gbc_capacidadText.gridwidth = 2;
		gbc_capacidadText.insets = new Insets(0, 0, 5, 5);
		gbc_capacidadText.fill = GridBagConstraints.HORIZONTAL;
		gbc_capacidadText.gridx = 2;
		gbc_capacidadText.gridy = 3;
		contentPane.add(capacidadText, gbc_capacidadText);
		capacidadText.setColumns(10);
		
		
		lblNewLabel_4 = new JLabel("Operativo");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 4;
		gbc_lblNewLabel_4.gridy = 3;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		checkboxOperativa = new JCheckBox("");
		GridBagConstraints gbc_checkboxOperativa = new GridBagConstraints();
		gbc_checkboxOperativa.anchor = GridBagConstraints.WEST;
		gbc_checkboxOperativa.insets = new Insets(0, 0, 5, 5);
		gbc_checkboxOperativa.gridx = 5;
		gbc_checkboxOperativa.gridy = 3;
		contentPane.add(checkboxOperativa, gbc_checkboxOperativa);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 6;
		gbc_btnNewButton.gridy = 3;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		lblNewLabel_6 = new JLabel("Rutas");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 5;
		contentPane.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		btnNewButton_4 = new JButton("Crear");
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 4;
		gbc_btnNewButton_4.gridy = 5;
		contentPane.add(btnNewButton_4, gbc_btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrameCamino.this.setVisible(false);
				
				CrearRuta crearSucursal= new CrearRuta();
				
				try {
					crearSucursal.setVisible(true);
				} catch(Exception er) {
					er.printStackTrace();
				}
				
				FrameCamino.this.dispose();
				
			}
		});
		
		
		btnNewButton_3 = new JButton("Editar");
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 5;
		gbc_btnNewButton_3.gridy = 5;
		contentPane.add(btnNewButton_3, gbc_btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(table.getSelectedRow() != -1) {
					
					GestorRuta gestorRuta = GestorRuta.getInstance();
					
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					
					EditarRuta editarRuta= new EditarRuta((int) model.getValueAt(table.getSelectedRow(), 0));
					
					FrameCamino.this.setVisible(false);
					
					try {
						editarRuta.setVisible(true);
					} catch(Exception er) {
						er.printStackTrace();
					}
					
					FrameCamino.this.dispose();
					
				}
				
			}
		});
		
		btnNewButton_2 = new JButton("Eliminar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				if(table.getSelectedRow() != -1) {
				
					int filaSeleccionada = table.getSelectedRow();
					
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					
					try {
						GestorRuta.getInstance().deleteRuta((int) model.getValueAt(filaSeleccionada, 0));
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					model.removeRow(filaSeleccionada);
					
					model.fireTableDataChanged();
					
				}
			
			}
			
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 6;
		gbc_btnNewButton_2.gridy = 5;
		contentPane.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 7;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 6;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		String[] columnNames = { "ID", "Sucursal origen", "Sucursal destino", "Tiempo de tránsito","Capacidad en kg", "Operativa"};
		
		ArrayList<Ruta> lista = new ArrayList<Ruta>();
		
		try {
			lista = GestorRuta.getInstance().getAllRuta();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		DefaultTableModel model = new DefaultTableModel(null, columnNames);
		
		cargarModelo(model,lista);
		
		table = new JTable(model);
		table.setBackground(new Color(255, 255, 255));
		table.setForeground(new Color(0, 0, 0));
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		table.setToolTipText("");
		scrollPane.setViewportView(table);
		
		btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrameCamino.this.setVisible(false);
				
				FramePrincipal principal = new FramePrincipal();
				
				try {
					principal.setVisible(true);
				} catch(Exception er) {
					er.printStackTrace();
				}
				
				FrameCamino.this.dispose();
				
			}
		});
		
		btnNewButton_5 = new JButton("PageRank");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FramePageRank pageRank= new FramePageRank();
				
				try {
					pageRank.setVisible(true);
				} catch(Exception er) {
					er.printStackTrace();
				}
				pageRank.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_5.gridx = 4;
		gbc_btnNewButton_5.gridy = 7;
		contentPane.add(btnNewButton_5, gbc_btnNewButton_5);
		
		
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridwidth = 2;
		gbc_btnNewButton_1.gridx = 7;
		gbc_btnNewButton_1.gridy = 7;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		


		TableCellRenderer rendererFromHeader = table.getTableHeader().getDefaultRenderer();
		JLabel headerLabel = (JLabel) rendererFromHeader;
		headerLabel.setHorizontalAlignment(JLabel.CENTER);
		
		
		
	}
	
	private void cargarModelo(DefaultTableModel model, ArrayList<Ruta> lista) {
		
		Ruta r = null;
		
		for(int i=0;i<lista.size();i++) {
			
			r = lista.get(i);
			
			Object[] aux = {r.getId(), r.getOrigen().getNombre(), r.getDestino().getNombre(), r.getTiempoTransito(), 
					r.getCapacidad(), r.esOperativa()};
			
			model.addRow(aux);
			
		}
		
	}

}
