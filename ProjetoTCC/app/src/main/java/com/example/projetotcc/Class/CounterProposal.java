package com.example.projetotcc.Class;

public class CounterProposal {

    private String id;
    private String idProduct;
    private String idService;
    private String message;

    public CounterProposal(String id, String idProduct, String idService, String message) {
        this.id = id;
        this.idProduct = idProduct;
        this.idService = idService;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
