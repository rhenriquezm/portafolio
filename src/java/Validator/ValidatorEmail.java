package Validator;

import java.util.regex.Matcher;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Pattern;
import org.primefaces.context.RequestContext;

@FacesValidator("validatorEmail")

public class ValidatorEmail implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        Pattern pattern=Pattern.compile("([a-zA-Z0-9\\.\\/-_]+\\@[a-zA-Z-]+\\.[a-zA-Z]+)*");
        Matcher matcher=pattern.matcher((CharSequence) value);
        
        if(!matcher.matches()){
            RequestContext requestContext = RequestContext.getCurrentInstance();
            requestContext.execute("toast('Formato de email incorrecto','error')");
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error:","Formato de incorrecto"));
        }
    }
    
}
