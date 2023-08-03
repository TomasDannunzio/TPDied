package Interfaces;
import java.util.HashMap;
import Gestores.GestorSucursal;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.util.ArrayList;
import java.util.function.Function;
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
import Gestores.GestorSucursal;
import POJO.Sucursal;
import POJO.Producto;
import Gestores.GestorProducto;

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
import javax.swing.SwingConstants;

public class FrameStock extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_6;
	private JButton btnNewButton;
	
	public FrameStock(int id, String nombreSucursal) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{50, 50, 290, 15, 89, 145, 145, 50, 50, 0};
		gbl_contentPane.rowHeights = new int[]{25, 50, 50, 50, 25, 25, 0, 50, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		String TextoPrincipal = new String("ID : "+ id +" - Sucursal: " + nombreSucursal);
		lblNewLabel_5 = new JLabel(TextoPrincipal);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.gridwidth = 2;
		gbc_lblNewLabel_5.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 3;
		gbc_lblNewLabel_5.gridy = 1;
		contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		btnNewButton_6 = new JButton("Generar orden de provisión\r\n");
		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
		gbc_btnNewButton_6.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_6.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_6.gridx = 2;
		gbc_btnNewButton_6.gridy = 2;
		contentPane.add(btnNewButton_6, gbc_btnNewButton_6);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CrearOrden crearOrden = new CrearOrden(id,nombreSucursal);

				FrameStock.this.setVisible(false);
				
				try {
					crearOrden.setVisible(true);
				} catch(Exception e2) {
					e2.printStackTrace();
				}
				
				FrameStock.this.dispose();
			}
		});

		btnNewButton = new JButton("Ver ordenes pendientes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 2;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		lblNewLabel_6 = new JLabel("Stock");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 5;
		contentPane.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		
		btnNewButton_3 = new JButton("Editar");
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 5;
		gbc_btnNewButton_3.gridy = 5;
		contentPane.add(btnNewButton_3, gbc_btnNewButton_3);
		/* ESTE EDITARLF ES PARA CUANDO ESTÉ LO DE PRODUCTOLF ANCHI
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(table.getSelectedRow() != -1) {
				
					FrameStock.this.setVisible(false);
					
					CrearOrden crearOrden= new CrearOrden((int) table.getModel().getValueAt(table.getSelectedRow(),0));
					
					try {
						crearOrden.setVisible(true);
					} catch(Exception er) {
						er.printStackTrace();
					}
					
					FrameStock.this.dispose();
					
				}
				
			}
		});
		*/
		btnNewButton_2 = new JButton("Eliminar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				if(table.getSelectedRow() != -1) {
				
					int filaSeleccionada = table.getSelectedRow();
					
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					
					try {
						GestorSucursal.getInstance().deleteSucursal((int) model.getValueAt(filaSeleccionada, 0));
					} catch (Exception e1) {
						
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
		
		String[] columnNames = { "ID", "Nombre", "Precio" ,"Cantidad"};
		
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
		btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrameStock.this.setVisible(false);
				
				FramePrincipal principal = new FramePrincipal();
				
				try {
					principal.setVisible(true);
				} catch(Exception er) {
					er.printStackTrace();
				}
				
				FrameStock.this.dispose();
				
			}
		});
		btnNewButton_4 = new JButton("Editar stock");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_4.gridx = 1;
		gbc_btnNewButton_4.gridy = 7;
		contentPane.add(btnNewButton_4, gbc_btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrameStock.this.setVisible(false);
				
				CrearSucursal crearSucursal= new CrearSucursal();
				
				try {
					crearSucursal.setVisible(true);
				} catch(Exception er) {
					er.printStackTrace();
				}
				
				FrameStock.this.dispose();
				
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridwidth = 2;
		gbc_btnNewButton_1.gridx = 7;
		gbc_btnNewButton_1.gridy = 7;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);

		TableCellRenderer rendererFromHeader = table.getTableHeader().getDefaultRenderer();
		JLabel headerLabel = (JLabel) rendererFromHeader;
		headerLabel.setHorizontalAlignment(JLabel.CENTER);

	}
	
	private void cargarModelo(DefaultTableModel model, HashMap<Producto, Integer> listaProductos) {
		
		for (HashMap.Entry<Producto, Integer> entry : listaProductos.entrySet()) {
			Object[] aux = {entry.getKey().getId(), entry.getKey().getNombre(), entry.getKey().getPrecio(), entry.getValue()};
			model.addRow(aux);
		}
		
	}

}
