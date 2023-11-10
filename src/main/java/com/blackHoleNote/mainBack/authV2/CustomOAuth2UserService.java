package com.blackHoleNote.mainBack.authV2;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UserJPARepository userRepository;

    public CustomOAuth2UserService(UserJPARepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
//        ClientRegistration.ProviderDetails.UserInfoEndpoint userInfoEndpoint = userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint();

        OAuth2User oAuth2User = super.loadUser(userRequest);
//        log.info("getAttributes : {}", oAuth2User.getAttributes());

        String provider = userRequest.getClientRegistration().getRegistrationId();
        String providerId = oAuth2User.getAttribute("sub");
        String loginId = provider + "_" +providerId;

        Optional<User> optionalUser = userRepository.findByOauthId(loginId);
        User user;

        if(optionalUser.isEmpty()) {
            user = new User(oAuth2User.getName(), loginId, oAuth2User.getAttribute("email"));
////                    .loginId(loginId)
//                    .nickname(oAuth2User.getAttribute("name"))
//                    .provider(provider)
//                    .providerId(providerId)
//                    .role(UserRole.USER)
//                    .build();
            userRepository.save(user);
        } else {
            user = optionalUser.get();
        }
        return user;
//        return new PrincipalDetails(user, oAuth2User.getAttributes());
//        return null;
    }
}
