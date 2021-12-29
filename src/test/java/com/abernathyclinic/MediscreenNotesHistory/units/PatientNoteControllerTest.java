package com.abernathyclinic.MediscreenNotesHistory.units;

import com.abernathyclinic.MediscreenNotesHistory.controllers.PatientNoteController;
import com.abernathyclinic.MediscreenNotesHistory.models.PatientNote;
import com.abernathyclinic.MediscreenNotesHistory.services.impl.PatientNoteServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PatientNoteControllerTest {

    @InjectMocks
    private PatientNoteController patientNoteController;

    @Mock
    private PatientNoteServiceImpl patientNoteService;

    @Test
    public void testCreatingPatientNote() {
        //GIVEN
        PatientNote patientNote = new PatientNote(12, LocalDate.now(),"testNote");
        Mockito.when(patientNoteService.creatingPatientNote(patientNote)).thenReturn(patientNote);

        //WHEN
        ResponseEntity<Object> patientNoteSave = patientNoteController.creatingPatientNote(patientNote);

        //THEN
        Mockito.verify(patientNoteService, Mockito.times(1)).creatingPatientNote(patientNote);
        Assertions.assertEquals(patientNote,patientNoteSave.getBody());
        Assertions.assertEquals(HttpStatus.CREATED, patientNoteSave.getStatusCode());
    }

    @Test
    public void testCreatingPatientNoteWithError() {
        //GIVEN
        PatientNote patientNote = new PatientNote(12, LocalDate.now(),"testNote");
        Mockito.when(patientNoteService.creatingPatientNote(patientNote)).thenReturn(null);

        //WHEN
        ResponseEntity<Object> patientNoteSave = patientNoteController.creatingPatientNote(patientNote);

        //THEN
        Mockito.verify(patientNoteService, Mockito.times(1)).creatingPatientNote(patientNote);
        Assertions.assertEquals("La note patient est incorrect.",patientNoteSave.getBody());
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, patientNoteSave.getStatusCode());
    }

    @Test
    public void testReadingPatientNote() {
        //GIVEN
        PatientNote patientNote = new PatientNote(25,12, LocalDate.now(),"testNote");
        List<PatientNote> patientNotes = Collections.singletonList(patientNote);
        Mockito.when(patientNoteService.readingPatientNotes(patientNote.getPatientId())).thenReturn(patientNotes);

        //WHEN
        ResponseEntity<Object> patientNoteRead = patientNoteController.readingPatientNotes(patientNote.getPatientId());

        //THEN
        Mockito.verify(patientNoteService, Mockito.times(1)).readingPatientNotes(patientNote.getPatientId());
        Assertions.assertEquals(patientNotes,patientNoteRead.getBody());
        Assertions.assertEquals(HttpStatus.OK, patientNoteRead.getStatusCode());
    }

    @Test
    public void testReadingPatientNoteWithError() {
        //GIVEN
        PatientNote patientNote = new PatientNote(25,12, LocalDate.now(),"testNote");
        List<PatientNote> patientNotes = Collections.singletonList(patientNote);
        Mockito.when(patientNoteService.readingPatientNotes(patientNote.getPatientId())).thenReturn(null);

        //WHEN
        ResponseEntity<Object> patientNoteRead = patientNoteController.readingPatientNotes(patientNote.getPatientId());

        //THEN
        Mockito.verify(patientNoteService, Mockito.times(1)).readingPatientNotes(patientNote.getPatientId());
        Assertions.assertEquals("La note patient recherché est inconnu.",patientNoteRead.getBody());
        Assertions.assertEquals(HttpStatus.NOT_FOUND, patientNoteRead.getStatusCode());
    }

    @Test
    public void testUpdatingPatientNote() {
        //GIVEN
        PatientNote patientNote = new PatientNote(25,12, LocalDate.now(),"testNote");
        Mockito.when(patientNoteService.updatingPatientNote(patientNote)).thenReturn(patientNote);

        //WHEN
        ResponseEntity<Object> patientNoteUpdate = patientNoteController.updatingPatientNote(patientNote);

        //THEN
        Mockito.verify(patientNoteService, Mockito.times(1)).updatingPatientNote(patientNote);
        Assertions.assertEquals(patientNote,patientNoteUpdate.getBody());
        Assertions.assertEquals(HttpStatus.OK, patientNoteUpdate.getStatusCode());
    }

    @Test
    public void testUpdatingPatientNoteWithError() {
        //GIVEN
        PatientNote patientNote = new PatientNote(25,12, LocalDate.now(),"testNote");
        Mockito.when(patientNoteService.updatingPatientNote(patientNote)).thenReturn(null);

        //WHEN
        ResponseEntity<Object> patientNoteUpdate = patientNoteController.updatingPatientNote(patientNote);

        //THEN
        Mockito.verify(patientNoteService, Mockito.times(1)).updatingPatientNote(patientNote);
        Assertions.assertEquals("La note patient mis à jour est incorrect ou inconnu.",patientNoteUpdate.getBody());
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, patientNoteUpdate.getStatusCode());
    }

    @Test
    public void testDeletingPatientNote() {
        //GIVEN
        PatientNote patientNote = new PatientNote(25,12, LocalDate.now(),"testNote");
        Mockito.when(patientNoteService.deletingPatientNote(patientNote.getNoteId())).thenReturn(true);

        //WHEN
        ResponseEntity<Object> patientNoteDelete = patientNoteController.detetingPatientNote(patientNote.getNoteId());

        //THEN
        Mockito.verify(patientNoteService, Mockito.times(1)).deletingPatientNote(patientNote.getNoteId());
        Assertions.assertEquals(true,patientNoteDelete.getBody());
        Assertions.assertEquals(HttpStatus.OK, patientNoteDelete.getStatusCode());
    }

    @Test
    public void testDeletingPatientNoteWithError() {
        //GIVEN
        PatientNote patientNote = new PatientNote(25,12, LocalDate.now(),"testNote");
        Mockito.when(patientNoteService.deletingPatientNote(patientNote.getNoteId())).thenReturn(false);

        //WHEN
        ResponseEntity<Object> patientNoteDelete = patientNoteController.detetingPatientNote(patientNote.getNoteId());

        //THEN
        Mockito.verify(patientNoteService, Mockito.times(1)).deletingPatientNote(patientNote.getNoteId());
        Assertions.assertEquals("La note patient est inconnu.",patientNoteDelete.getBody());
        Assertions.assertEquals(HttpStatus.NOT_FOUND, patientNoteDelete.getStatusCode());
    }
}
