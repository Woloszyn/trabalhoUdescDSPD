package cliente.enums;

public enum EnumEspecialidades {
    FRONTEND,
    BACKEND,
    DEVOPS;

    public static EnumEspecialidades fromString(String especialidade) throws EnumConstantNotPresentException {
        switch (especialidade) {
            case "FRONTEND": return FRONTEND;
            case "BACKEND": return BACKEND;
            case "DEVOPS": return DEVOPS;
            default: throw new EnumConstantNotPresentException(EnumEspecialidades.class, especialidade);
        }
    }

}
