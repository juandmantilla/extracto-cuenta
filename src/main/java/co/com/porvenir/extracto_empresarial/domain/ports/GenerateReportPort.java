package co.com.porvenir.extracto_empresarial.domain.ports;

import java.util.Map;

public interface GenerateReportPort {

    byte[] generateReport(String reportName, Map<String, Object> parameters);
}
