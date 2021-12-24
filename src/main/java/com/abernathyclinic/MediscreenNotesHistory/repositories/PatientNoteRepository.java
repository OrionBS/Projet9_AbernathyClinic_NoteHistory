package com.abernathyclinic.MediscreenNotesHistory.repositories;

import com.abernathyclinic.MediscreenNotesHistory.models.PatientNote;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientNoteRepository extends MongoRepository<PatientNote, Integer> {

    List<PatientNote> findByPatientId(Integer patientId);
}
