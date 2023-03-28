package cliente.enums;

public enum EnumDepartamento {

    RECURSOS_HUMANOS,
    DESENVOLVIMENTO,
    FINANCAS;

    public static EnumDepartamento fromString(String departamento) {
        switch (departamento) {
            case "RECURSOS_HUMANOS": return RECURSOS_HUMANOS;
            case "DESENVOLVIMENTO": return DESENVOLVIMENTO;
            case "FINANCAS": return FINANCAS;
            case "": return null;
            default: throw new EnumConstantNotPresentException(EnumDepartamento.class, departamento);
        }
    }
}
