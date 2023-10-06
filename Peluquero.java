class Peluquero extends Persona {
    private String especialidad;

    public Peluquero(String nombre, String correo, String telefono, String especialidad) {
        super(nombre, correo, telefono);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }
}
