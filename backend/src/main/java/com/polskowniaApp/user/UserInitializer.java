package com.polskowniaApp.user;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
class UserInitializer implements ApplicationListener<ContextRefreshedEvent>
{
    private final UserRepository userRepo;
    private final PasswordEncoder encoder;

    UserInitializer(final UserRepository userRepo, final PasswordEncoder encoder)
    {
        this.userRepo = userRepo;
        this.encoder = encoder;
    }

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event)
    {
        var email1 = "admin@example.com";

        if (!this.userRepo.existsByEmail(email1))
            this.userRepo.save(new User(
                    "admin"
                    , email1
                    , this.encoder.encode("admin")
                    , UserRole.ADMIN
            ));

        var email2 = "head-lecturer@example.com";

        if (!this.userRepo.existsByEmail(email2))
            this.userRepo.save(new User(
                    "headLecturer"
                    , email2
                    , this.encoder.encode("lecturer")
                    , UserRole.HEAD_LECTURER
            ));

        var email3 = "lecturer@example.com";

        if (!this.userRepo.existsByEmail(email3))
            this.userRepo.save(new User(
                    "lecturer"
                    , email3
                    , this.encoder.encode("lecturer")
                    , UserRole.LECTURER
            ));

        var email4 = "student1@example.com";

        if (!this.userRepo.existsByEmail(email4))
            this.userRepo.save(new User(
                    "student1"
                    , email4
                    , this.encoder.encode("student")
                    , UserRole.STUDENT
            ));

        var email5 = "student2@example.com";

        if (!this.userRepo.existsByEmail(email5))
            this.userRepo.save(new User(
                    "student2"
                    , email5
                    , this.encoder.encode("student")
                    , UserRole.STUDENT
            ));

        var email6 = "customer@example.com";

        if (!this.userRepo.existsByEmail(email6))
            this.userRepo.save(new User(
                    "customer"
                    , email6
                    , this.encoder.encode("customer")
                    , UserRole.CUSTOMER
            ));


    }
}
