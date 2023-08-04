package Interfaces;
import InterfazGrafo.Grafo;
import POJO.Producto;
import POJO.Sucursal;

import org.jgrapht.graph.SimpleDirectedWeightedGraph;
import org.jgrapht.alg.scoring.*;
import java.util.Map;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.layout.mxParallelEdgeLayout;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.model.mxGeometry;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.swing.handler.mxEdgeHandler;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

public class FramePageRank extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FramePageRank frame = new FramePageRank();
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
	public FramePageRank() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		Grafo graph = new Grafo();
		PageRank<String, String> pageRank = new PageRank(graph.getGrafo());
		
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		String[] columnNames = { "Sucursal", "Valor"};
		DefaultTableModel model = new DefaultTableModel(null, columnNames);
		cargarModelo(model,pageRank.getScores());
		table = new JTable(model);
		table.setBackground(new Color(255, 255, 255));
		table.setForeground(new Color(0, 0, 0));
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		table.setToolTipText("");
		scrollPane.setViewportView(table);
	}
private void cargarModelo(DefaultTableModel model, Map<String, Double> mapa) {
	
	for (Map.Entry<String, Double> entry : mapa.entrySet()) {
		Object[] aux = {entry.getKey(), entry.getValue()};
		model.addRow(aux);
	}
	
}
		

}
