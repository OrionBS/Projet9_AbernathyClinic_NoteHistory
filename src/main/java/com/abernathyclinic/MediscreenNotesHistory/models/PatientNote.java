package com.abernathyclinic.MediscreenNotesHistory.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "PatientNote")
public class PatientNote {

    @Id
    private Integer noteId;

    @Field(value = "PatientId")
    private Integer patientId;

    @Field(value = "PractitionerNotes")
    private String practitionerNote;

    public PatientNote(Integer noteId, Integer patientId, String practitionerNote) {
        this.noteId = noteId;
        this.patientId = patientId;
        this.practitionerNote = practitionerNote;
    }

    public PatientNote(Integer patientId, String practitionerNote) {
        this.patientId = patientId;
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

    @Override
    public String toString() {
        return "PatientNote{" +
                "id=" + noteId +
                ", patientId=" + patientId +
                ", practitionerNotes='" + practitionerNote + '\'' +
                '}';
    }
}
