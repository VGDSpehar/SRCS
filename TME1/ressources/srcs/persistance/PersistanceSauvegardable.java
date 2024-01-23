package srcs.persistance;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class PersistanceSauvegardable {
    public static void save(String fichier, Sauvegardable s) throws IOException{
        OutputStream out = new FileOutputStream(fichier);
        s.save(out);
        out.close();
    }
    public static Sauvegardable load(String fichier) throws IOException{
        InputStream in = new FileInputStream(fichier);
        Sauvegardable res;
        //vu en TD pour instancier objet dont on ne connaît pas le type à l'avance
        in.close();
        return res;
    }
}
