package man.frechet.oidc.client.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

import java.util.Collection;
import java.util.Map;

@Data
public class OpenIdConnectUserDetails implements UserDetails {
    private String userId;
    private String username;
    private String givenName;
    private String familyName;
    private String gender;
    private OAuth2AccessToken token;

    public OpenIdConnectUserDetails(Map<String, String> userInfo, OAuth2AccessToken token) {
        this.userId = userInfo.get("sub");
        this.username = userInfo.get("email");
        this.givenName = userInfo.get("given_name");
        this.familyName = userInfo.get("family_name");
        this.gender = userInfo.get("gender");
        this.token = token;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO
        return null;
    }

    @Override
    public String getPassword() {
        // TODO
        return null;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO
        return false;
    }

    @Override
    public boolean isEnabled() {
        // TODO
        return false;
    }
}
