import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private JPanel panelprincipal;
    private JButton nuevaventa;
    private JButton agregar;
    private JButton creararticulo;

    public Main() {

        nuevaventa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewSale venta = new NewSale();
                venta.crearventanaventa();
            }
        });
        agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddProducts agregar = new AddProducts();
                agregar.crearventanaventa();
            }
        });
        creararticulo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateItem nuevo = new CreateItem();
                nuevo.crearventanaagregar();
            }
        });
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("Control de stock");
        frame.setContentPane(new Main().panelprincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
