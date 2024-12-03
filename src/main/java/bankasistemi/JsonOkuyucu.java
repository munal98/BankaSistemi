package bankasistemi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonOkuyucu {
    public static List<Kullanici> kullanicilariOku(String dosyaYolu) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(dosyaYolu), new TypeReference<List<Kullanici>>() {});
    }
}
