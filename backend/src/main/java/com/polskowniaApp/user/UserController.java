package com.polskowniaApp.user;

import com.polskowniaApp.security.JwtService;
import com.polskowniaApp.user.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class UserController
{
    private final JwtService jwtService;
    private final AuthenticationManager authManager;
    private final UserService userService;

    UserController(final JwtService jwtService, final AuthenticationManager authManager, final UserService userService)
    {
        this.jwtService = jwtService;
        this.authManager = authManager;
        this.userService = userService;
    }

    @PostMapping("/authenticate")
    ResponseEntity<?> authenticateUser(@RequestBody UserDTO user)
    {
//        wyniesienie logiki do serwisu?

        var userDetails = this.authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));

        if (!userDetails.isAuthenticated())
            throw new UsernameNotFoundException("Invalid user credentials!");

        var logged = this.userService.getLoggedUserDataByEmail(user.getEmail(), this.jwtService.generateToken(user.getEmail()));

        return ResponseEntity.ok(logged);
    }
}
