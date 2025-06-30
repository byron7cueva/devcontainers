package com.webapi.keycloak.respositories;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Component;

import com.webapi.user.dto.UserDto;

import jakarta.ws.rs.core.Response;

@Component
public class KeycloakRepository {
    public void create(UserDto userDto) {

        Keycloak keycloak = KeycloakBuilder.builder()
                .serverUrl("http://keycloak:8080")
                .realm("webapi.dev")
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                .clientId("webapibe")
                .clientSecret("9M2pfwj0qOp6EBaQgA5eSMYZWKCv3uEz")
                // .username("admin")
                // .password("admin")
                .build();

        UserRepresentation userRepresentation = new UserRepresentation();
        userRepresentation.setUsername(userDto.getUserName());
        userRepresentation.singleAttribute("userId", userDto.getUserId().toString());

        RealmResource realmResource = keycloak.realm("webapi.dev");
        UsersResource usersResource = realmResource.users();
        Response response = usersResource.create(userRepresentation);
        Object a = response.getEntity();
    }
}
