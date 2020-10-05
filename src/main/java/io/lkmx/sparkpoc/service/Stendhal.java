package io.lkmx.sparkpoc.service;


import io.lkmx.sparkpoc.domain.StendhalDomain;
import io.lkmx.sparkpoc.domain.utils.CsvUtils;
import io.lkmx.sparkpoc.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Stendhal {

    @Autowired
    StendhalDomain stendhalDomain;

    @PostMapping(value = "/doctors", consumes = "multipart/form-data")
    public void saveDoctors(@RequestParam("file") MultipartFile file) throws IOException {
        List<Doctor> doctors = new ArrayList<>(CsvUtils.read(Doctor.class, file.getInputStream()));

        stendhalDomain.saveDoctors(doctors);
    }

    @PostMapping(value = "/ingest")
    public void saveDoctors(@RequestParam("index") String index) {
        stendhalDomain.ingest(index);
    }

}
