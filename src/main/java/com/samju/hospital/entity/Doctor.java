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
 * The {@code Doctor} class represents a doctor entity in the hospital management system.
 * This class is annotated with Lombok annotations to generate boilerplate code for
 * getters, setters, constructors, and builder pattern.
 *
 * <p>The doctor information is stored in MongoDB using the {@link Document} annotation,
 * specifying the collection name as "doctors".
 *
 * <p>Fields in the {@code Doctor} class include:
 * <ul>
 *   <li>{@code id}: An auto-generated unique identifier for the doctor.</li>
 *   <li>{@code fullName}: The full name of the doctor.</li>
 *   <li>{@code phoneNumber}: The contact phone number of the doctor.</li>
 *   <li>{@code department}: The department or specialization of the doctor.</li>
 *   <li>{@code reports}: The reports or summary associated with the doctor.</li>
 *   <li>{@code time}: The current time when the doctor's information is created.</li>
 *   <li>{@code day}: The day of the month when the doctor's information is created.</li>
 *   <li>{@code month}: The month when the doctor's information is created.</li>
 *   <li>{@code year}: The year when the doctor's information is created.</li>
 * </ul>
 *
 * <p>Additionally, a constructor is provided to create a {@code Doctor} instance with
 * basic information, automatically setting the time, day, month, and year.
 *
 * <p>Usage example:
 * <pre>
 * {@code
 * Doctor doctor = new Doctor("John Doe", "123-456-7890", "Cardiology", "Annual Checkup");
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
@Document(collection = "doctors")
public class Doctor {

    /**
     * The unique identifier for the doctor.
     */
    @Id
    private ObjectId id;

    /**
     * The full name of the doctor.
     */
    private String fullName;

    /**
     * The contact phone number of the doctor.
     */
    private String phoneNumber;

    /**
     * The department or specialization of the doctor.
     */
    private String department;

    /**
     * The reports or summary associated with the doctor.
     */
    private String reports;

    /**
     * The current time when the doctor's information is created.
     */
    private String time;

    /**
     * The day of the month when the doctor's information is created.
     */
    private int day;

    /**
     * The month when the doctor's information is created.
     */
    private Month month;

    /**
     * The year when the doctor's information is created.
     */
    private int year;

    /**
     * Constructor to create a {@code Doctor} instance with basic information,
     * automatically setting the time, day, month, and year.
     *
     * @param fullName    The full name of the doctor.
     * @param phoneNumber The contact phone number of the doctor.
     * @param department  The department or specialization of the doctor.
     * @param reports     The reports or summary associated with the doctor.
     */
    public Doctor(String fullName, String phoneNumber, String department, String reports) {
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
