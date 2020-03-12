import service.impl.UserService;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped
public class SpotlightView implements Serializable {

    @Inject
    private UserService userService;


    private String firstname;

    private String lastname;

    private String dob;

    private String email;

    private String occupation;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String save() {
        userService.addUser(firstname, lastname, dob, email, occupation);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("You've registered"));
        setFirstname(null);
        setLastname(null);
        setDob(null);
        setEmail(null);
        setOccupation(null);
        return "/datatable.xhtml?faces-redirect=true";
    }


}