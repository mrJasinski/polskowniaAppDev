package com.polskowniaApp.user;

import java.util.Optional;

interface UserRepository
{
    Optional<User> findByEmail(final String email);

    User save(final User toSave);

    boolean existsByEmail(final String email);
}
