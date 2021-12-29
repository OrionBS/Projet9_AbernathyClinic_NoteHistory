package com.abernathyclinic.MediscreenNotesHistory.services.impl;

import com.abernathyclinic.MediscreenNotesHistory.models.PatientNote;
import com.abernathyclinic.MediscreenNotesHistory.repositories.PatientNoteRepository;
import com.abernathyclinic.MediscreenNotesHistory.services.PatientNoteService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class PatientNoteServiceImpl implements PatientNoteService {

    private final PatientNoteRepository patientNoteRepository;

    public PatientNoteServiceImpl(PatientNoteRepository patientNoteRepository) {
        this.patientNoteRepository = patientNoteRepository;
    }

    @Override
    public PatientNote creatingPatientNote(PatientNote patientNote) {

        Integer lastId = ThreadLocalRandom.current().nextInt();

        if (patientNote.getPatientId() == null || patientNote.getPractitionerNote() == null) {
            return null;
        }

        patientNote.setNoteId(lastId);

        patientNote.setDateOfCreation(LocalDate.now());

        return patientNoteRepository.save(patientNote);
    }

    @Override
    public List<PatientNote> readingPatientNotes(Integer patientId) {

        List<PatientNote> patientNotes = patientNoteRepository.findByPatientId(patientId);

        patientNotes.sort(Comparator.comparing(PatientNote::getDateOfCreation));

        return patientNotes;
    }

    @Override
    public PatientNote updatingPatientNote(PatientNote patientNote) {

        PatientNote patientNoteAsk = patientNote;

        if (patientNoteAsk == null) {
            return null;
        }

        Optional<PatientNote> patientNoteRecovered = patientNoteRepository.findById(patientNoteAsk.getNoteId());

        if (patientNoteRecovered.isEmpty()) {
            return null;
        }

        PatientNote oldPatientNote = patientNoteRecovered.get();

        oldPatientNote.setPractitionerNote(patientNoteAsk.getPractitionerNote());

        return patientNoteRepository.save(oldPatientNote);
    }

    @Override
    public boolean deletingPatientNote(Integer noteId) {

        if (!patientNoteRepository.existsById(noteId)) {
            return false;
        }

        patientNoteRepository.deleteById(noteId);

        return true;
    }
}
