package co.com.porvenir.extracto_empresarial.application.helpers.params;

import lombok.Getter;

@Getter
public enum RmpParamName {

    RMP_COLLECTION_TABLE("rmp_collection_table"),
    RMP_SUBREPORT("rmp_subreport"),
    RMP_DATA_SOURCE("rmp_data_source"),
    RMP_PARAMS("rmp_subreport_parameters");

    private final String paramName;

    RmpParamName(String paramName) {
        this.paramName = paramName;
    }
}
