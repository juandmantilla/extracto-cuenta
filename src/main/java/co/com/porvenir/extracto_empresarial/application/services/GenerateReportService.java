package co.com.porvenir.extracto_empresarial.application.services;

import co.com.porvenir.extracto_empresarial.adapters.in.web.dto.request.ExtractoEmpresarialRequestDto;
import co.com.porvenir.extracto_empresarial.application.dto.models.*;
import co.com.porvenir.extracto_empresarial.application.helpers.ExtractoEmpresarialReportHelper;
import co.com.porvenir.extracto_empresarial.application.ports.GenerateReportUseCase;
import co.com.porvenir.extracto_empresarial.domain.ports.GenerateReportPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class GenerateReportService implements GenerateReportUseCase {

    private static final String REPORT_NAME = "Reporte_Extractos_Empresariales";
    private final GenerateReportPort generatePdfReport;

    @Override
    public byte[] generateReport(ExtractoEmpresarialRequestDto request) {


        ExtractoEmpresarialReportDTO extracto = new ExtractoEmpresarialReportDTO();

        // Datos generales del extracto
        extracto.setNit("900123456-7");
        extracto.setPeriodo("Enero - Marzo 2025");
        extracto.setNumeroExtracto("EXT-2025-1234");
        extracto.setFechaExpedicion("15/04/2025");
        extracto.setDireccion("Av. Empresarial #123-45, Piso 10");
        extracto.setEntidadPatrocinadora("Inversiones Corporativas S.A.");
        extracto.setCiudadDepto("Bogotá D.C.");
        extracto.setNic("NIC12345");
        extracto.setNitEmpresarial("900123456-7");
        extracto.setNitGrupoEmpresarial("800987654-3");

        // Información General del Grupo Empresarial (IGGE)
        extracto.setIggeNitEmpresarial("800987654-3");
        extracto.setIggeTotalSaldoAnterior("$1,250,000,000");
        extracto.setIggeTotalAportes("$350,000,000");
        extracto.setIggeTotalRetiros("$75,000,000");
        extracto.setIggeTotalTraslados("$120,000,000");
        extracto.setIggeTotalValorizacion("$85,000,000");
        extracto.setIggeTotalSaldoFinal("$1,610,000,000");
        extracto.setIggeTotalSaldoRestringido("$200,000,000");
        extracto.setIggeTotalComisionCobrada("$12,000,000");
        extracto.setIggeNumeroParticipes("45");
        extracto.setIggeNitPlan("900456789-1");
        extracto.setIggeNic("NIC12345");
        extracto.setIggeEntidadPatrocinadora("Inversiones Corporativas S.A.");
        extracto.setIggeCiudadDepto("Bogotá D.C.");
        extracto.setIggeDireccion("Av. Empresarial #123-45, Piso 10");

        // Tabla IGGE
        List<IggeTableDTO> iggeTabla = new ArrayList<>();

        IggeTableDTO igge1 = new IggeTableDTO();
        igge1.setObjetivoPlanEmpresarial("Jubilación");
        igge1.setSaldoAnterior("$800,000,000");
        igge1.setAportes("$200,000,000");
        igge1.setRetiros("$50,000,000");
        igge1.setTrasladoEntreObjetivos("$70,000,000");
        igge1.setValorizacion("$45,000,000");
        igge1.setSaldoFinal("$995,000,000");
        igge1.setSaldoRestringido("$120,000,000");
        igge1.setComisionCobrada("$7,500,000");
        iggeTabla.add(igge1);

        IggeTableDTO igge2 = new IggeTableDTO();
        igge2.setObjetivoPlanEmpresarial("Educación");
        igge2.setSaldoAnterior("$450,000,000");
        igge2.setAportes("$150,000,000");
        igge2.setRetiros("$25,000,000");
        igge2.setTrasladoEntreObjetivos("$50,000,000");
        igge2.setValorizacion("$40,000,000");
        igge2.setSaldoFinal("$615,000,000");
        igge2.setSaldoRestringido("$80,000,000");
        igge2.setComisionCobrada("$4,500,000");
        iggeTabla.add(igge2);

        extracto.setIggeTable(iggeTabla);

        // Información Desagregada por Empresa (IDE)
        extracto.setIdeSaldoAnterior("$777,000,000");
        extracto.setIdeAportes("$350,000,000");
        extracto.setIdeRetiros("$75,000,000");
        extracto.setIdeTrasladosPortafolios("$30,000,000");
        extracto.setIdeValorizacion("$85,000,000");
        extracto.setIdeSaldoFinal("$1,610,000,000");
        extracto.setIdeSaldoRestringido("$200,000,000");
        extracto.setIdeComisionCobrada("$12,000,000");
        extracto.setIdePlan("Plan Corporativo Elite");
        extracto.setIdeFondo("Fondo Empresarial Diversificado");
        extracto.setIdeRentaAcumulada("8.4%");

        // Tabla IDE
        List<IdeTableDTO> ideTabla = new ArrayList<>();

        IdeTableDTO ide1 = new IdeTableDTO();
        ide1.setPortafolioInversion("Renta Fija Corporativa");
        ide1.setSaldoAnterior("$500,000,000");
        ide1.setAportes("$150,000,000");
        ide1.setRetiros("$30,000,000");
        ide1.setTrasladosEntrePortafolios("$20,000,000");
        ide1.setValorizacion("$35,000,000");
        ide1.setSaldoFinal("$635,000,000");
        ide1.setSaldoRestringido("$80,000,000");
        ide1.setComisionCobrada("$4,800,000");
        ide1.setRentPeriodoPlan("2.1%");
        ide1.setRentPeriodoFondo("2.3%");
        ide1.setRentAcumuladaFondo("7.8%");
        ideTabla.add(ide1);

        IdeTableDTO ide2 = new IdeTableDTO();
        ide2.setPortafolioInversion("Renta Variable");
        ide2.setSaldoAnterior("$750,000,000");
        ide2.setAportes("$200,000,000");
        ide2.setRetiros("$45,000,000");
        ide2.setTrasladosEntrePortafolios("$10,000,000");
        ide2.setValorizacion("$50,000,000");
        ide2.setSaldoFinal("$975,000,000");
        ide2.setSaldoRestringido("$120,000,000");
        ide2.setComisionCobrada("$7,200,000");
        ide2.setRentPeriodoPlan("2.4%");
        ide2.setRentPeriodoFondo("2.5%");
        ide2.setRentAcumuladaFondo("9.2%");
        ideTabla.add(ide2);

        extracto.setIdeTable(ideTabla);

        // Monto Proceso de Acreditación (MPA)
        extracto.setMpaNit("900123456-7");
        extracto.setMpaMontoProceso("$350,000,000");
        extracto.setMpaNitTotal("800987654-3");
        extracto.setMpaTotalMontoProceso("$350,000,000");
        extracto.setMpaNombrePlanEmpresarial("Plan Corporativo Elite");

        // Tabla MPA
        List<MpaTableDTO> mpaTabla = new ArrayList<>();

        MpaTableDTO mpa1 = new MpaTableDTO();
        mpa1.setCodigoObjetivo("OBJ-001");
        mpa1.setNombreObjetivo("Jubilación");
        mpa1.setTipoAporte("Obligatorio");
        mpa1.setRealizaAporte("Empleador");
        mpa1.setAporteTieneCondicion("Sí");
        mpa1.setMontAporteTipoValor("Porcentaje");
        mpa1.setMontAporteValor("5%");
        mpa1.setPeriodicidad("Mensual");
        mpa1.setPermiteRetiros("No");
        mpa1.setReqAutorizacionRetiros("Sí");
        mpa1.setPermiteTrasladoPortafolios("Sí");
        mpa1.setPermiteBloqueoEntidades("No");
        mpaTabla.add(mpa1);

        MpaTableDTO mpa2 = new MpaTableDTO();
        mpa2.setCodigoObjetivo("OBJ-002");
        mpa2.setNombreObjetivo("Educación");
        mpa2.setTipoAporte("Voluntario");
        mpa2.setRealizaAporte("Empleado");
        mpa2.setAporteTieneCondicion("No");
        mpa2.setMontAporteTipoValor("Fijo");
        mpa2.setMontAporteValor("$500,000");
        mpa2.setPeriodicidad("Trimestral");
        mpa2.setPermiteRetiros("Sí");
        mpa2.setReqAutorizacionRetiros("No");
        mpa2.setPermiteTrasladoPortafolios("Sí");
        mpa2.setPermiteBloqueoEntidades("No");
        mpaTabla.add(mpa2);

        extracto.setMpaTable(mpaTabla);

        // Resumen Movimiento Partícipes Periodo (RMPP)
        List<RmpTableDTO> rmppTabla = new ArrayList<>();

        RmpTableDTO rmpp1 = new RmpTableDTO();
        rmpp1.setCuentaNumero("CTA-001234");
        rmpp1.setNombreParticipe("Juan Pérez Gómez");
        rmpp1.setObjetivo("Jubilación");
        rmpp1.setSaldoInicial("$35,000,000");
        rmpp1.setAportes("$5,000,000");
        rmpp1.setRetiros("$0");
        rmpp1.setTrasladosObjetivos("$2,000,000");
        rmpp1.setSaldoFinal("$42,000,000");
        rmppTabla.add(rmpp1);

        RmpTableDTO rmpp2 = new RmpTableDTO();
        rmpp2.setCuentaNumero("CTA-002345");
        rmpp2.setNombreParticipe("María López Rodríguez");
        rmpp2.setObjetivo("Educación");
        rmpp2.setSaldoInicial("$28,000,000");
        rmpp2.setAportes("$4,000,000");
        rmpp2.setRetiros("$1,500,000");
        rmpp2.setTrasladosObjetivos("$0");
        rmpp2.setSaldoFinal("$30,500,000");
        rmppTabla.add(rmpp2);

        RmpTableDTO rmpp3 = new RmpTableDTO();
        rmpp3.setCuentaNumero("CTA-003456");
        rmpp3.setNombreParticipe("Carlos Martínez Díaz");
        rmpp3.setObjetivo("Jubilación");
        rmpp3.setSaldoInicial("$42,500,000");
        rmpp3.setAportes("$6,000,000");
        rmpp3.setRetiros("$2,000,000");
        rmpp3.setTrasladosObjetivos("$1,500,000");
        rmpp3.setSaldoFinal("$48,000,000");
        rmppTabla.add(rmpp3);

        extracto.setRmpTable(rmppTabla);

        // Información del consultor
        extracto.setConsultorNombre("Andrea Ramírez Suárez");
        extracto.setConsultorCiudad("Bogotá D.C.");
        extracto.setConsultorCelular("315-678-9012");
        extracto.setConsultorEmail("andrea.ramirez@inversionescorp.com");

        var reportParamsFilled = ExtractoEmpresarialReportHelper.buildParametersReport(extracto);

        return generatePdfReport.generateReport(REPORT_NAME, reportParamsFilled);
    }

}
