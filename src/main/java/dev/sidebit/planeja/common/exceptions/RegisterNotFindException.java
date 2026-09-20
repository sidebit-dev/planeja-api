package dev.sidebit.planeja.common.exceptions;

public class RegisterNotFindException extends RuntimeException {

    public RegisterNotFindException() {
        super("Registro não encontrado.");
    }
}
