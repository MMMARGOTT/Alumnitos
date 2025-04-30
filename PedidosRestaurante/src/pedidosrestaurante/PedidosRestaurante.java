/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pedidosrestaurante;

import gestor.Gestor;
import interfaz.InformacionPedidos;
import java.util.ArrayList;
import java.util.Arrays;
import modelo.Pedido;

/**
 *
 * @author paolaschicote
 */
public class PedidosRestaurante {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        ArrayList<Pedido> listaPedidos = new ArrayList<>();
        String rutaDat = "src/ficheros/pedidos.dat";
        String rutaTxt = "src/ficheros/pedidos.txt";

        // Crear algunos pedidos
        Pedido p1 = new Pedido(1, "Niobe", new ArrayList<>(Arrays.asList("Pollo a la jardinera", "Paella", "Agua")), 25.50);
        Pedido p2 = new Pedido(2, "Paola", new ArrayList<>(Arrays.asList("Pizza", "Cocacola")), 18.00);
        listaPedidos.add(p1);
        listaPedidos.add(p2);

        // Guardar en .dat
       // Gestor.guardarFicheroDat(pedidos, rutaDat);

        // Leer desde .dat y mostrar
        ArrayList<Pedido> pedidosLeidos = Gestor.cargarFicheroDat(rutaDat);
        for (Pedido p : pedidosLeidos) {
            System.out.println(p);
        }
        
        InformacionPedidos ip = new InformacionPedidos(listaPedidos);
        ip.setVisible(true);
        ip.setLocationRelativeTo(null);
    }
/*
        // Exportar a .txt
        Gestor.guardarFicheroTxt(pedidos, rutaTxt);

        // Leer desde .txt
        ArrayList<Pedido> pedidosDesdeTxt = Gestor.leerFicheroTxt(rutaTxt);
        for (Pedido p : pedidosDesdeTxt) {
            System.out.println(p);
        }

        // Buscar pedido por número
        Pedido pedidoBuscado = Gestor.buscarPedidoPorNumero(pedidosLeidos, 2);
        if (pedidoBuscado != null) {
            System.out.println("Pedido encontrado: " + pedidoBuscado);
        } else {
            System.out.println("Pedido no encontrado.");
        }
    }
*/
}
