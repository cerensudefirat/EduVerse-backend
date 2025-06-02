package com.EduVerse.DtoRelations;

public class DtoCertifica {

    private Integer certificaId;
    private String certificaTitle;
    private String certificaDescription;

    public DtoCertifica(Integer certificaId, String certificaTitle, String certificaDescription) {
        this.certificaId = certificaId;
        this.certificaTitle = certificaTitle;
        this.certificaDescription = certificaDescription;
    }

    public DtoCertifica() {
    }

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
