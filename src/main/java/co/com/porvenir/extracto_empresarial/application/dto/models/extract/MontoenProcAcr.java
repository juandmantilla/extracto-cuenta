package co.com.porvenir.extracto_empresarial.application.dto.models.extract;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MontoenProcAcr {
    @JsonProperty("NIT")
    private String nit;

    @JsonProperty("MontoEnProceso")
    private String montoEnProceso;

    @JsonProperty("RezagosCorrientes")
    private String rezagosCorrientes;

    @JsonProperty("RezagosHistoricos")
    private String rezagosHistoricos;

    @JsonProperty("SaldoFinalMasMontoEnProceso")
    private String saldoFinalMasMontoEnProceso;
}
