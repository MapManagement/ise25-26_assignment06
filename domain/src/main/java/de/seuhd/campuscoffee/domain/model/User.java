package de.seuhd.campuscoffee.domain.model;

import lombok.Builder;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import jakarta.validation.constraints.*;

@Builder(toBuilder = true)
public record User(
        @Nullable Long id,
        @Nullable LocalDateTime createdAt,
        @Nullable LocalDateTime updatedAt,
        @NotNull @Size(min = 1, max = 255, message = "Login name must be between 1 and 255 characters long.") @Pattern(regexp = "\\w+", message = "Login name can only contain word characters: [a-zA-Z_0-9]+") @NonNull String loginName,
        @NotNull @Email @NonNull String emailAddress,
        @NotNull @Size(min = 1, max = 255, message = "First name must be between 1 and 255 characters long.") @NonNull String firstName,
        @NotNull @Size(min = 1, max = 255, message = "Last name must be between 1 and 255 characters long.") @NonNull String lastName

) implements Serializable { // serializable to allow cloning (see TestFixtures class).
    @Serial
    private static final long serialVersionUID = 1L;
}
