package this_super.super_kw;

public class Ferrari extends Cars{

    boolean isAutomatic = true;

    public Ferrari() {
        super();
        System.out.println("This is a Ferrari");
    }

    public void printGearType() {
        System.out.println("Ferrari is automatic: " + this.isAutomatic);
        System.out.println("Cars is automatic: " + super.isAutomatic);
        super.howFastDoesItGo();
        this.howFastDoesItGo();
    }

    @Override
    void howFastDoesItGo() {
        System.out.println("Ferrari can go up to 350 km/h");
    }
}
