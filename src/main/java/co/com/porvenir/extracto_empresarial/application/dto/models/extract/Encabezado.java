package co.com.porvenir.extracto_empresarial.application.dto.models.extract;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Encabezado {
    @JsonProperty("TipoId")
    private String tipoId;

    @JsonProperty("NIT")
    private String nit;

    @JsonProperty("RazonSocial")
    private String razonSocial;

    @JsonProperty("NIC")
    private String nic;

    @JsonProperty("Ciudad")
    private String ciudad;

    @JsonProperty("Direccion")
    private String direccion;

    @JsonProperty("CorreoEmpresa")
    private String correoEmpresa;
}
