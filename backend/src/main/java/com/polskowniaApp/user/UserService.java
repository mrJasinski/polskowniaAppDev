package com.polskowniaApp.user;

import com.polskowniaApp.user.dto.UserDTO;
import com.polskowniaApp.user.dto.UserLoggedDTO;
import org.springframework.http.ResponseEntity;
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

    User createUser(final UserDTO toSave)
    {
//        check czy email jest wolny
//        check czy hasło spełnia wymogi
//        TODO jeśli użytnik się sam rejestruje to ma przypisaną rolę customer? wtedy np zakup kursu etc zmienia na student
        var role = UserRole.CUSTOMER;


        return this.userRepo.save(new User(
                toSave.getEmail()
                , toSave.getPassword()
                , role
                ));
    }
}
