package pl.coderslab.charity.model;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class CurrentUser {

    private final pl.coderslab.charity.entity.User user;

    public CurrentUser(
            String username,
            String password,
            Collection<? extends GrantedAuthority> authorities,
            pl.coderslab.charity.entity.User user
    ) {
        super(username, password, authorities);
        this.user = user;
    }

    public pl.coderslab.charity.entity.User getUser() {
        return user;
    }
}
