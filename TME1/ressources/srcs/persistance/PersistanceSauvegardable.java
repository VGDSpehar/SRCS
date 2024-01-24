package srcs.persistance;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class PersistanceSauvegardable {
    public static void save(String fichier, Sauvegardable s) throws IOException{
        OutputStream out = new FileOutputStream(fichier);
        DataOutputStream dos = new DataOutputStream(out);
        dos.writeUTF(s.getClass().getCanonicalName());
        s.save(out);
        out.close();
    }
    public static Sauvegardable load(String fichier) throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        InputStream in = new FileInputStream(fichier);
        DataInputStream di = new DataInputStream(in);
        String className = di.readUTF();
        Class<?> cl = Class.forName(className);
        Constructor<?> constr = cl.getConstructor(InputStream.class);
        Sauvegardable instance = (Sauvegardable) constr.newInstance(in);

        in.close();
        return instance;
    }
}
