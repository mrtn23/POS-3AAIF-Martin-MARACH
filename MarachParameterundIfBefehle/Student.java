public class Student
{
    private String name;
    private float kg;
    private int cm;
    private char gender;
    public float BMI;
    public String gewichtsklasse;

    //constructor
    // name: min 3 max 50 char
    public Student (String name, float kg, int cm, char gender){
        this.setName(name);
        this.setKg(kg);
        this.setCm(cm);
        this.setGender(gender);
    }

    public Student (String name, boolean isMann, int cm, int kg){
        this.setName(name);
        this.setKg(kg);
        this.setCm(cm);
        if (isMann){
            this.setGender('m');
        } else {
            this.setGender('w');
        }
    }
    
    public void setName (String name){
        if(name.length() < 3 || name.length () > 50){
            throw new IllegalArgumentException("Name muss 3 bis 50 Buchstaben lang sein");
        }
        //Ab hier weiß ich dass Name meinen Kriterien entspricht
        this.name = name; //setter für name (namen erstellen)
    }

    public void setKg (float kg){
        if(kg < 2 || kg > 635){
            throw new IllegalArgumentException("Du existierst nicht");
        }
        this.kg = kg; //setter für kg
    }

    public void setCm (int cm){
        if(cm < 50 || cm > 250){
            throw new IllegalArgumentException("Du existierst nicht");
        }
        this.cm = cm; //setter für cm
    }

    public void setGender (char gender){
        //akzeptiere hier nur 'm' oder 'f/w' sowie 'M' oder 'F/W'
        gender = Character.toLowerCase(gender);
        //jetzt ist gender mit Sicherheit klein
        if(gender != 'm' && gender != 'w') {
            throw new IllegalArgumentException("Es gibt nur zwei du wappla");
        } 
        this.gender = gender;
    }

    //BMI kalkulieren
    public float BMI (){
        return this.kg/((this.cm/100.0f)*(this.cm/100.0f));
    }

    public String mannOderFrau (){
        if(this.gender == 'm') {
            return "männlich";
        } else if(this.gender =='w') {
            return "weiblich" ;  
        } else {
            return "invalid";
        }
    }

    public String printStudent (){
        return "Name: " + this.name + " (" + this.mannOderFrau() + ")";
    }

    public String gewichtsklasse() {
        if (this.gender == 'm') {
            if (BMI() < 20) {
                return "Untergewicht";
            } else if (BMI() < 25 && BMI() > 20) { // keine doppelte Prüfung nötig
                return "Normalgewicht";
            } else {
                return "Übergewicht";
            }
        } 
        else if (this.gender == 'w') {
            if (BMI() < 19) {
                return "Untergewicht";
            } 
            else if (BMI() < 24 && BMI() > 19) {
                return "Normalgewicht";
            } 
            else {
                return "Übergewicht";
            }
        } 
        else {
            return "kein Geschlecht angegeben";
        }
    }
}

    
