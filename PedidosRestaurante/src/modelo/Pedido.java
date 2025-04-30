/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author paolaschicote
 */
public class Pedido implements Serializable {

    private int numeroPedido;
    private String nombreCliente;
    private ArrayList<String> platos;
    private double total;

    public Pedido(int numeroPedido, String nombreCliente, ArrayList<String> platos, double total) {
        this.numeroPedido = numeroPedido;
        this.nombreCliente = nombreCliente;
        this.platos = platos;
        this.total = total;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public ArrayList<String> getPlatos() {
        return platos;
    }

    public void setPlatos(ArrayList<String> platos) {
        this.platos = platos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return numeroPedido + ";" + nombreCliente + ";" + String.join(",", platos) + ";" + total + "\n";
    }
}
