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


        var extracto = new ExtractoEmpresarialReportDTO();

        // Datos básicos
        extracto.setNit("900123456-7");
        extracto.setPeriodo("2023-12");
        extracto.setNumeroExtracto("EXT-2023-12-001");
        extracto.setFechaExpedicion("15/01/2024");
        extracto.setDireccion("Calle 123 #45-67");
        extracto.setEntidadPatrocinadora("Empresa Ejemplo S.A.");
        extracto.setCiudadDepto("Bogotá D.C.");
        extracto.setNic("NIC123456");
        extracto.setNitEmpresarial("800987654-1");
        extracto.setNitGrupoEmpresarial("800987654-1");

        // Información General del Grupo Empresarial (IGGE)
        extracto.setIggeNitEmpresarial("800987654-1");
        extracto.setIggeTotalSaldoAnterior("1,250,000,000.00");
        extracto.setIggeTotalAportes("250,000,000.00");
        extracto.setIggeTotalRetiros("50,000,000.00");
        extracto.setIggeTotalTraslados("100,000,000.00");
        extracto.setIggeTotalValorizacion("75,000,000.00");
        extracto.setIggeTotalSaldoFinal("1,425,000,000.00");
        extracto.setIggeTotalSaldoRestringido("125,000,000.00");
        extracto.setIggeTotalComisionCobrada("5,250,000.00");
        extracto.setIggeNumeroParticipes("1,250");
        extracto.setIggeNitPlan("PLN202312345");
        extracto.setIggeNic("NIC123456");
        extracto.setIggeEntidadPatrocinadora("Empresa Ejemplo S.A.");
        extracto.setIggeCiudadDepto("Bogotá D.C.");
        extracto.setIggeDireccion("Transversal 66 ");

// Tabla IGGE
        List<IggeTableDTO> iggeTable = new ArrayList<>();
        IggeTableDTO igge1 = new IggeTableDTO();
        igge1.setObjetivoPlanEmpresarial("Fondo Pensiones");
        igge1.setSaldoAnterior("750,000,000.00");
        igge1.setAportes("150,000,000.00");
        igge1.setRetiros("25,000,000.00");
        igge1.setTrasladoEntreObjetivos("50,000,000.00");
        igge1.setValorizacion("45,000,000.00");
        igge1.setSaldoFinal("870,000,000.00");
        igge1.setSaldoRestringido("75,000,000.00");
        igge1.setComisionCobrada("3,150,000.00");
        iggeTable.add(igge1);

        IggeTableDTO igge2 = new IggeTableDTO();
        igge2.setObjetivoPlanEmpresarial("Fondo Cesantías");
        igge2.setSaldoAnterior("500,000,000.00");
        igge2.setAportes("100,000,000.00");
        igge2.setRetiros("25,000,000.00");
        igge2.setTrasladoEntreObjetivos("50,000,000.00");
        igge2.setValorizacion("30,000,000.00");
        igge2.setSaldoFinal("555,000,000.00");
        igge2.setSaldoRestringido("50,000,000.00");
        igge2.setComisionCobrada("2,100,000.00");
        igge2.setComisionCobrada("2,100,000.00");
        iggeTable.add(igge2);

        extracto.setIggeTable(iggeTable);

// Información Desagregada por Empresa (IDE)
        extracto.setIdeAportes("250,000,000.00");
        extracto.setIdeRetiros("50,000,000.00");
        extracto.setIdeTrasladosPortafolios("100,000,000.00");
        extracto.setIdeValorizacion("75,000,000.00");
        extracto.setIdeSaldoFinal("1,425,000,000.00");
        extracto.setIdeSaldoRestringido("125,000,000.00");
        extracto.setIdeComisionCobrada("5,250,000.00");
        extracto.setIdePlan("8.27");
        extracto.setIdeFondo("N/A");
        extracto.setIdeRentaAcumulada("8.75%");

// Tabla IDE
        List<IdeTableDTO> ideTable = new ArrayList<>();
        IdeTableDTO ide1 = new IdeTableDTO();
        ide1.setPortafolioInversion("Renta Fija");
        ide1.setSaldoAnterior("600,000,000.00");
        ide1.setAportes("120,000,000.00");
        ide1.setRetiros("20,000,000.00");
        ide1.setTrasladosEntrePortafolios("40,000,000.00");
        ide1.setValorizacion("36,000,000.00");
        ide1.setSaldoFinal("696,000,000.00");
        ide1.setSaldoRestringido("60,000,000.00");
        ide1.setComisionCobrada("2,520,000.00");
        ide1.setRentPeriodoPlan("5.8%");
        ide1.setRentPeriodoFondo("6.0%");
        ide1.setRentAcumuladaFondo("7.2%");
        ideTable.add(ide1);

        IdeTableDTO ide2 = new IdeTableDTO();
        ide2.setPortafolioInversion("Renta Variable");
        ide2.setSaldoAnterior("400,000,000.00");
        ide2.setAportes("80,000,000.00");
        ide2.setRetiros("15,000,000.00");
        ide2.setTrasladosEntrePortafolios("30,000,000.00");
        ide2.setValorizacion("24,000,000.00");
        ide2.setSaldoFinal("459,000,000.00");
        ide2.setSaldoRestringido("40,000,000.00");
        ide2.setComisionCobrada("1,890,000.00");
        ide2.setRentPeriodoPlan("6.0%");
        ide2.setRentPeriodoFondo("6.2%");
        ide2.setRentAcumuladaFondo("9.5%");
        ideTable.add(ide2);

        IdeTableDTO ide3 = new IdeTableDTO();
        ide3.setPortafolioInversion("Renta Variable");
        ide3.setSaldoAnterior("7700,000,000.00");
        ide3.setAportes("34,000,000.00");
        ide3.setRetiros("112,000,000.00");
        ide3.setTrasladosEntrePortafolios("677,000,000.00");
        ide3.setValorizacion("215,000,000.00");
        ide3.setSaldoFinal("997,000,000.00");
        ide3.setSaldoRestringido("1212,000,000.00");
        ide3.setComisionCobrada("123,890,000.00");
        ide3.setRentPeriodoPlan("7.0%");
        ide3.setRentPeriodoFondo("8.2%");
        ide3.setRentAcumuladaFondo("9.0%");
        ideTable.add(ide3);

        extracto.setIdeTable(ideTable);

// Monto Proceso de Acreditación (MPA)
        extracto.setMpaNit("900123456-7");
        extracto.setMpaMontoProceso("150,000,000.00");
        extracto.setMpaNitTotal("800987654-1");
        extracto.setMpaTotalMontoProceso("250,000,000.00");
        extracto.setMpaNombrePlanEmpresarial("Plan Empresarial Premium");

// Tabla MPA
        List<MpaTableDTO> mpaTable = new ArrayList<>();
        MpaTableDTO mpa1 = new MpaTableDTO();
        mpa1.setCodigoObjetivo("OBJ-001");
        mpa1.setNombreObjetivo("Fondo Pensiones");
        mpa1.setTipoAporte("Obligatorio");
        mpa1.setRealizaAporte("Sí");
        mpa1.setAporteTieneCondicion("No");
        mpa1.setMontAporteTipoValor("Porcentaje");
        mpa1.setMontAporteValor("12%");
        mpa1.setPeriodicidad("Mensual");
        mpa1.setPermiteRetiros("Sí");
        mpa1.setReqAutorizacionRetiros("No");
        mpa1.setPermiteTrasladoPortafolios("Sí");
        mpa1.setPermiteBloqueoEntidades("No");
        mpa1.setCodigoObjetivo("9123012");
        mpaTable.add(mpa1);

        MpaTableDTO mpa2 = new MpaTableDTO();
        mpa2.setCodigoObjetivo("OBJ-002");
        mpa2.setNombreObjetivo("Fondo Cesantías");
        mpa2.setTipoAporte("Obligatorio");
        mpa2.setRealizaAporte("Sí");
        mpa2.setAporteTieneCondicion("No");
        mpa2.setMontAporteTipoValor("Porcentaje");
        mpa2.setMontAporteValor("8.33%");
        mpa2.setPeriodicidad("Mensual");
        mpa2.setPermiteRetiros("Condicionado");
        mpa2.setReqAutorizacionRetiros("Sí");
        mpa2.setPermiteTrasladoPortafolios("No");
        mpa2.setPermiteBloqueoEntidades("Sí");
        mpa2.setCodigoObjetivo("151342");
        mpaTable.add(mpa2);

        extracto.setMpaTable(mpaTable);

// Tabla RMPP (Resumen Movimiento Partícipes Periodo)
        List<RmppTableDTO> rmpTable = new ArrayList<>();
        RmppTableDTO rmp1 = new RmppTableDTO();
        rmp1.setCuentaNumero("CTE-10001");
        rmp1.setNombreParticipe("Juan Pérez");
        rmp1.setObjetivo("Fondo Pensiones");
        rmp1.setSaldoInicial("6,000,000.00");
        rmp1.setAportes("720,000.00");
        rmp1.setRetiros("0.00");
        rmp1.setTrasladosObjetivos("0.00");
        rmp1.setSaldoFinal("6,720,000.00");
        rmpTable.add(rmp1);

        RmppTableDTO rmp2 = new RmppTableDTO();
        rmp2.setCuentaNumero("CTE-10002");
        rmp2.setNombreParticipe("María Gómez");
        rmp2.setObjetivo("Fondo Cesantías");
        rmp2.setSaldoInicial("5,000,000.00");
        rmp2.setAportes("416,500.00");
        rmp2.setRetiros("0.00");
        rmp2.setTrasladosObjetivos("0.00");
        rmp2.setSaldoFinal("5,416,500.00");
        rmpTable.add(rmp2);

        extracto.setRmpTable(rmpTable);

// Datos del consultor
        extracto.setConsultorNombre("Carlos Andrés López");
        extracto.setConsultorCiudad("Bogotá D.C.");
        extracto.setConsultorCelular("+57 310 123 4567");
        extracto.setConsultorEmail("consultor@porvenir.com.co");

        var reportParamsFilled = ExtractoEmpresarialReportHelper.buildParametersReport(extracto);

        return generatePdfReport.generateReport(REPORT_NAME, reportParamsFilled);
    }

}
