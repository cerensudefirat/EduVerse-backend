package com.EduVerse.model;

import jakarta.persistence.*;

@Entity
@Table(name = "certifica")
public class Certifica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer certificaId;

    @Column(name = "certifica_title")
    private String certificaTitle;

    @Column(name = "certifica_description")
    private String certificaDescription;

    public Certifica(Integer certificaId, String certificaTitle, String certificaDescription) {
        this.certificaId = certificaId;
        this.certificaTitle = certificaTitle;
        this.certificaDescription = certificaDescription;
    }
    public Certifica() {}

    public Integer getCertificaId() {
        return certificaId;
    }

    public void setCertificaId(Integer certificaId) {
        this.certificaId = certificaId;
    }

    public String getCertificaTitle() {
        return certificaTitle;
    }

    public void setCertificaTitle(String certificaTitle) {
        this.certificaTitle = certificaTitle;
    }

    public String getCertificaDescription() {
        return certificaDescription;
    }

    public void setCertificaDescription(String certificaDescription) {
        this.certificaDescription = certificaDescription;
    }
}
