package dev.sidebit.planeja.common.validation;

import java.util.ArrayList;
import java.util.List;

public class ValidationResult {

    private List<FieldInvalid> fieldInvalids;

    private ValidationResult(List<FieldInvalid> fieldInvalids) {
        this.fieldInvalids = fieldInvalids;
    }

    public static ValidationResult newCard(){
        return new ValidationResult(new ArrayList<>());
    }

    public void add(FieldInvalid fieldInvalid){
        this.fieldInvalids.add(fieldInvalid);
    }

    public List<FieldInvalid> getFieldInvalids(){
        return fieldInvalids;
    }

    public boolean isInvalid(){
        return !fieldInvalids.isEmpty();
    }
}
