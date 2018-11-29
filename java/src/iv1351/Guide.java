package iv1351;

import java.util.ArrayList;

public class Guide {
    private String name;
    private String personNr;
    private ArrayList<Language> langs;
    private Boolean changed;

    public Guide(String name, String personNr) {
        this.name = name;
        this.personNr = personNr;
        this.langs = new ArrayList<>();
        this.changed = false;
    }

    public Guide(String name, String personNr, ArrayList<Language> langs) {
        this.name = name;
        this.personNr = personNr;
        this.langs = langs;
        this.changed = false;
    }

    public String getName() {
        return name;
    }

    public String getPersonNr() {
        return personNr;
    }

    public void addLanguage(Language lang){
        this.langs.add(lang);
        this.changed = true;
    }

    public ArrayList<Language> getLangs() {
        return langs;
    }

    private static Guide[] getMockGuides(){
        ArrayList<Language> langs = Language.getLangs();

        Guide linus = new Guide("Linus", "9709157416");
        Guide josef = new Guide("Josef", "9701032345");
        Guide bader = new Guide("Bader", "8103871082");

        linus.addLanguage(langs.get(0));
        linus.addLanguage(langs.get(1));
        linus.addLanguage(langs.get(2));

        josef.addLanguage(langs.get(0));
        josef.addLanguage(langs.get(1));
        josef.addLanguage(langs.get(3));

        bader.addLanguage(langs.get(0));
        bader.addLanguage(langs.get(1));
        bader.addLanguage(langs.get(3));
        bader.addLanguage(langs.get(4));

        return new Guide[]{linus, josef, bader};
    }

    public static ArrayList<Guide> getGuides (){
        ArrayList<Guide> guides = new ArrayList<>();
        Guide[] mockGuides = Guide.getMockGuides();

        for (Guide g : mockGuides){
            guides.add(g);
        }

        return guides;
    }

    public void save(){

    }

    @Override
    public String toString() {
        return name + " (" + personNr + ")";
    }
}
