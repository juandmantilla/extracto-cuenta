package co.com.porvenir.extracto_empresarial.application.dto.models.extract;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DetalleCondicion {
    @JsonProperty("CodigoDelObjetivo")
    private String codigoDelObjetivo;

    @JsonProperty("NombreDelObjetivo")
    private String nombreDelObjetivo;

    @JsonProperty("TipoAportes")
    private TipoAportes tipoAportes;
}