package co.com.porvenir.extracto_empresarial.adapters.out.pdf;

import co.com.porvenir.extracto_empresarial.application.exceptions.PorvenirException;
import co.com.porvenir.extracto_empresarial.application.exceptions.response.messages.ReponseMessage;
import co.com.porvenir.extracto_empresarial.application.ports.JasperReportPort;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

import static co.com.porvenir.extracto_empresarial.application.exceptions.response.messages.ReponseMessage.INTERNAL_SERVER_ERROR;

@Slf4j
@Component
public class JasperReportsAdapter implements JasperReportPort {

    
    public byte[] generateReport(String reportName, Map<String, Object> parameters) {

        var reportBuilded = new ClassPathResource("reports/" + reportName + ".jasper");

        try {
            JasperReport reportEmpty = (JasperReport) JRLoader.loadObject(reportBuilded.getInputStream());
            var reportFilled = JasperFillManager.fillReport(reportEmpty, parameters, new JREmptyDataSource());
            return JasperExportManager.exportReportToPdf(reportFilled);
        } catch (JRException | IOException e) {
            log.error("Error when trying to generate the report");
            throw new PorvenirException(ReponseMessage.INTERNAL_SERVER_ERROR, e);
        }
    }

    public JasperReport getSubreport(String subreportName) {
        var subreportFile = new ClassPathResource("reports/" + subreportName + ".jasper");
        try {
            return (JasperReport) JRLoader.loadObject(subreportFile.getInputStream());
        } catch (JRException | IOException e) {
            log.error("Subreport could not be read from classpath");
            throw new PorvenirException(INTERNAL_SERVER_ERROR, e);
        }
    }


}
