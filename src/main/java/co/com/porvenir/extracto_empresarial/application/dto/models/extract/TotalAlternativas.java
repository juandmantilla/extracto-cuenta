package co.com.porvenir.extracto_empresarial.application.dto.models.extract;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TotalAlternativas {
    @JsonProperty("SaldoAnterior")
    private String saldoAnterior;

    @JsonProperty("Aportes")
    private String aportes;

    @JsonProperty("Retiros")
    private String retiros;

    @JsonProperty("Transferencias")
    private String transferencias;

    @JsonProperty("Valorizacion")
    private String valorizacion;

    @JsonProperty("SaldoFinal")
    private String saldoFinal;

    @JsonProperty("SaldoRestringido")
    private String saldoRestringido;

    @JsonProperty("Comision")
    private String comision;

    @JsonProperty("RentabilidadPeriodoPlan")
    private String rentabilidadPeriodoPlan;
}
