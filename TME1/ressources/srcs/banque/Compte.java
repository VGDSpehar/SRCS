package srcs.banque;

import java.io.OutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import srcs.persistance.*;

public class Compte implements Sauvegardable{

	
	
	private final String id;
	private double solde;
	

	public Compte(String id) {
		this.id=id;	
		this.solde=0.0;
	}

	public Compte(InputStream in) throws IOException{
		DataInputStream is = new DataInputStream(in);
		int len = is.readInt();
		byte buf[] = new byte[len];
		is.read(buf);
		this.id = new String(buf);
		this.solde = is.readDouble();
		is.close();
	}
		
	public String getId() {
		return id;
	}

	public double getSolde() {
		return solde;
	}

	public void crediter(double montant) {
		solde += montant;
	}

	public void debiter(double montant) {
		solde -= montant;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o==this) return true;
		if(o==null) return false;
		if(!(o instanceof Compte)) return false;
		Compte other= (Compte) o;
		return other.id.equals(id);
	}
	@Override
	public int hashCode() {
		return id.hashCode();
	}
	@Override
	public void save(OutputStream out) throws IOException {
		DataOutputStream os = new DataOutputStream(out);
		byte buf[] = this.id.getBytes();
		os.writeInt(buf.length);
		os.write(buf);
		os.writeDouble(this.solde);
		os.close();
	}
	
}
