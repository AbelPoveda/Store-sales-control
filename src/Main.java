import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private JPanel panelprincipal;
    private JButton nuevaventa;

    public Main() {

        nuevaventa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NuevaVenta venta = new NuevaVenta();
                venta.crearventanaventa();
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
