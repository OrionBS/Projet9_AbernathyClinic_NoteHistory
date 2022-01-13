package com.abernathyclinic.MediscreenNotesHistory.services;

import com.abernathyclinic.MediscreenNotesHistory.models.PatientNote;

import java.util.List;

public interface PatientNoteService {

    /**
     * Permet d'ajouter une nouvelle note au patient.
     * @param patientNote la note du patient.
     * @return la note du patient.
     */
    PatientNote creatingPatientNote(PatientNote patientNote);

    /**
     * Permet de lire les notes du patient.
     * @param patientId l'identifiant unique du patient.
     * @return une liste de notes.
     */
    List<PatientNote> readingPatientNotes(Integer patientId);

    /**
     * Permet de mettre à jour une note du patient.
     * @param patientNote la note mise à jour.
     * @return la note du patient mise à jour.
     */
    PatientNote updatingPatientNote(PatientNote patientNote);

    /**
     * Permet de supprimer une note d'un patient.
     * @param noteId l'identifiant unique de la note.
     * @return un boolean, true si la note est supprimé, false sinon.
     */
    boolean deletingPatientNote(Integer noteId);
}
