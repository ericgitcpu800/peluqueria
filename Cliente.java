class Cliente extends Persona {
    private String rut;

    public Cliente(String rut, String nombre, String correo, String telefono) {
        super(nombre, correo, telefono);
        this.rut = rut;
    }

    public String getRut() {
        return rut;
    }
}