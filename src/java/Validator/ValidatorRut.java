package Validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import org.primefaces.context.RequestContext;

/**
 *
 * @author BULLANGERON
 */
@FacesValidator("ValidatorRut")
public class ValidatorRut implements Validator {

    public boolean validarRut(String rut) {

        boolean validacion = false;
        try {
            rut = rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

            char dv = rut.charAt(rut.length() - 1);

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }

        } catch (java.lang.NumberFormatException e) {
        } catch (Exception e) {
        }
        return validacion;
    }

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (!validarRut(value.toString())) {
            RequestContext requestContext = RequestContext.getCurrentInstance();
            requestContext.execute("toast('El rut ingresado tiene un formato incorrecto','error')");
            requestContext.execute("toast('}Ej 18379851-0','info')");
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error:","Formato de incorrecto"));
        }
    }

}
