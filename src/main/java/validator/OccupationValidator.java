package validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@FacesValidator("occupationValidator")
public class OccupationValidator implements Validator {
    private List<String> occupationlist = Arrays.asList("Developer", "Witcher", "Prisoner");

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) {

        if (!occupationlist.contains(value.toString())){
            FacesMessage msg =
                    new FacesMessage("Occupation validation failed.",
                            "Invalid Occupation.");
            msg.setSeverity(FacesMessage.SEVERITY_INFO);
            throw new ValidatorException(msg);
        }
    }


}
