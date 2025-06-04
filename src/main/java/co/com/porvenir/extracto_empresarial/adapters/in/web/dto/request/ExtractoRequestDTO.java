package co.com.porvenir.extracto_empresarial.adapters.in.web.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ExtractoRequestDTO {
    private LocalDate startDate;
    private LocalDate finishDate;
    private String productCode;
}
