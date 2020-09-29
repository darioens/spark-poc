package io.lkmx.sparkpoc.domain.impl;

import io.lkmx.sparkpoc.domain.StendhalDomain;
import io.lkmx.sparkpoc.model.Doctor;
import lombok.extern.slf4j.Slf4j;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoder;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Properties;

@Service
@Slf4j
public class DefaultStendhalDomain  implements StendhalDomain {

    @Autowired
    SparkSession spark;

    @Autowired
    Properties jdbcProperties;

    @Value("${host}")
    private String host;

    @Value("${stendhal.doctors}")
    private String doctorsTable;

    @Override
    public void saveDoctors(List<Doctor> doctors) {
        Encoder<Doctor> encoder = Encoders.bean(Doctor.class);
        Dataset<Doctor> dataset = spark.createDataset(doctors, encoder);
        dataset.show();
        dataset.write().jdbc(host, doctorsTable, jdbcProperties);
    }
}
