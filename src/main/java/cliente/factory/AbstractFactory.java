package cliente.factory;

import java.io.BufferedReader;

public interface AbstractFactory<EntidadeDTO> {
    EntidadeDTO create(BufferedReader bufferedReader, boolean onlyRead, boolean isListar);
}
