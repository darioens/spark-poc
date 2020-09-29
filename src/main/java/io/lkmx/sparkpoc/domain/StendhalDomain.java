package io.lkmx.sparkpoc.domain;

import io.lkmx.sparkpoc.model.Doctor;

import java.util.List;

public interface StendhalDomain {
    void saveDoctors(List<Doctor> doctors);
}
