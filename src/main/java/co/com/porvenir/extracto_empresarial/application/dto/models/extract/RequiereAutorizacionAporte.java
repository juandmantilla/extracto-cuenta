package co.com.porvenir.extracto_empresarial.application.dto.models.extract;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RequiereAutorizacionAporte {
    @JsonProperty("RequiereAutorizacionAfiliado")
    private String requiereAutorizacionAfiliado;

    @JsonProperty("RequiereAutorizacionEmpleador")
    private String requiereAutorizacionEmpleador;
}
