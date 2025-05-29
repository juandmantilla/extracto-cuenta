package co.com.porvenir.extracto_empresarial.application.helpers.params;

import lombok.Getter;

@Getter
public enum IggeParamName {

    //IGGE: Información General del Grupo Empresarial.

    IGGE_NIT_EMPRESARIAL("igge_nit_empresarial"),
    IGGE_TOTAL_SALDO_ANTERIOR("igge_total_saldo_anterior"),
    IGGE_TOTAL_APORTES("igge_total_aportes"),
    IGGE_TOTAL_RETIROS("igge_total_retiros"),
    IGGE_TOTAL_TRASLADOS("igge_total_traslados"),
    IGGE_TOTAL_VALORIZACION("igge_total_valorizacion"),
    IGGE_TOTAL_SALDO_FINAL("igge_total_saldo_final"),
    IGGE_TOTAL_SALDO_RESTRINGIDO("igge_total_saldo_restringido"),
    IGGE_TOTAL_COMISION_COBRADA("igge_total_comision_cobrada"),
    IGGE_NUMERO_PARTICIPES("igge_numero_participes"),
    IGGE_NIT_PLAN("igge_nit_plan"),
    IGGE_DIRECCION("igge_direccion"),
    IGGE_NIC("igge_nic"),
    IGGE_ENTIDAD_PATROCINADORA("igge_entidad_patrocinadora"),
    IGGE_CIUDAD_DEPTO("igge_ciudad_depto"),

    IGGE_COLLECTION_TABLE("igge_collection_table"),

    IGGE_SUBREPORT("igge_subreport"),
    IGGE_DATA_SOURCE("igge_data_source"),
    IGGE_PARAMS("igge_subreport_parameters");

    private final String paramName;

    IggeParamName(String paramName) {
        this.paramName = paramName;
    }
}
