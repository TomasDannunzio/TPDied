package InterfazGrafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.layout.mxParallelEdgeLayout;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.model.mxGeometry;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.swing.handler.mxEdgeHandler;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;

import org.jgrapht.ext.JGraphXAdapter;

import Gestores.GestorRuta;
import Gestores.GestorSucursal;
import POJO.Ruta;
import POJO.Sucursal;
import java.awt.BorderLayout;



public class Grafo extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7377491412068818648L;
	
	public Grafo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GestorSucursal gestorSucursal = GestorSucursal.getInstance();
		GestorRuta gestorRuta = GestorRuta.getInstance();
		
		ArrayList<Sucursal> listaSucursal = gestorSucursal.getAllSucursal();
		ArrayList<Ruta> listaRuta = gestorRuta.getAllRuta();
		
		SimpleDirectedWeightedGraph<String,String> grafo = new SimpleDirectedWeightedGraph<String,String>(String.class);
		
		for(Sucursal s : listaSucursal) {
			
			grafo.addVertex(s.getNombre());
			
		}
		
		for(Ruta r : listaRuta) {
			
			grafo.addEdge(r.getOrigen().getNombre(),r.getDestino().getNombre(),"ID:"+r.getId()+"\nCapacidad:"+r.getCapacidad
					()+"\nTiempo de transito:"+r.getTiempoTransito());
			
			}
		
		
		
		JGraphXAdapter<String,String> jgxAdapter = new JGraphXAdapter<String,String>(grafo);
		
		mxGraphComponent component = new mxGraphComponent(jgxAdapter);
		
		
		setTitle("Mapa de sucursales");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		
		
		mxGraph mxGraph = new mxGraph();
        Object parent = mxGraph.getDefaultParent();
        
        Map<String, Object> vertexMap = new HashMap<>();

        mxGraph.getModel().beginUpdate();

        try {
            // Convertir los nodos de JGraphT en vértices de JGraphX
            for (String vertex : grafo.vertexSet()) {
                Object mxVertex = mxGraph.insertVertex(parent, null, vertex, 0, 0, 100, 30);
                vertexMap.put(vertex, mxVertex);
            }

            // Convertir las aristas de JGraphT en arcos de JGraphX
            for (String edge : grafo.edgeSet()) {
                String source = grafo.getEdgeSource(edge);
                String target = grafo.getEdgeTarget(edge);
                String weight = edge;

                mxGraph.insertEdge(parent, null, weight,
                        vertexMap.get(source), vertexMap.get(target));
            }
        } finally {
            mxGraph.getModel().endUpdate();
        }
        
        mxCircleLayout layout = new mxCircleLayout(mxGraph);
        layout.setRadius(200);
        layout.execute(mxGraph.getDefaultParent());
        new mxParallelEdgeLayout(mxGraph).execute(mxGraph.getDefaultParent());
        

        // Ajustar los parámetros de estilo para un mejor espaciado entre nodos
        mxGraph.setCellStyles(mxConstants.STYLE_VERTICAL_ALIGN, mxConstants.ALIGN_MIDDLE);
        mxGraph.setCellStyles(mxConstants.STYLE_VERTICAL_LABEL_POSITION, mxConstants.ALIGN_MIDDLE);
            
        
        mxGraphComponent graphComponent = new mxGraphComponent(mxGraph);
        getContentPane().add(graphComponent, BorderLayout.CENTER);
        
        pack();
        
	
	}
	public SimpleDirectedWeightedGraph<String,String> getGrafo(){
		GestorSucursal gestorSucursal = GestorSucursal.getInstance();
		GestorRuta gestorRuta = GestorRuta.getInstance();
		
		ArrayList<Sucursal> listaSucursal = gestorSucursal.getAllSucursal();
		ArrayList<Ruta> listaRuta = gestorRuta.getAllRuta();
		
		SimpleDirectedWeightedGraph<String,String> grafo = new SimpleDirectedWeightedGraph<String,String>(String.class);
		
		for(Sucursal s : listaSucursal) {
			
			grafo.addVertex(s.getNombre());
			
		}
		
		for(Ruta r : listaRuta) {
			
			grafo.addEdge(r.getOrigen().getNombre(),r.getDestino().getNombre(),"ID:"+r.getId()+"\nCapacidad:"+r.getCapacidad
					()+"\nTiempo de transito:"+r.getTiempoTransito());
			
			}
		return grafo;
	}
}
