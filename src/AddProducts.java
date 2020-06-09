import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddProducts {
    private JPanel panelagregar;
    private JComboBox articulos;
    private JSpinner unidades;
    private JButton botonagregar;

    public AddProducts() {
        //--------rellenar combobox---------
        ArrayList<String> a = new ArrayList<>(MyConn.sacarproductos("SELECT nombre FROM productos"));
        for (int b = 0; b < a.size(); b++) {
            articulos.addItem(a.get(b));
        }
        botonagregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int cantidad = Integer.parseInt(unidades.getValue().toString());
                String articulo = articulos.getSelectedItem().toString();
                MyConn.agregarproductoexistente(articulo, cantidad+MyConn.sacarunidades(articulo));
            }
        });
    }

    public void crearventanaventa() {
        JFrame ventana = new JFrame("Añadir producto");
        ventana.setContentPane(new AddProducts().panelagregar);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);
    }
}
