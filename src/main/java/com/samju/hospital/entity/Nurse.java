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
 * The {@code Nurse} class represents a nurse entity in the hospital management system.
 * This class is annotated with Lombok annotations to generate boilerplate code for
 * getters, setters, constructors, and builder pattern.
 *
 * <p>The nurse information is stored in MongoDB using the {@link Document} annotation,
 * specifying the collection name as "nurses".
 *
 * <p>Fields in the {@code Nurse} class include:
 * <ul>
 *   <li>{@code id}: An auto-generated unique identifier for the nurse.</li>
 *   <li>{@code fullName}: The full name of the nurse.</li>
 *   <li>{@code phoneNumber}: The contact phone number of the nurse.</li>
 *   <li>{@code department}: The department or specialization of the nurse.</li>
 *   <li>{@code reports}: The reports or summary associated with the nurse.</li>
 *   <li>{@code time}: The current time when the nurse's information is created.</li>
 *   <li>{@code day}: The day of the month when the nurse's information is created.</li>
 *   <li>{@code month}: The month when the nurse's information is created.</li>
 *   <li>{@code year}: The year when the nurse's information is created.</li>
 * </ul>
 *
 * <p>Additionally, a constructor is provided to create a {@code Nurse} instance with
 * basic information, automatically setting the time, day, month, and year.
 *
 * <p>Usage example:
 * <pre>
 * {@code
 * Nurse nurse = new Nurse("Jane Doe", "987-654-3210", "Emergency", "Patient Care");
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
@Document(collection = "nurses")
public class Nurse {

    /**
     * The unique identifier for the nurse.
     */
    @Id
    private ObjectId id;

    /**
     * The full name of the nurse.
     */
    private String fullName;

    /**
     * The contact phone number of the nurse.
     */
    private String phoneNumber;

    /**
     * The department or specialization of the nurse.
     */
    private String department;

    /**
     * The reports or summary associated with the nurse.
     */
    private String reports;

    /**
     * The current time when the nurse's information is created.
     */
    private String time;

    /**
     * The day of the month when the nurse's information is created.
     */
    private int day;

    /**
     * The month when the nurse's information is created.
     */
    private Month month;

    /**
     * The year when the nurse's information is created.
     */
    private int year;

    /**
     * Constructor to create a {@code Nurse} instance with basic information,
     * automatically setting the time, day, month, and year.
     *
     * @param fullName    The full name of the nurse.
     * @param phoneNumber The contact phone number of the nurse.
     * @param department  The department or specialization of the nurse.
     * @param reports     The reports or summary associated with the nurse.
     */
    public Nurse(String fullName, String phoneNumber, String department, String reports) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.department = department;
        this.reports = reports;
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        this.time = currentTime.format(formatter);
        this.day = LocalDate.now().getDayOfMonth();
        this.month = YearMonth.now().getMonth();
        this.year = Year.now().getValue();
    }
}
