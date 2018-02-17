package man.frechet.oidc.client.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

import static org.springframework.security.oauth2.common.AuthenticationScheme.form;

import java.util.Arrays;

@Slf4j
@Data
@EnableOAuth2Client
@Configuration
public class OpenIdConnectConfig {

    @Value("${openIdConnect.clientId}")
    private String clientId;

    @Value("${openIdConnect.clientSecret}")
    private String clientSecret;

    @Value("${openIdConnect.accessTokenUri}")
    private String accessTokenUri;

    @Value("${openIdConnect.userAuthorizationUri}")
    private String userAuthorizationUri;

    @Bean
    public OAuth2ProtectedResourceDetails googleOpenId() {
        AuthorizationCodeResourceDetails details = new AuthorizationCodeResourceDetails();
        details.setAuthenticationScheme(form);
        details.setClientAuthenticationScheme(form);
        details.setClientId(clientId);
        details.setClientSecret(clientSecret);
        details.setAccessTokenUri(accessTokenUri);
        details.setUserAuthorizationUri(userAuthorizationUri);
        details.setScope(Arrays.asList("openid", "email"));
        return details;
    }

    @Bean
    public OAuth2RestTemplate restTemplate(OAuth2ClientContext clientContext) {
        return new OAuth2RestTemplate(googleOpenId(), clientContext);
    }
}
