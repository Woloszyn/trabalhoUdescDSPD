package servidor.entities;

public enum EnumEspecialidades {
    FRONTEND,
    BACKEND,
    DEVOPS;

    public static EnumEspecialidades fromString(String value) throws ClassNotFoundException {
        switch (value) {
            case "FRONTEND": return FRONTEND;
            case "BACKEND": return BACKEND;
            case "DEVOPS": return DEVOPS;
        }
        throw new ClassNotFoundException("Não foi possível encontrar");
    }
}
