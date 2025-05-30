package co.com.porvenir.extracto_empresarial.application.helpers;

import co.com.porvenir.extracto_empresarial.application.dto.models.*;
import co.com.porvenir.extracto_empresarial.application.ports.JasperReportPort;
import net.sf.jasperreports.engine.JasperReport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExtractoEmpresarialReportHelperTest {
    @Mock
    private JasperReportPort jasperReportPort;

    private ExtractoEmpresarialReportHelper helper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        helper = new ExtractoEmpresarialReportHelper(jasperReportPort);
    }

    @Test
    void testBuildParametersReport_shouldReturnExpectedMap() {
        ExtractoEmpresarialReportDTO dto = new ExtractoEmpresarialReportDTO();
        dto.setPeriodo("2024-Q4");
        dto.setNumeroExtracto("EX-2024-01");
        dto.setFechaExpedicion("2025-01-28");
        dto.setConsultorNombre("Daniel");
        dto.setConsultorCiudad("Bogotá");
        dto.setConsultorCelular("1234567890");
        dto.setConsultorEmail("daniel@porvenir.com");

        dto.setIggeNitPlan("NITPLAN123");
        dto.setIggeDireccion("Calle Falsa 123");
        dto.setIggeNic("NIC001");
        dto.setIggeEntidadPatrocinadora("Entidad X");
        dto.setIggeCiudadDepto("Bogotá D.C.");
        dto.setIggeNitEmpresarial("800251163");
        dto.setIggeTotalSaldoAnterior("1000");
        dto.setIggeTotalAportes("200");
        dto.setIggeTotalRetiros("50");
        dto.setIggeTotalTraslados("30");
        dto.setIggeTotalValorizacion("20");
        dto.setIggeTotalSaldoFinal("1200");
        dto.setIggeTotalSaldoRestringido("100");
        dto.setIggeTotalComisionCobrada("10");
        dto.setIggeNumeroParticipes("5");
        dto.setIggeTable(List.of(new IggeTableDTO()));

        dto.setIdeAportes("150");
        dto.setIdeRetiros("60");
        dto.setIdeTrasladosPortafolios("40");
        dto.setIdeValorizacion("25");
        dto.setIdeSaldoFinal("1250");
        dto.setIdeSaldoRestringido("80");
        dto.setIdeComisionCobrada("15");
        dto.setIdePlan("Plan A");
        dto.setIdeFondo("Fondo B");
        dto.setIdeRentaAcumulada("10");
        dto.setIdeSaldoAnterior("1000");
        dto.setIdeTable(List.of(new IdeTableDTO()));

        dto.setMpaNit("MPA123");
        dto.setMpaMontoProceso("500");
        dto.setMpaNitTotal("TOTAL123");
        dto.setMpaTotalMontoProceso("5000");
        dto.setMpaNombrePlanEmpresarial("Plan Empresarial X");
        dto.setMpaTable(List.of(new MpaTableDTO()));

        dto.setRmpTable(List.of(new RmpTableDTO()));

        var jasperMock = mock(JasperReport.class);
        when(jasperReportPort.getSubreport(anyString())).thenReturn(jasperMock);

        Map<String, Object> params = helper.buildParametersReport(dto);

        assertNotNull(params);
        assertEquals("2024-Q4", params.get("periodo"));
        assertEquals("EX-2024-01", params.get("numero_extracto"));
        assertEquals("2025-01-28", params.get("fecha_expedicion"));
        assertEquals("Daniel", params.get("consultor_nombre"));
        assertEquals("Bogotá", params.get("consultor_ciudad"));
        assertEquals("1234567890", params.get("consultor_celular"));
        assertEquals("daniel@porvenir.com", params.get("consultor_email"));

        verify(jasperReportPort, times(4)).getSubreport(anyString());
    }
}