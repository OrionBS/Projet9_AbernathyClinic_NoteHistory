package com.abernathyclinic.MediscreenNotesHistory.controllers;

import com.abernathyclinic.MediscreenNotesHistory.models.PatientNote;
import com.abernathyclinic.MediscreenNotesHistory.services.PatientNoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/patHistory")
public class PatientNoteController {

    private final PatientNoteService patientNoteService;

    public PatientNoteController(PatientNoteService patientNoteService) {
        this.patientNoteService = patientNoteService;
    }

    @PostMapping
    public ResponseEntity<Object> creatingPatientNote(@RequestBody PatientNote patientNote) {

        PatientNote patientNoteReceived = patientNoteService.creatingPatientNote(patientNote);

        if(patientNoteReceived == null) {
            return new ResponseEntity<>("La note patient est incorrect.", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(patientNoteReceived, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Object> readingPatientNotes(@RequestParam Integer patientId) {

        List<PatientNote> patientNotesReceived = patientNoteService.readingPatientNotes(patientId);

        if (patientNotesReceived == null) {
            return new ResponseEntity<>("La note patient recherché est inconnu.",HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(patientNotesReceived,HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Object> updatingPatientNote(@RequestBody PatientNote patientNote) {

        PatientNote patientNoteReceived = patientNoteService.updatingPatientNote(patientNote);

        if (patientNoteReceived == null) {
            return new ResponseEntity<>("La note patient mis à jour est incorrect ou inconnu.",HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(patientNoteReceived,HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Object> detetingPatientNote(@RequestParam Integer noteId) {

        boolean answer = patientNoteService.deletingPatientNote(noteId);

        if (!answer) {
            return new ResponseEntity<>("La note patient est inconnu.",HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(answer,HttpStatus.OK);

    }
}
