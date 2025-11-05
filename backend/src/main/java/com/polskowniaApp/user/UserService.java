package com.polskowniaApp.user;

import com.polskowniaApp.user.dto.UserDTO;
import com.polskowniaApp.user.dto.UserLoggedDTO;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserService
{
    private final UserRepository userRepo;

    public UserService(final UserRepository userRepo)
    {
        this.userRepo = userRepo;
    }

    User getUserByEmail(final String email)
    {
        return this.userRepo.findByEmail(email)
                .orElseThrow(() -> new NoSuchElementException("User with given email not found!"));
    }

    public UserDTO getUserByEmailAsDto(final String email)
    {
        return getUserByEmail(email).toDto();
    }

    UserLoggedDTO getLoggedUserDataByEmail(final String email, final String token)
    {
        var user = getUserByEmail(email);

        return new UserLoggedDTO(
                user.getName()
                , user.getEmail()
                , token
                , user.getRoleAsString()
        );
    }
}
