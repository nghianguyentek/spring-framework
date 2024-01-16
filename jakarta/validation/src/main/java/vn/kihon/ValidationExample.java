package vn.kihon;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.NotNull;

class ValidationExample {
    public static void main(String[] args) {
        MyBean myBean = new MyBean();

        try (ValidatorFactory validatorFactory = Validation.byProvider()) {
            Validator validator = validatorFactory.getValidator();
            validator.validate(myBean);
        }

        try (ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory()) {
            Validator validator = validatorFactory.getValidator();
            validator.validate(myBean);
        }
    }

    void print(MyBean myBean) {
        System.out.println(myBean.name);
    }

    static class MyBean {
        @NotNull
        private String name;
    }
}
