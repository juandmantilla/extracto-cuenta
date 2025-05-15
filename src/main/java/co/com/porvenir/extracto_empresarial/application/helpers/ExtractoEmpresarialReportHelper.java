package co.com.porvenir.extracto_empresarial.application.helpers;

import co.com.porvenir.extracto_empresarial.application.dto.models.ExtractoEmpresarialReportDTO;
import co.com.porvenir.extracto_empresarial.application.dto.models.paramsnames.ReeParamName;
import co.com.porvenir.extracto_empresarial.application.exceptions.PorvenirException;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static co.com.porvenir.extracto_empresarial.application.dto.models.paramsnames.IdeParamName.*;
import static co.com.porvenir.extracto_empresarial.application.dto.models.paramsnames.IggeParamName.*;
import static co.com.porvenir.extracto_empresarial.application.dto.models.paramsnames.MpaParamName.*;
import static co.com.porvenir.extracto_empresarial.application.dto.models.paramsnames.RmpParamName.RMP_COLLECTION_TABLE;
import static co.com.porvenir.extracto_empresarial.application.dto.models.paramsnames.RmpParamName.RMP_SUBREPORT;
import static co.com.porvenir.extracto_empresarial.application.exceptions.responsemessages.ReponseMessage.INTERNAL_SERVER_ERROR;

@Slf4j
public class ExtractoEmpresarialReportHelper {

    private static final String IGGE_SUBREPORT_NAME = "informacion_general_grupo_empresarial";
    private static final String IDE_SUBREPORT_NAME = "informacion_desagregada_por_empresa";
    private static final String MPA_SUBREPORT_NAME = "monto_proceso_de_acreditacion";
    private static final String RMP_SUBREPORT_NAME = "resumen_movimiento_participes_periodo";

    private ExtractoEmpresarialReportHelper() {
    }

    public static Map<String, Object> buildParametersReport(ExtractoEmpresarialReportDTO report) {
        return buildReportParams(report);
    }

    private static Map<String, Object> buildReportParams(ExtractoEmpresarialReportDTO report) {
        var reportParameters = new HashMap<String, Object>();
        buildGeneralParams(reportParameters, report);
        buildIggeParams(reportParameters, report);
        buildIdeParams(reportParameters, report);
        buildMpaParams(reportParameters, report);
        buildRmpParams(reportParameters, report);

        return reportParameters;
    }

    private static void buildGeneralParams(Map<String, Object> params, ExtractoEmpresarialReportDTO report) {

        params.put(ReeParamName.NIT.getParamName(), report.getNit());
        params.put(ReeParamName.PERIODO.getParamName(), report.getPeriodo());
        params.put(ReeParamName.NUMERO_EXTRACTO.getParamName(), report.getNumeroExtracto());
        params.put(ReeParamName.FECHA_EXPEDICION.getParamName(), report.getFechaExpedicion());
        params.put(ReeParamName.DIRECCION.getParamName(), report.getDireccion());
        params.put(ReeParamName.ENTIDAD_PATROCINADORA.getParamName(), report.getEntidadPatrocinadora());
        params.put(ReeParamName.CIUDAD_DEPTO.getParamName(), report.getCiudadDepto());
        params.put(ReeParamName.NIC.getParamName(), report.getNic());
        params.put(ReeParamName.NIT_EMPRESARIAL.getParamName(), report.getNitEmpresarial());
        params.put(ReeParamName.NIT_GRUPO_EMPRESARIAL.getParamName(), report.getNitGrupoEmpresarial());

        params.put(ReeParamName.CONSULTOR_NOMBRE.getParamName(), report.getConsultorNombre());
        params.put(ReeParamName.CONSULTOR_CIUDAD.getParamName(), report.getConsultorCiudad());
        params.put(ReeParamName.CONSULTOR_CELULAR.getParamName(), report.getConsultorCelular());
        params.put(ReeParamName.CONSULTOR_EMAIL.getParamName(), report.getConsultorEmail());

    }

    private static void buildIggeParams(Map<String, Object> params, ExtractoEmpresarialReportDTO report) {

        var jasperSubreport = getSubreport(IGGE_SUBREPORT_NAME);

        params.put(IGGE_NIT_EMPRESARIAL.getParamName(), report.getNitEmpresarial());
        params.put(IGGE_TOTAL_SALDO_ANTERIOR.getParamName(), report.getIggeTotalSaldoAnterior());
        params.put(IGGE_TOTAL_APORTES.getParamName(), report.getIggeTotalAportes());
        params.put(IGGE_TOTAL_RETIROS.getParamName(), report.getIggeTotalRetiros());
        params.put(IGGE_TOTAL_TRASLADOS.getParamName(), report.getIggeTotalTraslados());
        params.put(IGGE_TOTAL_VALORIZACION.getParamName(), report.getIggeTotalValorizacion());
        params.put(IGGE_TOTAL_SALDO_FINAL.getParamName(), report.getIggeTotalSaldoFinal());
        params.put(IGGE_TOTAL_SALDO_RESTRINGIDO.getParamName(), report.getIggeTotalSaldoRestringido());
        params.put(IGGE_TOTAL_COMISION_COBRADA.getParamName(), report.getIggeTotalComisionCobrada());
        params.put(IGGE_NUMERO_PARTICIPES.getParamName(), report.getIggeNumeroParticipes());
        params.put(IGGE_NIT_PLAN.getParamName(), report.getIggeNitPlan());
        params.put(IGGE_NIC.getParamName(), report.getNic());
        params.put(IGGE_ENTIDAD_PATROCINADORA.getParamName(), report.getIggeEntidadPatrocinadora());
        params.put(IGGE_CIUDAD_DEPTO.getParamName(), report.getIggeCiudadDepto());
        params.put(IGGE_DIRECCION.getParamName(), report.getIggeDireccion());

        params.put(IGGE_SUBREPORT_PARAM.getParamName(), jasperSubreport);
        params.put(IGGE_COLLECTION_TABLE.getParamName(), new JRBeanCollectionDataSource((report.getIggeTable())));
    }

    private static void buildIdeParams(Map<String, Object> params, ExtractoEmpresarialReportDTO report) {

        var jasperSubreport = getSubreport(IDE_SUBREPORT_NAME);

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
        params.put(IDE_COLLECTION_TABLE.getParamName(), new JRBeanCollectionDataSource(report.getIdeTable()));
    }

    private static void buildMpaParams(Map<String, Object> params, ExtractoEmpresarialReportDTO report) {

        var jasperSubreport = getSubreport(MPA_SUBREPORT_NAME);

        params.put(MPA_NIT.getParamName(), report.getMpaNit());
        params.put(MPA_MONTO_PROCESO.getParamName(), report.getMpaMontoProceso());
        params.put(MPA_NIT_TOTAL.getParamName(), report.getMpaNitTotal());
        params.put(MPA_TOTAL_MONTO_PROCESO.getParamName(), report.getMpaTotalMontoProceso());
        params.put(MPA_NOMBRE_PLAN_EMPRESARIAL.getParamName(), report.getMpaNombrePlanEmpresarial());

        params.put(MPA_SUBREPORT.getParamName(), jasperSubreport);
        params.put(MPA_COLLECTION_TABLE.getParamName(), new JRBeanCollectionDataSource(report.getMpaTable()));
    }

    private static void buildRmpParams(Map<String, Object> params, ExtractoEmpresarialReportDTO report) {

        var jasperSubreport = getSubreport(RMP_SUBREPORT_NAME);

        params.put(RMP_SUBREPORT.getParamName(), jasperSubreport);
        params.put(RMP_COLLECTION_TABLE.getParamName(), new JRBeanCollectionDataSource(report.getRmpTable()));
    }

    private static JasperReport getSubreport(String subreportName) {
        var subreportFile = new ClassPathResource("reports/" + subreportName + ".jasper");
        try {
            return (JasperReport) JRLoader.loadObject(subreportFile.getInputStream());
        } catch (JRException | IOException e) {
            log.error("Subreport could not be read from classpath");
            throw new PorvenirException(INTERNAL_SERVER_ERROR, e);
        }
    }


}
