package co.com.porvenir.extracto_empresarial.application.dto.models.extract;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class InformacionGrupoEmpresarial {
    @JsonProperty("NIT")
    private String nit;

    @JsonProperty("TOTALAFILIADOS")
    private String totalAfiliados;

    @JsonProperty("TOTALAFILIADOSACT")
    private String totalAfiliadosAct;

    @JsonProperty("TOTALAFILIADOSPRE")
    private String totalAfiliadosPre;

    @JsonProperty("Objetivos")
    private Objetivos objetivos;

    @JsonProperty("AlternativasGrupoEmpre")
    private AlternativasGrupoEmpre alternativasGrupoEmpre;

    @JsonProperty("TotalObjetivos")
    private TotalObjetivos totalObjetivos;
}
