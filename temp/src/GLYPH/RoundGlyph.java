package GLYPH;

public class RoundGlyph extends Glyph {
    int radius =1;

    public RoundGlyph(int radiu) {
        this.radius = radiu;
        System.out.println("RoundGlyph.RoundGlyph(), radius="+radius);
    }

    @Override
    void draw() {
        System.out.println("RoundGlyph.draw(),radius = "+radius);
    }
}
