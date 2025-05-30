package co.com.porvenir.extracto_empresarial.application.ports;

import net.sf.jasperreports.engine.JasperReport;

import java.util.Map;

public interface JasperReportPort {

    byte[] generateReport(String reportName, Map<String, Object> parameters);

    JasperReport getSubreport(String subreportName);
}
