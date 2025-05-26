package co.com.porvenir.extracto_empresarial.application.exceptions;

import co.com.porvenir.extracto_empresarial.application.exceptions.response.messages.ReponseMessage;
import lombok.Getter;

@Getter
public class PorvenirException extends RuntimeException {

    private final int errorCode;
    private final String messageCode;
    private final Throwable cause;

    public PorvenirException(String message, int errorCode, String messageCode, Throwable cause) {
        super(message);
        this.errorCode = errorCode;
        this.messageCode = messageCode;
        this.cause = cause;
    }

    public PorvenirException(ReponseMessage errorWrapper, Throwable cause) {
        super(errorWrapper.getMessageError());
        this.messageCode = errorWrapper.getMessageError();
        this.errorCode = errorWrapper.getStatusCode();
        this.cause = cause;
    }

}
