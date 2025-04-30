/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import modelo.Pedido;

/**
 *
 * @author paolaschicote
 */
public class Gestor {

    // Guardamos pedidos en .dat
    public static void guardarFicheroDat(ArrayList<Pedido> listaPedidos, String ficheroDat) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ficheroDat))) {
            for (Pedido p : listaPedidos) {
                out.writeObject(p);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Cargamos pedidos desde .dat
    public static ArrayList<Pedido> cargarFicheroDat(String ficheroDat) {
        ArrayList<Pedido> listaPedidos = new ArrayList<>();
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream(ficheroDat));
            while (true) {
                try {
                    Pedido p = (Pedido) ois.readObject();
                    listaPedidos.add(p);
                } catch (EOFException eofe) {
                    
                    break;
                } catch (IOException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return listaPedidos;
    }

    // Buscar pedido por número
    public static Pedido buscarPedidoPorNumero(ArrayList<Pedido> listaPedidos, int numero) {
        for (Pedido p : listaPedidos) {
            if (p.getNumeroPedido() == numero) {
                return p;
            }
        }
        return null;
    }

    // Guardar pedidos a txt (separado por ";")
    public static void guardarFicheroTxt(ArrayList<Pedido> listaPedidos, String ficheroTxt) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(ficheroTxt))) {
            for (Pedido p : listaPedidos) {
                escritor.write(p.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
