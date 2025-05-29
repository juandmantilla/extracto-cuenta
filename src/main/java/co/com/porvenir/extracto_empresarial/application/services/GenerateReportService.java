package co.com.porvenir.extracto_empresarial.application.services;

import co.com.porvenir.extracto_empresarial.adapters.in.web.dto.request.ExtractoEmpresarialRequestDto;
import co.com.porvenir.extracto_empresarial.adapters.out.pdf.JasperReportsGeneratorAdapter;
import co.com.porvenir.extracto_empresarial.application.dto.models.extract.Extracto;
import co.com.porvenir.extracto_empresarial.application.helpers.ExtractoEmpresarialReportHelper;
import co.com.porvenir.extracto_empresarial.application.mappers.ExtractoMapper;
import co.com.porvenir.extracto_empresarial.application.ports.GenerateReportUseCase;
import co.com.porvenir.extracto_empresarial.configurations.WebClientConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@RequiredArgsConstructor
@Service
public class GenerateReportService implements GenerateReportUseCase {

    private static final String REPORT_NAME = "Reporte_Extractos_Empresariales";
    private static final String XML_RESOURCE = "/xmlFromBusinessAccountQuery";

    private final WebClientConfig webClient;

    @Override
    public byte[] generateReport(ExtractoEmpresarialRequestDto request) {
        var reportParams = ExtractoMapper.mapper(callXmlConsumer());
        var reportParamsFilled = ExtractoEmpresarialReportHelper.buildParametersReport(reportParams);
        return JasperReportsGeneratorAdapter.generateReport(REPORT_NAME, reportParamsFilled);
    }

    public Extracto callXmlConsumer() {
        return webClient.webClient(WebClient.builder())
                .post()
                .uri(XML_RESOURCE)
                .retrieve()
                .bodyToMono(Extracto.class)
                .block();
    }

}
