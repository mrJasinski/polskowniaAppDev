package com.polskowniaApp.user;

import com.polskowniaApp.user.dto.UserDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole role;

    User()
    {
    }

    User(final String email, final String password, final UserRole role)
    {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    User(final String name, final String email, final String password, final UserRole role)
    {
        this(email, password, role);
        this.name = name;
    }

    UserDTO toDto()
    {
        return new UserDTO(
                this.email
                , this.password
                , this.role);
    }

    public int getId()
    {
        return this.id;
    }

    public String getName()
    {
        return this.name;
    }

    public String getEmail()
    {
        return this.email;
    }

    public String getPassword()
    {
        return this.password;
    }

    public UserRole getRole()
    {
        return this.role;
    }

    public String getRoleAsString()
    {
        return this.role.toString();
    }
}
