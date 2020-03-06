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


    private String username;

    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String save() {
        userService.addUser(username, email);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("You've registered"));
        setUsername(null);
        setEmail(null);
        return "/hello.xhtml?faces-redirect=true";
    }
}