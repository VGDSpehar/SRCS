package srcs.persistance;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class PersistanceArray {
    //question 1
    public static void saveArrayInt(String f, int[] tab) throws IOException {
        DataOutputStream os = new DataOutputStream(new FileOutputStream(f));
        os.writeInt(tab.length);
        for(int i : tab) {
            os.writeInt(i);
        }
        os.close();
    }
    //question 
    public static int[] loadArrayInt(String fichier)throws IOException  {
        //pour éviter de parcourir 2 fois le fichier(comptage puis écriture)
        DataInputStream is = new DataInputStream(new FileInputStream(fichier));
        int r;
        int size;
        size = is.readInt();
        int [] res = new int[size];
        for(int i=0; i<size; i++) {
        	r = is.readInt();
        	res[i] = r;
        }
        return res;
    }
    //question 3 :


}
