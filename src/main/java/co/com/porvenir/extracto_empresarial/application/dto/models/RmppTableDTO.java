package co.com.porvenir.extracto_empresarial.application.dto.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RmppTableDTO {
    // RMPP: Resumen Movimiento Partícipes Periodo
    private String cuentaNumero;
    private String nombreParticipe;
    private String objetivo;
    private String saldoInicial;
    private String aportes;
    private String retiros;
    private String trasladosObjetivos;
    private String saldoFinal;
}
