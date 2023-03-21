package Data;

import lombok.NoArgsConstructor;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.faces.validator.FacesValidator;
@FacesValidator("validatorInputY")
@NoArgsConstructor
public class ValidatorInputY implements Validator{
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {
        try{
            double y = Double.parseDouble(value.toString());
            System.out.print(y+"\n");
            if (y > 3.0 || y < -3.0){
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"y validation failed","y must be in range (-3;3)");
                throw new ValidatorException(msg);
            }
        } catch (NumberFormatException e){
            FacesMessage msg = new FacesMessage("y validation failed","y must be a number");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}
