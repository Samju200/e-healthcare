package com.samju.hospital.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * The {@code Account} class represents an account entity in the hospital management system.
 * This class is annotated with Lombok annotations to generate boilerplate code for
 * getters, setters, constructors, and builder pattern.
 *
 * <p>The account information is stored in MongoDB using the {@link Document} annotation,
 * specifying the collection name as "accounts".
 *
 * <p>Fields in the {@code Account} class include:
 * <ul>
 *   <li>{@code id}: An auto-generated unique identifier for the account.</li>
 *   <li>{@code fullName}: The full name associated with the account.</li>
 *   <li>{@code phoneNumber}: The contact phone number associated with the account.</li>
 *   <li>{@code amount}: The amount of money associated with the account.</li>
 *   <li>{@code time}: The current time when the account information is created.</li>
 *   <li>{@code day}: The day of the month when the account information is created.</li>
 *   <li>{@code month}: The month when the account information is created.</li>
 *   <li>{@code year}: The year when the account information is created.</li>
 * </ul>
 *
 * <p>Additionally, a constructor is provided to create an {@code Account} instance with
 * basic information, automatically setting the time, day, month, and year.
 *
 * <p>Usage example:
 * <pre>
 * {@code
 * Account account = new Account("John Doe", "1000", "123-456-7890");
 * }
 * </pre>
 *
 * @author Juwon Adeyemi
 * @version 1.0
 * @see Id
 * @see Document
 * @see Data
 * @see AllArgsConstructor
 * @see Builder
 * @see NoArgsConstructor
 * @see LocalDate
 * @see LocalTime
 * @see DateTimeFormatter
 * @see YearMonth
 * @see Year
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Document(collection = "accounts")
public class Account {

    /**
     * The unique identifier for the account.
     */
    @Id
    private ObjectId id;

    /**
     * The full name associated with the account.
     */
    private String fullName;

    /**
     * The contact phone number associated with the account.
     */
    private String phoneNumber;

    /**
     * The amount of money associated with the account.
     */
    private String amount;

    /**
     * The current time when the account information is created.
     */
    private String time;

    /**
     * The day of the month when the account information is created.
     */
    private int day;

    /**
     * The month when the account information is created.
     */
    private Month month;

    /**
     * The year when the account information is created.
     */
    private int year;

    /**
     * Constructor to create an {@code Account} instance with basic information,
     * automatically setting the time, day, month, and year.
     *
     * @param fullName    The full name associated with the account.
     * @param amount      The amount of money associated with the account.
     * @param phoneNumber The contact phone number associated with the account.
     */
    public Account(String fullName, String amount, String phoneNumber) {
        this.fullName = fullName;
        this.amount = amount;
        this.phoneNumber = phoneNumber;
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        this.time = currentTime.format(formatter);
        this.day = LocalDate.now().getDayOfMonth();
        this.month = YearMonth.now().getMonth();
        this.year = Year.now().getValue();
    }
}
