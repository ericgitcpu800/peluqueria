import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Cita {
    private LocalTime hora;
    private Cliente cliente;
    private Peluquero peluquero;

    public Cita(String hora, Cliente cliente, Peluquero peluquero) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        this.hora = LocalTime.parse(hora, formatter);
        this.cliente = cliente;
        this.peluquero = peluquero;
    }

    public LocalTime getHora() {
        return hora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Peluquero getPeluquero() {
        return peluquero;
    }
}
