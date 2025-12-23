package com.polskowniaApp.user;

import com.polskowniaApp.user.dto.UserDTO;
import com.polskowniaApp.user.dto.UserLoggedDTO;
import com.polskowniaApp.utils.exception.PasswordRequirementsNotMetException;
import com.polskowniaApp.utils.exception.UserAlreadyExistsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.regex.Pattern;

@Service
public class UserService
{
    private final UserRepository userRepo;
    private final PasswordEncoder encoder;

    public UserService(final UserRepository userRepo, final PasswordEncoder encoder)
    {
        this.userRepo = userRepo;
        this.encoder = encoder;
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
        if (this.userRepo.existsByEmail(toSave.getEmail()))
            throw new UserAlreadyExistsException("Użytkownik o podanym adresie e-mail już istnieje!");

//        check czy hasło spełnia wymogi
        if (!checkIfPasswordMetRequirements(toSave.getPassword()))
            throw new PasswordRequirementsNotMetException("Hasło powinno zawierać min 8 znaków, przynajmniej jedną dużą literę, jedną małą literę oraz jedną liczbę!");

//        TODO jeśli użytnik się sam rejestruje to ma przypisaną rolę customer? wtedy np zakup kursu etc zmienia na student
        var role = UserRole.CUSTOMER;

        return this.userRepo.save(new User(
                toSave.getName()
                , toSave.getEmail()
                , this.encoder.encode(toSave.getPassword())
                , role
                ));
    }

    private boolean checkIfPasswordMetRequirements(final String password)
    {
//        requirements
//        one uppercase letter
//        one lowercase letter
//        one digit
//        min 8 chars

//        required chars in password
        var requiredLength = 8;

//        initialization boolean flag and at once check if password has required length
        var bool = password.length() >= requiredLength;

//        create array of patterns to be matched again password
        var regexes = new Pattern[3];

//        regex for uppercase letters
        regexes[0] = Pattern.compile(".*[A-Z].*");
//        regex for lowercase letters
        regexes[1] = Pattern.compile(".*[a-z].*");
//        regex for digits
        regexes[2] = Pattern.compile(".*\\d.*");

//        check if password contains at least one lowercase letter, one uppercase letter and one digit
        for (Pattern regex : regexes)
            if (!regex.matcher(password).matches())
                bool = false;

        return bool;
    }

//    weryfikacja konta założonego przez użytkownika

}
