package modelo;

public class Boleto {
    private Pelicula pelicula;
    private Horario horario;
    private int cantidad;

    public Boleto(Pelicula pelicula, Horario horario, int cantidad) {
        this.pelicula = pelicula;
        this.horario = horario;
        this.cantidad = cantidad;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
