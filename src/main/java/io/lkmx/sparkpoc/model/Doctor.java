package io.lkmx.sparkpoc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.io.Serializable;

@Data
public class Doctor implements Serializable{

    @JsonProperty("CÉDULA PROFESIONAL")
    private String professionalLicense;

    @JsonProperty("NOMBRE COMPLETO DEL MÉDICO")
    private String name;

    @JsonProperty("DIRECCION")
    private String address;

    @JsonProperty("COLONIA")
    private String sector;

    @JsonProperty("CODIGO_POSTAL")
    private String zipCode;

    @JsonProperty("MUNICIPIO")
    private String town;

    @JsonProperty("ESTADO")
    private String state;

    @JsonProperty("ESPECIALIDAD")
    private String specialty;

    @JsonProperty("ESPECIALIDAD 2")
    private String specialty2;

    @JsonProperty("TELEFONO")
    private String phone;

    @JsonProperty("NOMBRE_LINEA")
    private String line;

    @JsonProperty("CÓDIGO LÍDER / LF")
    private String leadCode;

    @JsonProperty("COD_CIU")
    private String cityCode;

    @JsonProperty("CAMPO_ADICIONAL")
    private String extraField;

    @JsonProperty("Código Close-Up de Médico")
    private Long closeUpCode;

    public String getProfessionalLicense() {
        return professionalLicense;
    }

    public void setProfessionalLicense(String professionalLicense) {
        this.professionalLicense = professionalLicense;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getSpecialty2() {
        return specialty2;
    }

    public void setSpecialty2(String specialty2) {
        this.specialty2 = specialty2;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getLeadCode() {
        return leadCode;
    }

    public void setLeadCode(String leadCode) {
        this.leadCode = leadCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getExtraField() {
        return extraField;
    }

    public void setExtraField(String extraField) {
        this.extraField = extraField;
    }

    public Long getCloseUpCode() {
        return closeUpCode;
    }

    public void setCloseUpCode(Long closeUpCode) {
        this.closeUpCode = closeUpCode;
    }

    public Doctor(String professionalLicense, String name, String address, String sector, String zipCode, String town,
                  String state, String specialty, String specialty2, String phone, String line, String leadCode, String cityCode, String extraField, Long closeUpCode) {
        this.professionalLicense = professionalLicense;
        this.name = name;
        this.address = address;
        this.sector = sector;
        this.zipCode = zipCode;
        this.town = town;
        this.state = state;
        this.specialty = specialty;
        this.specialty2 = specialty2;
        this.phone = phone;
        this.line = line;
        this.leadCode = leadCode;
        this.cityCode = cityCode;
        this.extraField = extraField;
        this.closeUpCode = closeUpCode;
    }

    public Doctor() {
        super();
    }
}
