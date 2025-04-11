package workspace_management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import workspace_management.enums.Roles;

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
    private Roles role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of((GrantedAuthority) () -> role.name());
    }

    @Override
    public String getUsername() {
        return this.name;
    }
}
