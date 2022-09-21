package com.example.projetotcc.Class;

public class Offer {
    private String id;
    private String idProduct;
    private String idService;
    private String solicitation;
    private boolean finish;
    private boolean cancel;

    public Offer(String id, String idProduct, String idService, String solicitation, boolean finish, boolean cancel) {
        this.id = id;
        this.idProduct = idProduct;
        this.idService = idService;
        this.solicitation = solicitation;
        this.finish = finish;
        this.cancel = cancel;
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

    public String getSolicitation() {
        return solicitation;
    }

    public void setSolicitation(String solicitation) {
        this.solicitation = solicitation;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public boolean isCancel() {
        return cancel;
    }

    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }
}
