import java.util.ArrayList;
import java.util.List;

public class SalonDePeluqueria {
    private List<Cita> citasDisponibles;
    private List<Peluquero> peluquerosDisponibles;

    public SalonDePeluqueria() {
        citasDisponibles = new ArrayList<>();

        // lista de esclavos trabajadores
        peluquerosDisponibles = new ArrayList<>();
        peluquerosDisponibles.add(new Peluquero("Erik", "erik@example.com", "123456789", "Corte de cabello"));
        peluquerosDisponibles.add(new Peluquero("Mario", "mario@example.com", "987654321", "Lavado de cabeza"));
        peluquerosDisponibles.add(new Peluquero("Adan", "adan@example.com", "555555555", "Barbería"));
        peluquerosDisponibles.add(new Peluquero("Nicolas", "nicolas@example.com", "111111111", "Peinados"));
    }

    public List<Cita> getCitasDisponibles() {
        return citasDisponibles;
    }

    public boolean agendarCita(String hora, Peluquero peluquero, Cliente cliente) {
        return true;
    }

    public List<Peluquero> getPeluqueros() {
        return peluquerosDisponibles;
    }

    // citas agendadas de un peluquero específico - no funca
    public List<Cita> obtenerCitasPeluquero(Peluquero peluquero) {
        List<Cita> citasPeluquero = new ArrayList<>();
        for (Cita cita : citasDisponibles) {
            if (cita.getPeluquero().equals(peluquero)) {
                citasPeluquero.add(cita);
            }
        }
        return citasPeluquero;
    }
}
