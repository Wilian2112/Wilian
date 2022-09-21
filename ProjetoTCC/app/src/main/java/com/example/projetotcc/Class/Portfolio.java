package com.example.projetotcc.Class;

public class Portfolio {

    private String id;
    private String idService;

    public Portfolio(String id, String idService) {
        this.id = id;
        this.idService = idService;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }
}
