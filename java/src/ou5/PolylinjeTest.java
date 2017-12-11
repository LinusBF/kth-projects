package ou5;

/**
 * Created by Linus on 2017-12-10.
 */
public class PolylinjeTest {
    public static void main(String[] args) {
        Punkt a = new Punkt("a", 1, 2);
        Punkt b = new Punkt("b", 2, 3);
        Punkt c = new Punkt("c", 3, 4);
        Punkt d = new Punkt("d", 4, 5);
        Punkt e = new Punkt("e", 5, 6);
        Punkt f = new Punkt("f", 6, 7);

        Punkt[] h = {a,b,c,e,f};

        Polylinje pl1 = new Polylinje(h);

        Punkt[] h1 = pl1.getHorn();

        System.out.println(pl1.toString());

        pl1.laggTillFramfor(d, "e");

        System.out.println(pl1.toString());

        Punkt g = new Punkt("g", 7, 8);

        pl1.laggTill(g);

        String s = "";
        for (Punkt p : h1) {
            s += p.toString() + ", ";
        }
        System.out.println(s);

        System.out.println(pl1.toString());

        pl1.taBort("d");

        System.out.println(pl1.toString());

        Polylinje.PolylinjeIterator iterator = pl1.new PolylinjeIterator();
        System.out.println("\n\n\nITERATOR:");
        while (iterator.finnsHorn()){
            System.out.println(iterator.horn().toString());
            iterator.gaFram();
        }

    }
}
