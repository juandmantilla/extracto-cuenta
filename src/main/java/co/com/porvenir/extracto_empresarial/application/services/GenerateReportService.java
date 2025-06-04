package co.com.porvenir.extracto_empresarial.application.services;

import co.com.porvenir.extracto_empresarial.adapters.in.web.dto.request.ExtractoRequestDTO;
import co.com.porvenir.extracto_empresarial.application.dto.models.extract.Extracto;
import co.com.porvenir.extracto_empresarial.application.helpers.ExtractoEmpresarialReportHelper;
import co.com.porvenir.extracto_empresarial.application.mappers.ExtractoMapper;
import co.com.porvenir.extracto_empresarial.application.ports.GenerateReportUseCase;
import co.com.porvenir.extracto_empresarial.application.ports.JasperReportPort;
import co.com.porvenir.extracto_empresarial.configurations.ports.WebClientPort;
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

    private final JasperReportPort jasperPort;
    private final WebClientPort webClient;
    private final ExtractoEmpresarialReportHelper helper;

    @Override
    public byte[] generateReport(ExtractoRequestDTO request) {
        var reportParams = ExtractoMapper.mapper(callXmlConsumer(request));
        var reportParamsFilled = helper.buildParametersReport(reportParams);
        return jasperPort.generateReport(REPORT_NAME, reportParamsFilled);
    }

    public Extracto callXmlConsumer(ExtractoRequestDTO request) {
        return webClient.webClient(WebClient.builder())
                .post()
                .uri(XML_RESOURCE)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(Extracto.class)
                .block();
    }

}
