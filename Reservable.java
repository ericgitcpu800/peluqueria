import java.util.List;

public interface Reservable {
    boolean agendarCita(String hora, Peluquero peluquero);
    List<Cita> verCitasAgendadas();
}
