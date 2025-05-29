package co.com.porvenir.extracto_empresarial.application.helpers.params;

import lombok.Getter;

@Getter
public enum IdeParamName {

    // IDE: Información Desagregada por Empresa

    IDE_APORTES("ide_aportes"),
    IDE_RETIROS("ide_retiros"),
    IDE_TRASLADOS_PORTAFOLIOS("ide_traslados_portafolios"),
    IDE_VALORIZACION("ide_valorizacion"),
    IDE_SALDO_FINAL("ide_saldo_final"),
    IDE_SALDO_ANTERIOR("ide_saldo_anterior"),
    IDE_SALDO_RESTRINGIDO("ide_saldo_restringido"),
    IDE_COMISION_COBRADA("ide_comision_cobrada"),
    IDE_PLAN("ide_plan"),
    IDE_FONDO("ide_fondo"),
    IDE_RENTA_ACUMULADA("ide_renta_acumulada"),
    IDE_COLLECTION_TABLE("ide_collection_table"),

    IDE_SUBREPORT("ide_subreport"),
    IDE_DATA_SOURCE("ide_data_source"),
    IDE_PARAMS("ide_subreport_parameters");

    private final String paramName;

    IdeParamName(String paramName) {
        this.paramName = paramName;
    }
}
