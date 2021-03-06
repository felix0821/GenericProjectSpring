package com.system.demo.dto.specific;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Date;

public class JwtDto {
    private String token;
    private String bearer = "Bearer";
    private String username;
    private String key;
    private String imageUrl;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtDto(String token, String username, String key, Collection<? extends GrantedAuthority> authorities, String imageUrl) {
        this.token = token;
        this.username = username;
        this.authorities = authorities;
        this.key = key;
        this.imageUrl = imageUrl;
    }
    
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBearer() {
        return bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getKey() {
		return key;
	}

	public void setKey(String keyId) {
		this.key = keyId;
	}
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
    
}
