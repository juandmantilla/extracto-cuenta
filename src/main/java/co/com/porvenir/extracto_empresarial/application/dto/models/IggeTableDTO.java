package co.com.porvenir.extracto_empresarial.application.dto.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IggeTableDTO {
    //IGGE : Información General del Grupo Empresarial
    private String objetivoPlanEmpresarial;
    private String saldoAnterior;
    private String aportes;
    private String retiros;
    private String trasladoEntreObjetivos;
    private String valorizacion;
    private String saldoFinal;
    private String saldoRestringido;
    private String comisionCobrada;
}
