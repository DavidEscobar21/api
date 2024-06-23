package med.voll.api.dto;

import jakarta.validation.Valid;

public record DatosActualizacionPaciente(
        Long id,
        String nombre,
        String telefono,
        @Valid DatosDireccion direccion
) {
}