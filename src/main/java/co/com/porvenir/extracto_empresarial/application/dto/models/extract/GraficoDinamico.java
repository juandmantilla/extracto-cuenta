package co.com.porvenir.extracto_empresarial.application.dto.models.extract;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class GraficoDinamico {
    @JsonProperty("Nombre")
    private String nombre;

    @JsonProperty("Formato")
    private String formato;

    @JsonProperty("Tipo")
    private String tipo;

    @JsonProperty("Alto")
    private String alto;

    @JsonProperty("Ancho")
    private String ancho;

    @JsonProperty("GrosorBorde")
    private String grosorBorde;

    @JsonProperty("Dato")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<Dato> dato;
}

