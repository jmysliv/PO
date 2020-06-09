import static java.lang.StrictMath.sqrt;

public class SquarePegAdapter extends RoundPeg{

    private SquarePeg peg;

    @Override
    public int getRadius() {
        return (int) Math.ceil(peg.getWidth()*sqrt(2)/2);
    }

    public SquarePegAdapter(SquarePeg peg) {
        super(0);
        this.peg = peg;
    }


}
