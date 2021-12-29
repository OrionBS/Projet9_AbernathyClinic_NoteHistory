package com.abernathyclinic.MediscreenNotesHistory.units;

import com.abernathyclinic.MediscreenNotesHistory.models.PatientNote;
import com.abernathyclinic.MediscreenNotesHistory.repositories.PatientNoteRepository;
import com.abernathyclinic.MediscreenNotesHistory.services.impl.PatientNoteServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PatientNoteServiceTest {

    @InjectMocks
    private PatientNoteServiceImpl patientNoteService;

    @Mock
    private PatientNoteRepository patientNoteRepository;

    @Test
    public void testCreatingPatientNote() {
        //GIVEN
        PatientNote patientNote = new PatientNote(12, LocalDate.now(),"testNote");
        Mockito.when(patientNoteRepository.save(patientNote)).thenReturn(patientNote);

        //WHEN
        PatientNote patientNoteSave = patientNoteService.creatingPatientNote(patientNote);

        //THEN
        Mockito.verify(patientNoteRepository, Mockito.times(1)).save(patientNote);
        Assertions.assertEquals(patientNote,patientNoteSave);
    }

    @Test
    public void testReadingPatientNote() {
        //GIVEN
        PatientNote patientNote = new PatientNote(12, LocalDate.now(),"testNote");
        List<PatientNote> patientNotes = Collections.singletonList(patientNote);
        Mockito.when(patientNoteRepository.findByPatientId(patientNote.getPatientId())).thenReturn(patientNotes);

        //WHEN
        List<PatientNote> patientNotesRead = patientNoteService.readingPatientNotes(patientNote.getPatientId());

        //THEN
        Mockito.verify(patientNoteRepository, Mockito.times(1)).findByPatientId(patientNote.getPatientId());
        Assertions.assertEquals(patientNotes,patientNotesRead);
    }

    @Test
    public void testUpdatingPatientNote() {
        //GIVEN
        PatientNote patientNote = new PatientNote(25,12, LocalDate.now(),"testNote");
        Mockito.when(patientNoteRepository.findById(patientNote.getNoteId())).thenReturn(Optional.of(patientNote));
        Mockito.when(patientNoteRepository.save(patientNote)).thenReturn(patientNote);

        //WHEN
        PatientNote patientNoteUpdate = patientNoteService.updatingPatientNote(patientNote);

        //THEN
        Mockito.verify(patientNoteRepository, Mockito.times(1)).findById(patientNote.getNoteId());
        Mockito.verify(patientNoteRepository, Mockito.times(1)).save(patientNote);
        Assertions.assertEquals(patientNote,patientNoteUpdate);
    }

    @Test
    public void testDeletingPatientNote() {
        //GIVEN
        PatientNote patientNote = new PatientNote(25,12, LocalDate.now(),"testNote");
        Mockito.when(patientNoteRepository.existsById(patientNote.getNoteId())).thenReturn(true);

        //WHEN
        boolean patientNotesDelete = patientNoteService.deletingPatientNote(patientNote.getNoteId());

        //THEN
        Mockito.verify(patientNoteRepository, Mockito.times(1)).existsById(patientNote.getNoteId());
        Mockito.verify(patientNoteRepository, Mockito.times(1)).deleteById(patientNote.getNoteId());
        Assertions.assertTrue(patientNotesDelete);
    }
}
