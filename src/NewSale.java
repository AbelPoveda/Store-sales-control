import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NewSale {
    private JPanel nuevaventa;
    private JComboBox articulos;
    private JTextField cantidad;
    private JButton botonadd;
    private JButton botonfin;
    private JTextField total;
    private JButton reset;
    private JLabel disponibles;
    private JList lista;
    private double cantidadtotal = 0.0;
    private ArrayList<String> articuloscomprados = new ArrayList<>();

    public NewSale() {

        DefaultListModel modelo = new DefaultListModel();
        lista.setModel(modelo);

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cantidad.setText("0");
                total.setText("0");
                cantidadtotal = 0.0;
                modelo.clear();
            }
        });

        //--------rellenar combobox---------
        ArrayList<String> a = new ArrayList<>(MyConn.sacarproductos("SELECT nombre FROM productos"));
        for (int b = 0; b < a.size(); b++) {
            articulos.addItem(a.get(b));
        }
        //--------mostrar unidades disponibles del articulo seleccionado
        disponibles.setText("Unidades disponibles: " + MyConn.sacarunidades(articulos.getSelectedItem().toString()));

        botonadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String articulo = articulos.getSelectedItem().toString();
                int unidades = Integer.parseInt(cantidad.getText());
                double precio = MyConn.sacarprecio(articulo);
                cantidadtotal += precio * unidades;
                total.setText(String.valueOf(cantidadtotal));
                articuloscomprados.add(articulo);
                modelo.addElement(articulo + ": " + precio + " x " + unidades + " = " + precio * unidades);
            }
        });

    }

    public void crearventanaventa() {
        JFrame ventana = new JFrame("Venta");
        ventana.setContentPane(new NewSale().nuevaventa);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);
    }

}
