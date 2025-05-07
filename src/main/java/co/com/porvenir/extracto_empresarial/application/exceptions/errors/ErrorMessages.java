package co.com.porvenir.extracto_empresarial.application.exceptions.errors;

import lombok.Getter;

@Getter
public enum ErrorMessages {

    ERROR_LOADING_FILE_REPORT("Error while trying to load the report file", 500),
    ERROR_FILL_REPORT("Error when trying to fill the report object", 500);

    private final String messageError;
    private final int errorCode;

    ErrorMessages(String messageError, int errorCode) {
        this.messageError = messageError;
        this.errorCode = errorCode;
    }
}
