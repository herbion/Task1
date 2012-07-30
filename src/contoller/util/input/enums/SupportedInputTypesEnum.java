package contoller.util.input.enums;

public enum SupportedInputTypesEnum {
    INT(Integer.class), DOUBLE(Double.class);
    private Class<? extends Number> cls;

    SupportedInputTypesEnum(Class<? extends Number> cls) {
	this.cls = cls;
    }

    public Class<? extends Number> getEncapsulatedType() {
	return cls;
    }
}
