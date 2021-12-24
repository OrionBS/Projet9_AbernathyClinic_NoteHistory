package com.abernathyclinic.MediscreenNotesHistory.services;

import com.abernathyclinic.MediscreenNotesHistory.models.PatientNote;

import java.util.List;

public interface PatientNoteService {
    PatientNote creatingPatientNote(PatientNote patientNote);
    List<PatientNote> readingPatientNotes(Integer patientId);
    PatientNote updatingPatientNote(PatientNote patientNote);
    boolean deletingPatientNote(Integer noteId);
}
