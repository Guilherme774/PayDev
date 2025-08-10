package dev.paydev.paydev.domain.ViewModels;

public class TransactionViewModel {
    private Long userSenderId;
    private Long userReceiverId;
    private double ammount;

    public TransactionViewModel() { }

    public TransactionViewModel(Long userSenderId, Long userReceiverId, double ammount) {
        this.userSenderId = userSenderId;
        this.userReceiverId = userReceiverId;
        this.ammount = ammount;
    }

    public Long getUserSenderId() {
        return userSenderId;
    }

    public Long getUserReceiverId() {
        return userReceiverId;
    }

    public double getAmmount() {
        return ammount;
    }

    public void setUserSenderId(Long userSenderId) {
        this.userSenderId = userSenderId;
    }

    public void setUserReceiverId(Long userReceiverId) {
        this.userReceiverId = userReceiverId;
    }

    public void setAmmount(double ammount) {
        this.ammount = ammount;
    }
}
