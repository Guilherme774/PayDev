package dev.paydev.paydev.domain.ViewModels;

public class UserBalanceViewModel {
    private Long userId;
    private double ammount;

    public UserBalanceViewModel() { }

    public UserBalanceViewModel(Long userId, double ammount) {
        this.userId = userId;
        this.ammount = ammount;
    }

    public Long getUserId() {
        return userId;
    }

    public double getAmmount() {
        return ammount;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setAmmount(double ammount) {
        this.ammount = ammount;
    }
}
