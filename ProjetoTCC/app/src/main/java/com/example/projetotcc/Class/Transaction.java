package com.example.projetotcc.Class;

public class Transaction {

    private String id;
    private String idOffer;
    private String idCounter;
    private boolean finish;
    private boolean cancel;

    public Transaction(String id, String idOffer, String idCounter, boolean finish, boolean cancel) {
        this.id = id;
        this.idOffer = idOffer;
        this.idCounter = idCounter;
        this.finish = finish;
        this.cancel = cancel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdOffer() {
        return idOffer;
    }

    public void setIdOffer(String idOffer) {
        this.idOffer = idOffer;
    }

    public String getIdCounter() {
        return idCounter;
    }

    public void setIdCounter(String idCounter) {
        this.idCounter = idCounter;
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
