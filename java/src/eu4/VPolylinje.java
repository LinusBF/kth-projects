package eu4;

import java.util.Iterator;

/**
 * Created by Linus on 2017-12-13.
 */
public class VPolylinje implements Polylinje {
    private Punkt[] horn;
    private String farg = "svart";
    private int bredd = 1;

    public VPolylinje(Punkt[] horn) {
        this.horn = horn;
    }

    public VPolylinje() {
        this.horn = new Punkt[0];
    }

    @Override
    public Punkt[] getHorn() {
        return this.horn;
    }

    @Override
    public String getFarg() {
        return this.farg;
    }

    @Override
    public int getBredd() {
        return 0;
    }

    @Override
    public double langd() {
        double l = 0;

        for (int i = 0; i < this.horn.length - 1; i++){
            l += this.horn[i].avstand(this.horn[i + 1]);
        }

        return l;
    }

    @Override
    public void setFarg(String farg) {
        this.farg = farg;
    }

    @Override
    public void setBredd(int bredd) {

    }

    @Override
    public void laggTill(Punkt horn) {
        Punkt[] h = new Punkt[this.horn.length + 1];
        int i = 0;
        for (i = 0; i < this.horn.length; i++)
            h[i] = this.horn[i];
        h[i] = new Punkt (horn);
        this.horn = h;
    }

    @Override
    public void laggTillFramfor(Punkt horn, String hornNamn) {

    }

    @Override
    public void taBort(String hornNamn) {

    }

    @Override
    public Iterator<Punkt> iterator() {
        return new Iterator<Punkt>() {
            private int i = -1;

            @Override
            public boolean hasNext() {
                return i < VPolylinje.this.horn.length - 1;
            }

            private void forward(){
                if (i < VPolylinje.this.horn.length - 1)
                    i++;
                else
                    i = -1;
            }

            @Override
            public Punkt next() {
                forward();
                return VPolylinje.this.horn[this.i];
            }
        };
    }

    @Override
    public String toString() {
        String hornStr = "";

        for (Punkt punkt : this.horn) {
            hornStr += "(" + punkt + ") ";
        }

        return "{[" + hornStr + "], " + this.farg + ", " + this.bredd + "}";
    }
}
