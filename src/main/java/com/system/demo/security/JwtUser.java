package com.system.demo.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.system.demo.model.User;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class JwtUser implements UserDetails {
    /**
	 * 
	 */
	private static final long serialVersionUID = -6250234144260634731L;
	private String name;
    private String username;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtUser(String nombre, String nombreUsuario, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.name = nombre;
        this.username = nombreUsuario;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static JwtUser build(User user){
        List<GrantedAuthority> authorities =
                user.getUserRolCollection().stream().map(role -> new SimpleGrantedAuthority(
                		role.getRole().getNameRole())).collect(Collectors.toList());
        return new JwtUser(user.getName(), user.getUsername(), user.getEmail(), user.getPassword(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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

    public String getNombre() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}