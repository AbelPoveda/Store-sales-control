import sun.misc.FloatingDecimal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateItem {
    private JPanel panelnuevoitem;
    private JTextField nombrearticulo;
    private JLabel labelnombre;
    private JLabel labelcantidad;
    private JLabel labelprecio;
    private JTextField precioarticulo;
    private JTextField cantidadarticulo;
    private JButton agregaritem;

    public CreateItem() {
        agregaritem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String item = nombrearticulo.getText();
                int cantidad = Integer.parseInt(cantidadarticulo.getText());
                float precio = Float.parseFloat(precioarticulo.getText());
                MyConn.agregarnuevoproducto(item, cantidad, precio);
            }
        });
    }

    public void crearventanaagregar() {
        JFrame ventana = new JFrame("Crear artículo");
        ventana.setContentPane(new CreateItem().panelnuevoitem);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);
    }
}
