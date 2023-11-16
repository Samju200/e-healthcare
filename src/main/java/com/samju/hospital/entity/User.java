package com.samju.hospital.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * The {@code User} class represents a user entity in the hospital management system.
 * This class is annotated with Lombok annotations to generate boilerplate code for
 * getters, setters, constructors, and builder pattern.
 *
 * <p>The user information is stored in MongoDB using the {@link Document} annotation,
 * specifying the collection name as "admins".
 *
 * <p>Fields in the {@code User} class include:
 * <ul>
 *   <li>{@code id}: An auto-generated unique identifier for the user.</li>
 *   <li>{@code username}: The username of the user.</li>
 *   <li>{@code fullName}: The full name of the user.</li>
 *   <li>{@code password}: The password associated with the user account.</li>
 *   <li>{@code phoneNumber}: The contact phone number of the user.</li>
 *   <li>{@code role}: The role or position of the user in the hospital system.</li>
 * </ul>
 *
 * @author Juwon Adeyemi
 * @version 1.0
 * @see Id
 * @see Document
 * @see Data
 * @see AllArgsConstructor
 * @see Builder
 * @see NoArgsConstructor
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Document(collection = "admins")
public class User {

    /**
     * The unique identifier for the user.
     */
    @Id
    private ObjectId id;

    /**
     * The username associated with the user.
     */
    private String username;

    /**
     * The full name of the user.
     */
    private String fullName;

    /**
     * The password associated with the user account.
     */
    private String password;

    /**
     * The contact phone number of the user.
     */
    private String phoneNumber;

    /**
     * The role or position of the user in the hospital system.
     */
    private String role;
}
