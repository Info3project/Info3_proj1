package utilities;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Zentralverwaltung zv = Zentralverwaltung.getInstance();
		System.out.println("*****Zentralverwaltung erstellt:" + zv);
		zv.createPrototypen();
		System.out.println("*****Prototypen erstellt: " + zv);
		zv.addStep(new Prototyp("If"));
		zv.addStep(new Prototyp("Goto"));
		System.out.println("*****commands hinzugefügt: "+ zv);

	}

}
