package co.com.porvenir.extracto_empresarial.application.ports;

import co.com.porvenir.extracto_empresarial.adapters.in.web.dto.request.ExtractoRequestDTO;

public interface GenerateReportUseCase {

    byte[] generateReport(ExtractoRequestDTO request);
}
