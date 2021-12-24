package com.abernathyclinic.MediscreenNotesHistory;

import com.abernathyclinic.MediscreenNotesHistory.models.PatientNote;
import com.abernathyclinic.MediscreenNotesHistory.services.PatientNoteService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Component
public class InitialData {

    private PatientNoteService patientNoteService;

    public InitialData(PatientNoteService patientNoteService) {
        this.patientNoteService = patientNoteService;
    }


    @PostConstruct
    public void creatingPatients() {
        PatientNote patient1 = new PatientNote(1, "test1");
        PatientNote patient2 = new PatientNote(1, "test1");
        PatientNote patient3 = new PatientNote(1, "test1");
        PatientNote patient4 = new PatientNote(1, "test1");
        List<PatientNote> patients = Arrays.asList(patient1, patient2, patient3, patient4);
        for (PatientNote patient : patients) {
            patientNoteService.creatingPatientNote(patient);
        }
    }

}
