package co.com.porvenir.extracto_empresarial.application.dto.models.paramsnames;

import lombok.Getter;

@Getter
public enum MpaParamName {
    //MPA: Monto Proceso de Acreditación

    MPA_NIT("mpa_nit"),
    MPA_MONTO_PROCESO("mpa_monto_proceso"),
    MPA_NIT_TOTAL("mpa_nit_total"),
    MPA_TOTAL_MONTO_PROCESO("mpa_total_monto_proceso"),
    MPA_NOMBRE_PLAN_EMPRESARIAL("mpa_nombre_plan_empresarial"),
    MPA_COLLECTION_TABLE("mpa_collection_table"),

    MPA_SUBREPORT("mpa_subreport"),
    MPA_DATA_SOURCE("mpa_data_source"),
    MPA_PARAMS("mpa_subreport_parameters");

    private final String paramName;

    MpaParamName(String paramName) {
        this.paramName = paramName;
    }
}
