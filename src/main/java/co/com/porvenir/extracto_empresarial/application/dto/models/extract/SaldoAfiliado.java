package co.com.porvenir.extracto_empresarial.application.dto.models.extract;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SaldoAfiliado {
    @JsonProperty("IDCuentaPlan")
    private String idCuentaPlan;

    @JsonProperty("EstadoCuenta")
    private String estadoCuenta;

    @JsonProperty("NombreAfiliado")
    private String nombreAfiliado;

    @JsonProperty("DocAfiliado")
    private String docAfiliado;

    @JsonProperty("CodObjetivo")
    private String codObjetivo;

    @JsonProperty("SaldoAnterior")
    private String saldoAnterior;

    @JsonProperty("Aportes")
    private String aportes;

    @JsonProperty("Retiros")
    private String retiros;

    @JsonProperty("Transferencias")
    private String transferencias;

    @JsonProperty("SaldoFinal")
    private String saldoFinal;
}
