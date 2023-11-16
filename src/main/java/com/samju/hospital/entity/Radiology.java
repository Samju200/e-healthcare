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
 * The {@code Radiology} class represents a radiology entity in the hospital management system.
 * This class is annotated with Lombok annotations to generate boilerplate code for
 * getters, setters, constructors, and builder pattern.
 *
 * <p>The radiology information is stored in MongoDB using the {@link Document} annotation,
 * specifying the collection name as "radiologys".
 *
 * <p>Fields in the {@code Radiology} class include:
 * <ul>
 *   <li>{@code id}: An auto-generated unique identifier for the radiology entry.</li>
 *   <li>{@code fullName}: The full name of the radiology service provider.</li>
 *   <li>{@code phoneNumber}: The contact phone number of the radiology service provider.</li>
 *   <li>{@code images}: The images or scans associated with the radiology service.</li>
 *   <li>{@code reports}: The reports or summaries associated with the radiology service.</li>
 *   <li>{@code time}: The current time when the radiology information is created.</li>
 *   <li>{@code day}: The day of the month when the radiology information is created.</li>
 *   <li>{@code month}: The month when the radiology information is created.</li>
 *   <li>{@code year}: The year when the radiology information is created.</li>
 * </ul>
 *
 * <p>Additionally, a constructor is provided to create a {@code Radiology} instance with
 * basic information, automatically setting the time, day, month, and year.
 *
 * <p>Usage example:
 * <pre>
 * {@code
 * Radiology radiology = new Radiology("XYZ Imaging Center", "987-654-3210", "X-ray Images", "Diagnostic Report");
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
@Document(collection = "radiologys")
public class Radiology {

    /**
     * The unique identifier for the radiology entry.
     */
    @Id
    private ObjectId id;

    /**
     * The full name of the radiology service provider.
     */
    private String fullName;

    /**
     * The contact phone number of the radiology service provider.
     */
    private String phoneNumber;

    /**
     * The images or scans associated with the radiology service.
     */
    private String images;

    /**
     * The reports or summaries associated with the radiology service.
     */
    private String reports;

    /**
     * The current time when the radiology information is created.
     */
    private String time;

    /**
     * The day of the month when the radiology information is created.
     */
    private int day;

    /**
     * The month when the radiology information is created.
     */
    private Month month;

    /**
     * The year when the radiology information is created.
     */
    private int year;

    /**
     * Constructor to create a {@code Radiology} instance with basic information,
     * automatically setting the time, day, month, and year.
     *
     * @param fullName    The full name of the radiology service provider.
     * @param phoneNumber The contact phone number of the radiology service provider.
     * @param images      The images or scans associated with the radiology service.
     * @param reports     The reports or summaries associated with the radiology service.
     */
    public Radiology(String fullName, String phoneNumber, String images, String reports) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.images = images;
        this.reports = reports;
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        this.time = currentTime.format(formatter);
        this.day = LocalDate.now().getDayOfMonth();
        this.month = YearMonth.now().getMonth();
        this.year = Year.now().getValue();
    }
}
