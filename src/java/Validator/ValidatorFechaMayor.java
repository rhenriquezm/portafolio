/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validator;

import java.util.Date;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author shelob
 */
@FacesValidator("validatorFechaMayor")
public class ValidatorFechaMayor implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
          
            Date  startDate = new Date($('#{start}').val());
            var endDate = new Date($('#endDate').val());

    if (startDate < endDate) {
        
        }
    }

}
