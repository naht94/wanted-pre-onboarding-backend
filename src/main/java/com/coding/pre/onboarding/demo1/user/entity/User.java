package com.coding.pre.onboarding.demo1.user.entity;

import com.coding.pre.onboarding.demo1.base.entity.FoundationEntity;
import com.coding.pre.onboarding.demo1.grant.domain.Role;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends FoundationEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private String email;
    private String pwd;
    @ElementCollection(fetch = FetchType.EAGER)
    @Getter
    private List<String> roles;

    public static User makeAdmin(String email, String pwd) {
        ArrayList<String> roles = new ArrayList<>();
        roles.add(Role.ADMIN.grant());
        return new User(null , email, pwd, roles);
    }

    public static User makeUser(String email, String pwd) {
        ArrayList<String> roles = new ArrayList<>();
        roles.add(Role.USER.grant());
        return new User(null , email, pwd, roles);
    }

    private User(Long id, String email, String pwd, List<String> roles) {
        this.id = id;
        this.email = email;
        this.pwd = pwd;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return pwd;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
