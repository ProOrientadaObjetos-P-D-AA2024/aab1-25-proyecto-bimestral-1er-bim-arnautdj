package modelo;

import java.util.ArrayList;

public class Venta {
    private String cliente;
    private ArrayList<Boleto> boletos;
    private ArrayList<Snack> snacks;
    private double total;

    public Venta(String cliente, ArrayList<Boleto> boletos, ArrayList<Snack> snacks, double total) {
        this.cliente = cliente;
        this.boletos = boletos;
        this.snacks = snacks;
        this.total = total;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Boleto> getBoletos() {
        return boletos;
    }

    public void setBoletos(ArrayList<Boleto> boletos) {
        this.boletos = boletos;
    }

    public ArrayList<Snack> getSnacks() {
        return snacks;
    }

    public void setSnacks(ArrayList<Snack> snacks) {
        this.snacks = snacks;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}

