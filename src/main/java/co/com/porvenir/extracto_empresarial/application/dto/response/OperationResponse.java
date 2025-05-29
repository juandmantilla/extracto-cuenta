package co.com.porvenir.extracto_empresarial.application.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OperationResponse {
    private boolean isSuccess;
    private int statusCode;
    private String message;
}


