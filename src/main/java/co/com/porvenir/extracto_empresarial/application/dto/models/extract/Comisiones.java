package co.com.porvenir.extracto_empresarial.application.dto.models.extract;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Comisiones {
    @JsonProperty("Comision90DiasAfiliado")
    private String comision90DiasAfiliado;

    @JsonProperty("Comision365DiasAfiliado")
    private String comision365DiasAfiliado;

    @JsonProperty("ComisionPesos90DiasAfiliado")
    private String comisionPesos90DiasAfiliado;

    @JsonProperty("ComisionPesos365DiasAfiliado")
    private String comisionPesos365DiasAfiliado;
}
