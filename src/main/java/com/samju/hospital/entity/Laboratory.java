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
 * The {@code Laboratory} class represents a laboratory entity in the hospital management system.
 * This class is annotated with Lombok annotations to generate boilerplate code for
 * getters, setters, constructors, and builder pattern.
 *
 * <p>The laboratory information is stored in MongoDB using the {@link Document} annotation,
 * specifying the collection name as "laboratories".
 *
 * <p>Fields in the {@code Laboratory} class include:
 * <ul>
 *   <li>{@code id}: An auto-generated unique identifier for the laboratory.</li>
 *   <li>{@code fullName}: The full name of the laboratory.</li>
 *   <li>{@code phoneNumber}: The contact phone number of the laboratory.</li>
 *   <li>{@code testReports}: The test reports or summaries associated with the laboratory.</li>
 *   <li>{@code time}: The current time when the laboratory information is created.</li>
 *   <li>{@code day}: The day of the month when the laboratory information is created.</li>
 *   <li>{@code month}: The month when the laboratory information is created.</li>
 *   <li>{@code year}: The year when the laboratory information is created.</li>
 * </ul>
 *
 * <p>Additionally, a constructor is provided to create a {@code Laboratory} instance with
 * basic information, automatically setting the time, day, month, and year.
 *
 * <p>Usage example:
 * <pre>
 * {@code
 * Laboratory lab = new Laboratory("ABC Diagnostics", "987-654-3210", "Blood Test");
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
@Document(collection = "laboratories")
public class Laboratory {

    /**
     * The unique identifier for the laboratory.
     */
    @Id
    private ObjectId id;

    /**
     * The full name of the laboratory.
     */
    private String fullName;

    /**
     * The contact phone number of the laboratory.
     */
    private String phoneNumber;

    /**
     * The test reports or summaries associated with the laboratory.
     */
    private String testReports;

    /**
     * The current time when the laboratory information is created.
     */
    private String time;

    /**
     * The day of the month when the laboratory information is created.
     */
    private int day;

    /**
     * The month when the laboratory information is created.
     */
    private Month month;

    /**
     * The year when the laboratory information is created.
     */
    private int year;

    /**
     * Constructor to create a {@code Laboratory} instance with basic information,
     * automatically setting the time, day, month, and year.
     *
     * @param fullName    The full name of the laboratory.
     * @param phoneNumber The contact phone number of the laboratory.
     * @param testReports The test reports or summaries associated with the laboratory.
     */
    public Laboratory(String fullName, String phoneNumber, String testReports) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.testReports = testReports;
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        this.time = currentTime.format(formatter);
        this.day = LocalDate.now().getDayOfMonth();
        this.month = YearMonth.now().getMonth();
        this.year = Year.now().getValue();
    }
}
