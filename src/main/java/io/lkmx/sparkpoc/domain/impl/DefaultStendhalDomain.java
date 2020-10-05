package io.lkmx.sparkpoc.domain.impl;

import io.lkmx.sparkpoc.domain.StendhalDomain;
import io.lkmx.sparkpoc.model.Doctor;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Properties;

@Service
public class DefaultStendhalDomain  implements StendhalDomain {


    @Autowired
    Properties jdbcProperties;

    @Value("${host}")
    private String host;

    @Value("${stendhal.doctors}")
    private String doctorsTable;


    @Override
    public void saveDoctors(List<Doctor> doctors) {
        SparkSession sparkSession = SparkSession.builder().appName("appName").master("local[*]").getOrCreate();
        Encoder<Doctor> encoder = Encoders.bean(Doctor.class);
        Dataset<Doctor> dataset = sparkSession.createDataset(doctors, encoder);
        dataset.show();
        dataset.write().jdbc(host, doctorsTable, jdbcProperties);
    }

    @Override
    public void ingest(String index) {
        SparkConf conf = new SparkConf().setAppName("app").setMaster("local[*]");
        conf.set("es.index.auto.create", "true");
        conf.set("es.nodes","https://fffc9a90cf01486f8eef517607ee9241.us-west1.gcp.cloud.es.io");
        conf.set("es.port","9243");
        conf.set("es.net.http.auth.user","elastic");
        conf.set("es.net.http.auth.pass","c6H3iLm0oa5Ip3bTuf3sxjGz");
        conf.set("serializer", "org.apache.spark.serializer.KryoSerializer");
        conf.set("es.index.auto.create", "true");
        conf.set("es.resource", "spark");
        conf.set("es.net.ssl","true");
        conf.set("es.nodes.wan.only", "true");
        JavaSparkContext sparkContext = new JavaSparkContext(conf);
        SparkSession sparkSession = SparkSession.builder().appName("appName").master("local[*]").getOrCreate();
        Dataset<Row> dataset = sparkSession.read().jdbc(host,index,jdbcProperties);
        dataset.show();
        // TODO: Convert data set into JavaRDD<java.util.Map<String, ?>> in order to use saveToEs
        //JavaRDD<java.util.Map<String, ?>> javaRDD = sparkContext.parallelize(dataset);
        //JavaEsSpark.saveToEs(javaRDD, "spark");

    }
}