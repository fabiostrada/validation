package it.allitude.validation.business.helpers;

import it.allitude.validation.business.exceptions.ContainerException;
import it.allitude.validation.business.exceptions.Error;
import it.allitude.validation.business.exceptions.GenericException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ErrorHelper {

    private Clock clock;
    private static final Logger logger = LogManager.getLogger(ErrorHelper.class);

    @Autowired
    public ErrorHelper setClock(Clock clock) {
        this.clock = clock;
        return this;
    }

    public<T extends GenericException> Error generateError(T error, HttpServletRequest request) {
        logger.error("Errore generato per la chiamata " + request.getMethod() + " " + request.getRequestURI() + " con messaggio " + error.getMessage());
        return new Error()
                .setMessage(error.getMessage())
                .setTime(clock.now().truncatedTo(ChronoUnit.SECONDS))
                .setPath(request.getRequestURI())
                .setMethod(request.getMethod())
                .setCode(error.getClass().getSimpleName() + "_" + error.getCode());
    }

    public List<Error> generateErrors(ContainerException errors, ServletWebRequest request) {
        return errors
                .getExceptions()
                .stream()
                .map(exeception -> generateError(exeception, request.getRequest()))
                .collect(Collectors.toList());
    }
}
