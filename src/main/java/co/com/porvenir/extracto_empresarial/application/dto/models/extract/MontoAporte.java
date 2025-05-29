package co.com.porvenir.extracto_empresarial.application.dto.models.extract;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MontoAporte {
    @JsonProperty("MontoAporteTipoValAfiliado")
    private String montoAporteTipoValAfiliado;

    @JsonProperty("MontoAporteTipoValEmpleador")
    private String montoAporteTipoValEmpleador;

    @JsonProperty("MontoAporteValorAfiliado")
    private String montoAporteValorAfiliado;

    @JsonProperty("MontoAporteValorEmpleador")
    private String montoAporteValorEmpleador;
}
