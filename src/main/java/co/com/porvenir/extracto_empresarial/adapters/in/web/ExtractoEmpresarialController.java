package co.com.porvenir.extracto_empresarial.adapters.in.web;

import co.com.porvenir.extracto_empresarial.adapters.in.web.dto.request.ExtractoRequestDTO;
import co.com.porvenir.extracto_empresarial.application.ports.GenerateReportUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.Instant;

@RestController
@RequestMapping("/extractoEmpresarial")
@RequiredArgsConstructor
@Tag(name = "Extracto Cuenta Plan Empresarial - Porvenir", description = "Generación del reporte del Extracto de Plan Empresarial.")
@Slf4j
public class ExtractoEmpresarialController {

    private final GenerateReportUseCase reportService;

    @PostMapping("/generarReporte")
    @Operation(
            summary = "Genera el reporte de extracto de plan empresarial",
            description = "Este servicio genera y devuelve el extracto empresarial en formato PDF"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reporte generado exitosamente", content = @Content(mediaType = "application/pdf")),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(mediaType = "application/json"))
    })
    public ResponseEntity<byte[]> generarExtractoEmpresarial(@RequestBody @NonNull ExtractoRequestDTO request) {

        var start = Instant.now();
        var pdfGenerated = reportService.generateReport(request);
        var finish = Instant.now();

        var duration = Duration.between(start, finish);

        log.info("*** The execution time for the PDF Generations was : {} ", duration.toMillis());


        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=reporte.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfGenerated);
    }


}
