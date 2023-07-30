package App;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.FlowLayout;

public class FrameOpcionesSucursal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameOpcionesSucursal frame = new FrameOpcionesSucursal();
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
	public FrameOpcionesSucursal() {
		setTitle("Sistema de Gestión");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Sucursal");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel Sucursalpanel = new JPanel();
		Sucursalpanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_Sucursalpanel = new GridBagConstraints();
		gbc_Sucursalpanel.fill = GridBagConstraints.BOTH;
		gbc_Sucursalpanel.gridwidth = 5;
		gbc_Sucursalpanel.insets = new Insets(0, 0, 5, 5);
		gbc_Sucursalpanel.gridx = 1;
		gbc_Sucursalpanel.gridy = 2;
		contentPane.add(Sucursalpanel, gbc_Sucursalpanel);
		GridBagLayout gbl_Sucursalpanel = new GridBagLayout();
		gbl_Sucursalpanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_Sucursalpanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_Sucursalpanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_Sucursalpanel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		Sucursalpanel.setLayout(gbl_Sucursalpanel);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 3;
		Sucursalpanel.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_3 = new JButton("Buscar");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 6;
		gbc_btnNewButton_3.gridy = 3;
		Sucursalpanel.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("Editar");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 4;
		gbc_btnNewButton_2.gridy = 5;
		Sucursalpanel.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Eliminar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.gridx = 6;
		gbc_btnNewButton_1.gridy = 5;
		Sucursalpanel.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_4 = new JButton("Volver");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.gridwidth = 3;
		gbc_btnNewButton_4.gridx = 4;
		gbc_btnNewButton_4.gridy = 3;
		contentPane.add(btnNewButton_4, gbc_btnNewButton_4);
	}

}
