package workspace_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "customer")
@Getter @Setter
@NoArgsConstructor
public class Customer implements UserDetails {
    @Id
    @Column(name = "name")
    private String name;
    private String password;
    @Enumerated(EnumType.STRING)
    private Roles role;

    public enum Roles {
        ROLE_ADMIN,
        ROLE_USER
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of((GrantedAuthority) () -> role.name());
    }

    @Override
    public String getUsername() {
        return this.name;
    }
}
