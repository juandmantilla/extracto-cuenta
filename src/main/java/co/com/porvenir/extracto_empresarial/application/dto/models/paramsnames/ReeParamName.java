package co.com.porvenir.extracto_empresarial.application.dto.models.paramsnames;

import lombok.Getter;

@Getter
public enum ReeParamName {
    // REE: Reporte Extractos Empresariales (general)

    NIT("nit"),
    PERIODO("periodo"),
    NUMERO_EXTRACTO("numero_extracto"),
    FECHA_EXPEDICION("fecha_expedicion"),
    DIRECCION("direccion"),
    ENTIDAD_PATROCINADORA("entidad_patrocinadora"),
    CIUDAD_DEPTO("ciudad_depto"),
    NIC("nic"),
    NIT_EMPRESARIAL("nit_empresarial"),
    NIT_GRUPO_EMPRESARIAL("nit_grupo_empresarial"),


    CONSULTOR_NOMBRE("consultor_nombre"),
    CONSULTOR_CIUDAD("consultor_ciudad"),
    CONSULTOR_CELULAR("consultor_celular"),
    CONSULTOR_EMAIL("consultor_email");

    private final String paramName;

    ReeParamName(String paramName) {
        this.paramName = paramName;
    }
}
