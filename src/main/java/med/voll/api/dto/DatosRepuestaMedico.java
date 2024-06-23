package med.voll.api.dto;

public record DatosRepuestaMedico(Long id, String nombre, String email, String telefono, String documento,
                                  Especialidad especialidad, DatosDireccion direccion) {
}
