package co.com.porvenir.extracto_empresarial.application.dto.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MpaTableDTO {
    // MPA: Monto Proceso de Acreditación
    private String codigoObjetivo;
    private String nombreObjetivo;
    private String tipoAporte;
    private String realizaAporte;
    private String aporteTieneCondicion;
    private String montAporteTipoValor;
    private String montAporteValor;
    private String periodicidad;
    private String permiteRetiros;
    private String reqAutorizacionRetiros;
    private String permiteTrasladoPortafolios;
    private String permiteBloqueoEntidades;
}
