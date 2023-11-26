package com.samju.hospital.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;
/**
 * The {@code Patient} class represents a patient entity in the hospital management system.
 * This class is annotated with Lombok annotations to generate boilerplate code for
 * getters, setters, constructors, and builder pattern.
 *
 * <p>The patient information is stored in MongoDB using the {@link Document} annotation,
 * specifying the collection name as "patients".
 *
 * <p>Fields in the {@code Patient} class include:
 * <ul>
 *   <li>{@code id}: An auto-generated unique identifier for the patient.</li>
 *   <li>{@code registrationType}: The type of patient registration.</li>
 *   <li>{@code hmoType}: The type of Health Maintenance Organization (HMO) associated with the patient.</li>
 *   <li>{@code registrationNumber}: The registration number assigned to the patient.</li>
 *   <li>{@code hmoNumber}: The HMO number associated with the patient.</li>
 *   <li>{@code patientStatus}: The current status of the patient.</li>
 *   <li>{@code title}: The title (e.g., Mr., Mrs., Dr.) of the patient.</li>
 *   <li>{@code surname}: The surname of the patient.</li>
 *   <li>{@code firstname}: The first name of the patient.</li>
 *   <li>{@code phoneNumber}: The contact phone number of the patient.</li>
 *   <li>{@code address}: The address of the patient.</li>
 *   <li>{@code dateOfBirth}: The date of birth of the patient.</li>
 *   <li>{@code age}: The age of the patient.</li>
 *   <li>{@code nextOfKinName}: The name of the patient's next of kin.</li>
 *   <li>{@code nextOfKinPhoneNumber}: The contact phone number of the patient's next of kin.</li>
 *   <li>{@code nextOfKinAddress}: The address of the patient's next of kin.</li>
 *   <li>{@code time}: The current time when the patient's information is created.</li>
 *   <li>{@code day}: The day of the month when the patient's information is created.</li>
 *   <li>{@code month}: The month when the patient's information is created.</li>
 *   <li>{@code year}: The year when the patient's information is created.</li>
 *   <li>{@code doctor}: A list of doctors associated with the patient, referenced by their unique identifiers.</li>
 *   <li>{@code nurse}: A list of nurses associated with the patient, referenced by their unique identifiers.</li>
 *   <li>{@code laboratory}: A list of laboratories associated with the patient, referenced by their unique identifiers.</li>
 *   <li>{@code radiology}: A list of radiology services associated with the patient, referenced by their unique identifiers.</li>
 *   <li>{@code pharmacy}: A list of pharmacy services associated with the patient, referenced by their unique identifiers.</li>
 *   <li>{@code account}: A list of accounts associated with the patient, referenced by their unique identifiers.</li>
 * </ul>
 *
 * <p>Additionally, a default constructor is provided to create a {@code Patient} instance with
 * basic information, automatically setting the time, day, month, and year.
 *
 * <p>Usage example:
 * <pre>
 * {@code
 * Patient patient = new Patient();
 * }
 * </pre>
 *
 * @author Juwon Adeyemi
 * @version 1.0
 * @see Id
 * @see Document
 * @see DocumentReference
 * @see Data
 * @see AllArgsConstructor
 * @see Builder
 * @see LocalDate
 * @see LocalTime
 * @see DateTimeFormatter
 * @see YearMonth
 * @see Year
 * @see Doctor
 * @see Nurse
 * @see Laboratory
 * @see Radiology
 * @see Pharmacy
 * @see Account
 */
@Data
@AllArgsConstructor
@Builder
@Document(collection = "patients")
public class Patient {

    /**
     * The unique identifier for the patient.
     */
    @Id
    private ObjectId id;

    /**
     * The type of patient registration.
     */
    private String registrationType;

    /**
     * The type of Health Maintenance Organization (HMO) associated with the patient.
     */
    private String hmoType;

    /**
     * The registration number assigned to the patient.
     */
    private String registrationNumber;

    /**
     * The HMO number associated with the patient.
     */
    private String hmoNumber;

    /**
     * The current status of the patient.
     */
    private String patientStatus;

    /**
     * The title (e.g., Mr., Mrs., Dr.) of the patient.
     */
    private String title;

    /**
     * The surname of the patient.
     */
    private String surname;

    /**
     * The first name of the patient.
     */
    private String firstname;

    /**
     * The contact phone number of the patient.
     */
    private String phoneNumber;

    /**
     * The address of the patient.
     */
    private String address;

    /**
     * The date of birth of the patient.
     */
    private String dateOfBirth;

    /**
     * The age of the patient.
     */
    private String age;

    /**
     * The name of the patient's next of kin.
     */
    private String nextOfKinName;

    /**
     * The contact phone number of the patient's next of kin.
     */
    private String nextOfKinPhoneNumber;

    /**
     * The address of the patient's next of kin.
     */
    private String nextOfKinAddress;

    /**
     * The current time when the patient's information is created.
     */
    private String time;

    /**
     * The day of the month when the patient's information is created.
     */
    private int day;

    /**
     * The month when the patient's information is created.
     */
    private Month month;

    /**
     * The year when the patient's information is created.
     */
    private int year;

    /**
     * A list of doctors associated with the patient, referenced by their unique identifiers.
     */
    @DocumentReference
    private List<Doctor> doctors;

    /**
     * A list of nurses associated with the patient, referenced by their unique identifiers.
     */
    @DocumentReference
    private List<Nurse> nurses;

    /**
     * A list of laboratories associated with the patient, referenced by their unique identifiers.
     */
    @DocumentReference
    private List<Laboratory> laboratories;

    /**
     * A list of radiology services associated with the patient, referenced by their unique identifiers.
     */
    @DocumentReference
    private List<Radiology> radiology;

    /**
     * A list of pharmacy services associated with the patient, referenced by their unique identifiers.
     */
    @DocumentReference
    private List<Pharmacy> pharmacies;

    /**
     * A list of accounts associated with the patient, referenced by their unique identifiers.
     */
    @DocumentReference
    private List<Account> accounts;

    /**
     * Default constructor to create a {@code Patient} instance with basic information,
     * automatically setting the time, day, month, and year.
     */
    public Patient() {
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        this.time = currentTime.format(formatter);
        this.day = LocalDate.now().getDayOfMonth();
        this.month = YearMonth.now().getMonth();
        this.year = Year.now().getValue();
    }
}
