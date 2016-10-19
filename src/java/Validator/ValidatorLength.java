/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Samsung
 */

@FacesValidator("validatorLength")

public class ValidatorLength implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
       
       
        int min = (int) component.getAttributes().get("min"); 
        int max = (int) component.getAttributes().get("max"); 
        String dato = (String) value;
        if(dato.length()>min && dato.length()<=max){
            RequestContext requestContext = RequestContext.getCurrentInstance();
            requestContext.execute("toast('Minimo se aceptan "+min+" y maximo "+max+" caractéres','error')");
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error:","Campos vacios obligatorios"));
        }
        
    }
   
}
