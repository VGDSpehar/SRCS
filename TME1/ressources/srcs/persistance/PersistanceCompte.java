package srcs.persistance;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import srcs.banque.*;

public class PersistanceCompte {
    public static void saveCompte(String f, Compte e) throws IOException {
        OutputStream out = new FileOutputStream(f);
        e.save(out);
        out.close();
    }

    public static Compte loadCompte(String f) throws IOException {
        InputStream in = new FileInputStream(f);
        Compte c = new Compte(in);
        in.close();
        return c;
    }
}
