package utilities;

import java.util.Properties;

@SuppressWarnings("unused")
public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Zentralverwaltung zv = Zentralverwaltung.getInstance();
		System.out.println("*****Zentralverwaltung erstellt:" + zv);
		zv.createPrototypen();
		System.out.println("*****Prototypen erstellt: " + zv);
		zv.addStep(new Prototyp("If"));
		zv.addStep(new Prototyp("Goto"));
		zv.addStep(new Prototyp("Assignment"));
		zv.addStep(new Prototyp("Gear"));
		zv.addStep(new Prototyp("Direction"));
		System.out.println("*****commands hinzugefuegt: " + zv);
		zv.incOrder(3);	
		System.out.println("Goto eins nach oben geschoben: "+ zv);
		System.out.println(zv.decOrder(3));
		System.out.println("Goto eins nach unten geschoben: "+ zv);
//		zv.removeStep(4);
//		System.out.println("*****Assignment geloescht: " + zv);
//		zv.speichern(null, "Speicher");
//		zv.removeStep(4);
//		System.out.println("*****Assignment geloescht: " + zv);
//		zv.speichern(null, "Speicher");
//		zv.laden("Speicher");
//		System.out.println("*****Lock and Load: " + zv);
		
	}

}
