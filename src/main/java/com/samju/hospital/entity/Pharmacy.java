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
 * The {@code Pharmacy} class represents a pharmacy entity in the hospital management system.
 * This class is annotated with Lombok annotations to generate boilerplate code for
 * getters, setters, constructors, and builder pattern.
 *
 * <p>The pharmacy information is stored in MongoDB using the {@link Document} annotation,
 * specifying the collection name as "pharmacies".
 *
 * <p>Fields in the {@code Pharmacy} class include:
 * <ul>
 *   <li>{@code id}: An auto-generated unique identifier for the pharmacy.</li>
 *   <li>{@code fullName}: The full name of the pharmacy.</li>
 *   <li>{@code phoneNumber}: The contact phone number of the pharmacy.</li>
 *   <li>{@code drugs}: The drugs or medications available in the pharmacy.</li>
 *   <li>{@code time}: The current time when the pharmacy information is created.</li>
 *   <li>{@code day}: The day of the month when the pharmacy information is created.</li>
 *   <li>{@code month}: The month when the pharmacy information is created.</li>
 *   <li>{@code year}: The year when the pharmacy information is created.</li>
 * </ul>
 *
 * <p>Additionally, a constructor is provided to create a {@code Pharmacy} instance with
 * basic information, automatically setting the time, day, month, and year.
 *
 * <p>Usage example:
 * <pre>
 * {@code
 * Pharmacy pharmacy = new Pharmacy("ABC Pharmacy", "123-456-7890", "Painkillers, Antibiotics");
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
@Document(collection = "pharmacies")
public class Pharmacy {

    /**
     * The unique identifier for the pharmacy.
     */
    @Id
    private ObjectId id;

    /**
     * The full name of the pharmacy.
     */
    private String fullName;

    /**
     * The contact phone number of the pharmacy.
     */
    private String phoneNumber;

    /**
     * The drugs or medications available in the pharmacy.
     */
    private String drugs;

    /**
     * The current time when the pharmacy information is created.
     */
    private String time;

    /**
     * The day of the month when the pharmacy information is created.
     */
    private int day;

    /**
     * The month when the pharmacy information is created.
     */
    private Month month;

    /**
     * The year when the pharmacy information is created.
     */
    private int year;

    /**
     * Constructor to create a {@code Pharmacy} instance with basic information,
     * automatically setting the time, day, month, and year.
     *
     * @param fullName    The full name of the pharmacy.
     * @param phoneNumber The contact phone number of the pharmacy.
     * @param drugs       The drugs or medications available in the pharmacy.
     */
    public Pharmacy(String fullName, String phoneNumber, String drugs) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.drugs = drugs;
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        this.time = currentTime.format(formatter);
        this.day = LocalDate.now().getDayOfMonth();
        this.month = YearMonth.now().getMonth();
        this.year = Year.now().getValue();
    }
}
