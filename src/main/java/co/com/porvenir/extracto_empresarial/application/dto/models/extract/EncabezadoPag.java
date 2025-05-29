package co.com.porvenir.extracto_empresarial.application.dto.models.extract;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EncabezadoPag {
    @JsonProperty("Periodo")
    private Periodo periodo;

    @JsonProperty("Consecutivo")
    private String consecutivo;

    @JsonProperty("FechaEmision")
    private String fechaEmision;

    @JsonProperty("TextoFechaInicial")
    private String textoFechaInicial;

    @JsonProperty("TextoFechaMedio")
    private String textoFechaMedio;

    @JsonProperty("TextoFechaFinal")
    private String textoFechaFinal;
}