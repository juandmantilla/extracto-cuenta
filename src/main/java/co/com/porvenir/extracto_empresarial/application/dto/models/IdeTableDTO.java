package co.com.porvenir.extracto_empresarial.application.dto.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IdeTableDTO {
    // IDE: Información Desagregada por Empresa
    private String portafolioInversion;
    private String saldoAnterior;
    private String aportes;
    private String retiros;
    private String trasladosEntrePortafolios;
    private String valorizacion;
    private String saldoFinal;
    private String saldoRestringido;
    private String comisionCobrada;
    private String rentPeriodoPlan;
    private String rentPeriodoFondo;
    private String rentAcumuladaFondo;

}
