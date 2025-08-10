package dev.paydev.paydev.utils.exception;

public class TransactionExceptionHandler extends RuntimeException {
    public TransactionExceptionHandler(String message) {
        super(message);
    }
}
