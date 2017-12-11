package ou5;

/**
 * Created by Linus on 2017-12-10.
 */
public class Polylinje {
    private Punkt[] horn;
    private String farg = "svart";
    private int bredd = 1;

    public Polylinje()
    {
        this.horn = new Punkt[0];
    }

    public Polylinje(Punkt[] horn)
    {
        this.horn = new Punkt[horn.length];
        for (int i = 0; i < horn.length; i++)
            this.horn[i] = new Punkt (horn[i]);
    }

    public String toString () {
        String hornStr = "";

        for (Punkt punkt : this.horn) {
            hornStr += "(" + punkt + ") ";
        }

        return "{[" + hornStr + "], " + this.farg + ", " + this.bredd + "}";
    }

    public Punkt[] getHorn () {
        Punkt[] h = new Punkt[this.horn.length];
        for (int i = 0; i < this.horn.length; i++)
            h[i] = new Punkt (this.horn[i]);

        return h;
    }

    public String getFarg () {
        return this.farg;
    }

    public int getBredd () {
        return this.bredd;
    }

    public void setFarg (String farg) {
        this.farg = farg;
    }

    public void setBredd (int bredd) {
        this.bredd = bredd;
    }

    public double langd () {
        double l = 0;

        for (int i = 0; i < this.horn.length - 1; i++){
            l += Math.sqrt(Math.pow((this.horn[i + 1].getX() - this.horn[i].getX()), 2) + Math.pow(this.horn[i + 1].getY() - this.horn[i].getY(), 2));
        }

        return l;
    }

    public void laggTill (Punkt horn)
    {
        Punkt[] h = new Punkt[this.horn.length + 1];
        int i = 0;
        for (i = 0; i < this.horn.length; i++)
            h[i] = this.horn[i];
        h[i] = new Punkt (horn);
        this.horn = h;
    }

    public void laggTillFramfor (Punkt horn, String hornNamn) {
        Punkt[] h = new Punkt[this.horn.length + 1];

        int i = 0;
        boolean check = false;
        for (int j = 0; j < this.horn.length + 1; j++) {
            if(!check && this.horn[i].getNamn().equals(hornNamn)){
                h[j] = new Punkt (horn);
                i--;
                check = true;
            }
            else{
                h[j] = this.horn[i];
            }
            i++;
        }

        this.horn = h;
    }

    public void taBort (String hornNamn) {
        Punkt[] h = new Punkt[this.horn.length - 1];
        int i = 0;
        for (int j = 0; j < this.horn.length; j++){
            if(this.horn[j].getNamn().equals(hornNamn)){
                i--;
            } else{
                h[i] = this.horn[j];
            }
            i++;
        }
        this.horn = h;
    }

    public class PolylinjeIterator
    {
        private int aktuell = -1;

        public PolylinjeIterator ()
        {
            if (Polylinje.this.horn.length > 0)
                aktuell = 0;
        }

        public boolean finnsHorn ()
        {
            return aktuell != -1;
        }

        public Punkt horn () throws java.util.NoSuchElementException
        {
            if (!this.finnsHorn ())
                throw new java.util.NoSuchElementException (
                        "slut av iterationen");
            Punkt horn = Polylinje.this.horn[aktuell];
            return horn;
        }

        public void gaFram ()
        {
            if (aktuell >= 0 &&
                    aktuell < Polylinje.this.horn.length - 1)
                aktuell++;
            else
                aktuell = -1;
        }
    }

}
