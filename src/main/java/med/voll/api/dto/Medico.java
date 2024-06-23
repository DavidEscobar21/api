package med.voll.api.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String documento;
    private boolean activo;
    private String telefono;
    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;
    @Embedded
    private Direccion direccion;

    public Medico(DatosMedico datosMedico) {
        this.nombre=datosMedico.nombre();
        this.email= datosMedico.email();
        this.documento= datosMedico.documento();
        this.especialidad=datosMedico.especialidad();
        this.direccion=new Direccion(datosMedico.direccion());
        this.telefono=datosMedico.telefono();
        this.activo=true;

    }

    public void actualizarDatos(DatosActualizarMedico datosActualizarMedico) {
        if (datosActualizarMedico.nombre() != null){
            this.nombre=datosActualizarMedico.nombre();
        }

        if (datosActualizarMedico.documento() != null){
            this.documento= datosActualizarMedico.documento();
        }

        if (datosActualizarMedico.direccion() != null){
            this.direccion= direccion.actualizarDireccion(datosActualizarMedico.direccion());
        }

    }

    public void desactivarMedico() {
        this.activo=false;
    }
}
