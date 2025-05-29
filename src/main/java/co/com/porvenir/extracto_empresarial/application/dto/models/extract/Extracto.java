package co.com.porvenir.extracto_empresarial.application.dto.models.extract;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Extracto {
    @JsonProperty("EncabezadoPag")
    private EncabezadoPag encabezadoPag;

    @JsonProperty("Encabezado")
    private Encabezado encabezado;

    @JsonProperty("Pie")
    private Pie pie;

    @JsonProperty("CondicionesPlan")
    private CondicionesPlan condicionesPlan;

    @JsonProperty("Rentabilidades")
    private Rentabilidades rentabilidades;

    @JsonProperty("Comisiones")
    private Comisiones comisiones;

    @JsonProperty("InformacionDesagregadaGrupoEmpresarial")
    private String informacionDesagregadaGrupoEmpresarial;

    @JsonProperty("InformacionGrupoEmpresarial")
    private InformacionGrupoEmpresarial informacionGrupoEmpresarial;

    @JsonProperty("GraficoDinamico")
    private GraficoDinamico graficoDinamico;

    @JsonProperty("RentabilidadInicio")
    private String rentabilidadInicio;

    @JsonProperty("RentabilidadPeriodo")
    private String rentabilidadPeriodo;

    @JsonProperty("MontoenProcAcr")
    private MontoenProcAcr montoenProcAcr;

    @JsonProperty("TotalMontos")
    private TotalMontos totalMontos;

    @JsonProperty("TotalSaldosAfiliados")
    private TotalSaldosAfiliados totalSaldosAfiliados;

    @JsonProperty("Observaciones")
    private Observaciones observaciones;
}
