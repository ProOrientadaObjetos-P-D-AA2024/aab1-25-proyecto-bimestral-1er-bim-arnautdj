package modelo;

public class Promocion {
    private String descripcion;
    private double descuento;

    public Promocion(String descripcion, int descuento) {
        this.descripcion = descripcion;
        this.descuento = descuento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
}

