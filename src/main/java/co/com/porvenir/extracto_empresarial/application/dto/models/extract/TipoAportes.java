package co.com.porvenir.extracto_empresarial.application.dto.models.extract;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TipoAportes {
    @JsonProperty("TipoAporteAfiliado")
    private String tipoAporteAfiliado;

    @JsonProperty("TipoAporteEmpleador")
    private String tipoAporteEmpleador;

    @JsonProperty("RealizaAporte")
    private RealizaAporte realizaAporte;

    @JsonProperty("AporteTieneCondicion")
    private AporteTieneCondicion aporteTieneCondicion;

    @JsonProperty("MontoAporte")
    private MontoAporte montoAporte;

    @JsonProperty("PeriocidadAporte")
    private PeriocidadAporte periocidadAporte;

    @JsonProperty("PermiteRetiroAporte")
    private PermiteRetiroAporte permiteRetiroAporte;

    @JsonProperty("RequiereAutorizacionAporte")
    private RequiereAutorizacionAporte requiereAutorizacionAporte;

    @JsonProperty("PermiteTraladoAporte")
    private PermiteTraladoAporte permiteTraladoAporte;

    @JsonProperty("PermiteBloqueoAporte")
    private PermiteBloqueoAporte permiteBloqueoAporte;
}
