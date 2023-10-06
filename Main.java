import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        SalonDePeluqueria salon = new SalonDePeluqueria();
        Scanner scanner = new Scanner(System.in);

        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");

        System.out.println("Horas disponibles:");
        List<Cita> citasDisponibles = salon.getCitasDisponibles();
        for (Cita cita : citasDisponibles) {
            System.out.println("Hora: " + dateFormat.format(cita.getHora()) + " con Peluquero: " + cita.getPeluquero().getNombre());
        }
        boolean agendarMasCitas = true;

        while (agendarMasCitas) {
            System.out.print("¿Desea agendar una cita? (Sí/No): ");
            String respuesta = scanner.nextLine();

            if (respuesta.equalsIgnoreCase("Si")) {
                System.out.print("Seleccione una hora disponible (HH:mm): ");
                String hora = scanner.nextLine();

                System.out.print("Seleccione un peluquero (Erik/Nicolas/Mario/Adan): ");
                String nombrePeluquero = scanner.nextLine();

                Peluquero peluqueroSeleccionado = null;
                for (Peluquero peluquero : salon.getPeluqueros()) {
                    if (peluquero.getNombre().equalsIgnoreCase(nombrePeluquero)) {
                        peluqueroSeleccionado = peluquero;
                        break;
                    }
                }
                if (peluqueroSeleccionado != null) {
                    // Obtener información del cliente
                    System.out.print("Ingrese su rut: ");
                    String rutCliente = scanner.nextLine();
                    System.out.print("Ingrese su nombre: ");
                    String nombreCliente = scanner.nextLine();
                    System.out.print("Ingrese su correo: ");
                    String correoCliente = scanner.nextLine();
                    System.out.print("Ingrese su teléfono: ");
                    String telefonoCliente = scanner.nextLine();

                    // creando cita
                    Cliente cliente = new Cliente(rutCliente, nombreCliente, correoCliente, telefonoCliente);

                    boolean citaAgendada = salon.agendarCita(hora, peluqueroSeleccionado, cliente);

                    if (citaAgendada) {
                        System.out.println("Cita agendada con éxito.");
                    } else {
                        System.out.println("La hora seleccionada no está disponible.");
                    }
                } else {
                    System.out.println("Peluquero no encontrado.");
                }
            } else if (respuesta.equalsIgnoreCase("No")) {
                agendarMasCitas = false;
                System.out.println("Gracias por usar nuestro sistema de reserva.");
            } else {
                System.out.println("Respuesta no válida. Por favor, responda 'Sí' o 'No'.");
            }
        }

        // Ciclo para mostrar las citas - no funcas
        System.out.println("Listado de citas agendadas por cada peluquero:");
        for (Peluquero peluquero : salon.getPeluqueros()) {
            System.out.println("Peluquero: " + peluquero.getNombre());

            // Obtener citas agendadas - no funca
            List<Cita> citasPeluquero = salon.obtenerCitasPeluquero(peluquero);

            if (citasPeluquero.isEmpty()) {
                System.out.println("No tiene citas agendadas.");
            } else {
                for (Cita cita : citasPeluquero) {
                    System.out.println("Hora: " + dateFormat.format(cita.getHora()) + " con Cliente: " + cita.getCliente().getNombre());
                }
            }
            System.out.println(); // Separador entre peluqueros
        }
    }
}