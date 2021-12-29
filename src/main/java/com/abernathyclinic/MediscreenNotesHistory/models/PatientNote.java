package com.abernathyclinic.MediscreenNotesHistory.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Document(collection = "PatientNote")
public class PatientNote {

    @Id
    private Integer noteId;

    @Field(value = "PatientId")
    private Integer patientId;

    @Field(value = "DateOfCreation")
    private LocalDate dateOfCreation;

    @Field(value = "PractitionerNotes")
    private String practitionerNote;

    public PatientNote(Integer noteId, Integer patientId, LocalDate dateOfCreation, String practitionerNote) {
        this.noteId = noteId;
        this.patientId = patientId;
        this.dateOfCreation = dateOfCreation;
        this.practitionerNote = practitionerNote;
    }

    public PatientNote(Integer patientId, LocalDate dateOfCreation, String practitionerNote) {
        this.patientId = patientId;
        this.dateOfCreation = dateOfCreation;
        this.practitionerNote = practitionerNote;
    }

    public PatientNote() {
    }

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getPractitionerNote() {
        return practitionerNote;
    }

    public void setPractitionerNote(String practitionerNote) {
        this.practitionerNote = practitionerNote;
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    @Override
    public String toString() {
        return "PatientNote{" +
                "id=" + noteId +
                ", patientId=" + patientId +
                ", practitionerNotes='" + practitionerNote + '\'' +
                '}';
    }
}
