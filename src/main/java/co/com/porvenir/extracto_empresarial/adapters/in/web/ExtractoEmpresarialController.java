package co.com.porvenir.extracto_empresarial.adapters.in.web;

import co.com.porvenir.extracto_empresarial.adapters.in.web.dto.request.ExtractoEmpresarialRequestDto;
import co.com.porvenir.extracto_empresarial.application.ports.GenerateReportUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/extractoEmpresarial")
@RequiredArgsConstructor
public class ExtractoEmpresarialController {

    private final GenerateReportUseCase reportService;

    // Construir 5 servicios.

    @PostMapping("/generarReporte")
    public ResponseEntity<byte[]> generarExtractoEmpresarial(ExtractoEmpresarialRequestDto request) {

        var pdfGenerated = reportService.generateReport(null);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=reporte.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfGenerated);
    }


}
