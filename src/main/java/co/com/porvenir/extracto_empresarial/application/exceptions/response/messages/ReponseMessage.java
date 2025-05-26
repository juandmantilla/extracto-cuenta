package co.com.porvenir.extracto_empresarial.application.exceptions.response.messages;

import lombok.Getter;

@Getter
public enum ReponseMessage {


    PDF_FOUNDED("Petición procesada correctamente", 200),
    ADD_QUEUE_REQUEST("Solicitud enviada correctamente", 235),
    PDF_IN_PROCESS("El PDF se encuentra en proceso", 236),
    PDF_REQUEST_BY_EMAIL("Se ha generado la notificación de...", 237),
    PDF_NOT_CREATED("La ejecución de generación de pdf ...", 238),

    REQUEST_WITHOUT_HEADERS("Error - Datos de entrada requeridos ...", 400),
    INVALID_REQUEST_PARAMS("Error - Parámetros inválidos", 400),

    INTERNAL_SERVER_ERROR("Error interno de servidor. Por favor ...", 500),
    SERVICE_CONSUMPTION_ERROR("Error consumiendo el servicio", 500),
    CIRCUIT_BREAKER_OPEN("Error servicio temporalmente no ...", 500);

    private final String messageError;
    private final int statusCode;

    ReponseMessage(String messageError, int statusCode) {
        this.messageError = messageError;
        this.statusCode = statusCode;
    }
}
