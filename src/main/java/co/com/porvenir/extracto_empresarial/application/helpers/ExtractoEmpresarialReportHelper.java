package co.com.porvenir.extracto_empresarial.application.helpers;

import co.com.porvenir.extracto_empresarial.application.dto.models.ExtractoEmpresarialReportDTO;
import co.com.porvenir.extracto_empresarial.application.ports.JasperReportPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static co.com.porvenir.extracto_empresarial.application.helpers.params.IdeParamName.*;
import static co.com.porvenir.extracto_empresarial.application.helpers.params.IggeParamName.*;
import static co.com.porvenir.extracto_empresarial.application.helpers.params.MpaParamName.*;
import static co.com.porvenir.extracto_empresarial.application.helpers.params.ReeParamName.*;
import static co.com.porvenir.extracto_empresarial.application.helpers.params.RmpParamName.RMP_COLLECTION_TABLE;
import static co.com.porvenir.extracto_empresarial.application.helpers.params.RmpParamName.RMP_SUBREPORT;

@Slf4j
@RequiredArgsConstructor
@Component
public class ExtractoEmpresarialReportHelper {

    private static final String IGGE_SUBREPORT_NAME = "informacion_general_grupo_empresarial";
    private static final String IDE_SUBREPORT_NAME = "informacion_desagregada_por_empresa";
    private static final String MPA_SUBREPORT_NAME = "monto_proceso_de_acreditacion";
    private static final String RMP_SUBREPORT_NAME = "resumen_movimiento_participes_periodo";

    private final JasperReportPort jasperPort;

    public Map<String, Object> buildParametersReport(ExtractoEmpresarialReportDTO report) {
        return buildReportParams(report);
    }

    private Map<String, Object> buildReportParams(ExtractoEmpresarialReportDTO report) {
        var reportParameters = new HashMap<String, Object>();

        buildGeneralParams(reportParameters, report);
        buildIggeParams(reportParameters, report);
        buildIdeParams(reportParameters, report);
        buildMpaParams(reportParameters, report);
        buildRmpParams(reportParameters, report);
        return reportParameters;
    }

    private void buildGeneralParams(Map<String, Object> params, ExtractoEmpresarialReportDTO report) {

        params.put(PERIODO.getParamName(), report.getPeriodo());
        params.put(NUMERO_EXTRACTO.getParamName(), report.getNumeroExtracto());
        params.put(FECHA_EXPEDICION.getParamName(), report.getFechaExpedicion());

        params.put(CONSULTOR_NOMBRE.getParamName(), report.getConsultorNombre());
        params.put(CONSULTOR_CIUDAD.getParamName(), report.getConsultorCiudad());
        params.put(CONSULTOR_CELULAR.getParamName(), report.getConsultorCelular());
        params.put(CONSULTOR_EMAIL.getParamName(), report.getConsultorEmail());
    }

    private void buildIggeParams(Map<String, Object> params, ExtractoEmpresarialReportDTO report) {

        var jasperSubreport = jasperPort.getSubreport(IGGE_SUBREPORT_NAME);


        params.put(IGGE_NIT_PLAN.getParamName(), report.getIggeNitPlan());
        params.put(IGGE_DIRECCION.getParamName(), report.getIggeDireccion());
        params.put(IGGE_NIC.getParamName(), report.getIggeNic());
        params.put(IGGE_ENTIDAD_PATROCINADORA.getParamName(), report.getIggeEntidadPatrocinadora());
        params.put(IGGE_CIUDAD_DEPTO.getParamName(), report.getIggeCiudadDepto());

        params.put(IGGE_NIT_EMPRESARIAL.getParamName(), report.getIggeNitEmpresarial());

        params.put(IGGE_TOTAL_SALDO_ANTERIOR.getParamName(), report.getIggeTotalSaldoAnterior());
        params.put(IGGE_TOTAL_APORTES.getParamName(), report.getIggeTotalAportes());
        params.put(IGGE_TOTAL_RETIROS.getParamName(), report.getIggeTotalRetiros());
        params.put(IGGE_TOTAL_TRASLADOS.getParamName(), report.getIggeTotalTraslados());
        params.put(IGGE_TOTAL_VALORIZACION.getParamName(), report.getIggeTotalValorizacion());
        params.put(IGGE_TOTAL_SALDO_FINAL.getParamName(), report.getIggeTotalSaldoFinal());
        params.put(IGGE_TOTAL_SALDO_RESTRINGIDO.getParamName(), report.getIggeTotalSaldoRestringido());
        params.put(IGGE_TOTAL_COMISION_COBRADA.getParamName(), report.getIggeTotalComisionCobrada());
        params.put(IGGE_NUMERO_PARTICIPES.getParamName(), report.getIggeNumeroParticipes());

        params.put(IGGE_SUBREPORT.getParamName(), jasperSubreport);
        params.put(IGGE_COLLECTION_TABLE.getParamName(), report.getIggeTable());
    }

    private void buildIdeParams(Map<String, Object> params, ExtractoEmpresarialReportDTO report) {

        var jasperSubreport = jasperPort.getSubreport(IDE_SUBREPORT_NAME);

        params.put(IDE_APORTES.getParamName(), report.getIdeAportes());
        params.put(IDE_RETIROS.getParamName(), report.getIdeRetiros());
        params.put(IDE_TRASLADOS_PORTAFOLIOS.getParamName(), report.getIdeTrasladosPortafolios());
        params.put(IDE_VALORIZACION.getParamName(), report.getIdeValorizacion());
        params.put(IDE_SALDO_FINAL.getParamName(), report.getIdeSaldoFinal());
        params.put(IDE_SALDO_RESTRINGIDO.getParamName(), report.getIdeSaldoRestringido());
        params.put(IDE_COMISION_COBRADA.getParamName(), report.getIdeComisionCobrada());
        params.put(IDE_PLAN.getParamName(), report.getIdePlan());
        params.put(IDE_FONDO.getParamName(), report.getIdeFondo());
        params.put(IDE_RENTA_ACUMULADA.getParamName(), report.getIdeRentaAcumulada());
        params.put(IDE_SALDO_ANTERIOR.getParamName(), report.getIdeSaldoAnterior());
        params.put(IDE_SUBREPORT.getParamName(), jasperSubreport);
        params.put(IDE_COLLECTION_TABLE.getParamName(), report.getIdeTable());
    }

    private void buildMpaParams(Map<String, Object> params, ExtractoEmpresarialReportDTO report) {

        var jasperSubreport = jasperPort.getSubreport(MPA_SUBREPORT_NAME);

        params.put(MPA_NIT.getParamName(), report.getMpaNit());
        params.put(MPA_MONTO_PROCESO.getParamName(), report.getMpaMontoProceso());
        params.put(MPA_NIT_TOTAL.getParamName(), report.getMpaNitTotal());
        params.put(MPA_TOTAL_MONTO_PROCESO.getParamName(), report.getMpaTotalMontoProceso());
        params.put(MPA_NOMBRE_PLAN_EMPRESARIAL.getParamName(), report.getMpaNombrePlanEmpresarial());
        params.put(MPA_SUBREPORT.getParamName(), jasperSubreport);
        params.put(MPA_COLLECTION_TABLE.getParamName(), report.getMpaTable());
    }

    private void buildRmpParams(Map<String, Object> params, ExtractoEmpresarialReportDTO report) {
        var jasperSubreport = jasperPort.getSubreport(RMP_SUBREPORT_NAME);
        params.put(RMP_SUBREPORT.getParamName(), jasperSubreport);
        params.put(RMP_COLLECTION_TABLE.getParamName(), report.getRmpTable());
    }

}
