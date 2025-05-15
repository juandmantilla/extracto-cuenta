package co.com.porvenir.extracto_empresarial.application.dto.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ExtractoEmpresarialReportDTO {

    private String nit;
    private String periodo;
    private String numeroExtracto;
    private String fechaExpedicion;
    private String direccion;
    private String entidadPatrocinadora;
    private String ciudadDepto;
    private String nic;
    private String nitEmpresarial;
    private String nitGrupoEmpresarial;

    private String iggeNitEmpresarial;
    private String iggeTotalSaldoAnterior;
    private String iggeTotalAportes;
    private String iggeTotalRetiros;
    private String iggeTotalTraslados;
    private String iggeTotalValorizacion;
    private String iggeTotalSaldoFinal;
    private String iggeTotalSaldoRestringido;
    private String iggeTotalComisionCobrada;
    private String iggeNumeroParticipes;
    private String iggeNitPlan;
    private String iggeNic;
    private String iggeEntidadPatrocinadora;
    private String iggeCiudadDepto;
    private String iggeDireccion;
    private List<IggeTableDTO> iggeTable;


    private String ideAportes;
    private String ideRetiros;
    private String ideTrasladosPortafolios;
    private String ideValorizacion;
    private String ideSaldoFinal;
    private String ideSaldoRestringido;
    private String ideComisionCobrada;
    private String idePlan;
    private String ideFondo;
    private String ideRentaAcumulada;
    private List<IdeTableDTO> ideTable;

    private String mpaNit;
    private String mpaMontoProceso;
    private String mpaNitTotal;
    private String mpaTotalMontoProceso;
    private String mpaNombrePlanEmpresarial;
    private List<MpaTableDTO> mpaTable;

    private List<RmppTableDTO> rmpTable;

    private String consultorNombre;
    private String consultorCiudad;
    private String consultorCelular;
    private String consultorEmail;
}
