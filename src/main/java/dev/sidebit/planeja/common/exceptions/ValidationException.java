package dev.sidebit.planeja.common.exceptions;

import dev.sidebit.planeja.common.validation.FieldInvalid;

import java.util.List;

public class ValidationException extends RuntimeException {

    private final List<FieldInvalid> fieldsInvalids;

    public ValidationException(List<FieldInvalid> fieldsInvalids){
        super("Erro de validação.");
        this.fieldsInvalids = fieldsInvalids;
    }

    public List<FieldInvalid> getFieldsInvalids(){
        return fieldsInvalids;
    }
}
