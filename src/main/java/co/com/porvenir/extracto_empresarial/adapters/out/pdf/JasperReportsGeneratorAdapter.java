package co.com.porvenir.extracto_empresarial.adapters.out.pdf;

import co.com.porvenir.extracto_empresarial.application.exceptions.PorvenirException;
import co.com.porvenir.extracto_empresarial.application.exceptions.errors.ErrorMessages;
import co.com.porvenir.extracto_empresarial.domain.ports.GenerateReportPort;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Map;

@Slf4j
public class JasperReportsGeneratorAdapter implements GenerateReportPort {


    @Override
    public byte[] generateReport(String reportName, Map<String, Object> parameters) {

        var reportBuilded = new ClassPathResource("reports/" + reportName + ".jasper");

        try {
            JasperReport reportEmpty = (JasperReport) JRLoader.loadObject(reportBuilded.getInputStream());
            JasperPrint reportFilled = JasperFillManager.fillReport(reportEmpty, parameters);

            return JasperExportManager.exportReportToPdf(reportFilled);
        } catch (IOException ioException) {
            log.error("Error when trying to generate the report");
            throw new PorvenirException(ErrorMessages.ERROR_LOADING_FILE_REPORT, ioException);
        } catch (JRException jrException) {
            log.error("Error when trying to fill the report");
            throw new PorvenirException(ErrorMessages.ERROR_FILL_REPORT, jrException);
        }


    }

}
