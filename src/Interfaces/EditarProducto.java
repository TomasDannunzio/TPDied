package Interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import App.FramePrincipal;
import Gestores.GestorProducto;
import POJO.Producto;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class EditarProducto extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField DescText;
	private JTextField nombreText;
	private JTextField precioText;
	private JTextField pesoText;

	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarProducto frame = new EditarProducto();
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
	public EditarProducto(int i) {
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
		
		JLabel lblNewLabel = new JLabel("Nuevo Producto");
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
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 3;
		gbc_lblNewLabel_1_1.gridy = 0;
		panel.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		Producto p = null;
		try {
			p = GestorProducto.getInstance().getProductoById(i);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Integer id = p.getId();
		
		txtId = new JTextField();
		txtId.setText(id.toString());
		txtId.setEditable(false);
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_txtAd = new GridBagConstraints();
		gbc_txtAd.insets = new Insets(0, 0, 5, 5);
		gbc_txtAd.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAd.gridx = 1;
		gbc_txtAd.gridy = 1;
		panel.add(txtId, gbc_txtAd);
		txtId.setColumns(10);
		
		nombreText = new JTextField(p.getNombre());
		nombreText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nombreText.setColumns(10);
		GridBagConstraints gbc_nombreText = new GridBagConstraints();
		gbc_nombreText.insets = new Insets(0, 0, 5, 5);
		gbc_nombreText.fill = GridBagConstraints.HORIZONTAL;
		gbc_nombreText.gridx = 3;
		gbc_nombreText.gridy = 1;
		panel.add(nombreText, gbc_nombreText);
		
		JLabel lblNewLabel_1_2 = new JLabel("Horario de apertura:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_2.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2.gridx = 1;
		gbc_lblNewLabel_1_2.gridy = 2;
		panel.add(lblNewLabel_1_2, gbc_lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Horario de cierre:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1_3 = new GridBagConstraints();
		gbc_lblNewLabel_1_3.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_1_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_3.gridx = 3;
		gbc_lblNewLabel_1_3.gridy = 2;
		panel.add(lblNewLabel_1_3, gbc_lblNewLabel_1_3);
		
		DescText = new JTextField(p.getDescripcion());
		DescText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		DescText.setColumns(10);
		GridBagConstraints gbc_horApText = new GridBagConstraints();
		gbc_horApText.fill = GridBagConstraints.HORIZONTAL;
		gbc_horApText.insets = new Insets(0, 0, 5, 5);
		gbc_horApText.gridx = 1;
		gbc_horApText.gridy = 3;
		panel.add(DescText, gbc_horApText);
		
		precioText = new JTextField(""+p.getPrecio()+"");
		precioText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		precioText.setColumns(10);
		GridBagConstraints gbc_horCeText = new GridBagConstraints();
		gbc_horCeText.insets = new Insets(0, 0, 5, 5);
		gbc_horCeText.fill = GridBagConstraints.HORIZONTAL;
		gbc_horCeText.gridx = 3;
		gbc_horCeText.gridy = 3;
		panel.add(precioText, gbc_horCeText);
		
		JLabel lblNewLabel_2 = new JLabel("Peso");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 4;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		pesoText = new JTextField(""+p.getPeso()+"");
		pesoText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pesoText.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 5;
		panel.add(pesoText, gbc_textField);
		
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
				
				String nombre = nombreText.getText();
				String descripcion = DescText.getText();
				Float precio = Float.parseFloat(precioText.getText());
				Float peso= Float.parseFloat(pesoText.getText());
				
				GestorProducto.getInstance().updateProducto(id, nombre, descripcion, precio, peso);
				
				EditarProducto.this.setVisible(false);
				
				FrameProducto principal = new FrameProducto();
				
				try {
					principal.setVisible(true);
				} catch(Exception er) {
					er.printStackTrace();
				}
				
				EditarProducto.this.dispose();
				
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
				
				EditarProducto.this.setVisible(false);
				
				FrameProducto principal = new FrameProducto();
				
				try {
					principal.setVisible(true);
				} catch(Exception er) {
					er.printStackTrace();
				}
				
				EditarProducto.this.dispose();
				
			}
		});
		
		
	}

}
