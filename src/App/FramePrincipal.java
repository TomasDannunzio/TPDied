package App;

import java.awt.EventQueue;
import Interfaces.FrameSucursal;
import Interfaces.FrameProducto;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.border.CompoundBorder;

public class FramePrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FramePrincipal frame = new FramePrincipal();
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
	public FramePrincipal() {
		setType(Type.POPUP);
		setTitle("Sistema de Gestión");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{300, 300, 300, 200, 0};
		gbl_contentPane.rowHeights = new int[]{0, 51, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton btnNewButton = new JButton("Sucursal");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrameSucursal gestionSucursal = new FrameSucursal();
				
				FramePrincipal.this.setVisible(false);
				
				try {
				gestionSucursal.setVisible(true);
				} catch(Exception er) {
					er.printStackTrace();
				}
				
				FramePrincipal.this.dispose();
						
			}
		
		});
		
		JLabel lblNewLabel = new JLabel("Sistema de Gestión Logístico");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("¿Con qué desea trabajar?");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 5;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Camino");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 5;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Orden de Provisión\r\n");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 1;
		gbc_btnNewButton_2.gridy = 6;
		contentPane.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Producto\r\n");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrameProducto gestionProducto = new FrameProducto();
				
				FramePrincipal.this.setVisible(false);
				
				try {
				gestionProducto.setVisible(true);
				} catch(Exception er) {
					er.printStackTrace();
				}
				
				FramePrincipal.this.dispose();
				
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 2;
		gbc_btnNewButton_3.gridy = 6;
		contentPane.add(btnNewButton_3, gbc_btnNewButton_3);
	}

}
