public class Complex {
    private final double re;
    private final double im;

    public Complex(){
        re = 0.0;
        im = 0.0;
    }

    public Complex(double re, double im){
        this.re = re;
        this.im = im;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        // re = 1.0, im = 2.0 -> 1.0 + 2.0i
        // re = 2.0, im = 1.0 -> 2.0 + i
        // re = 0.0, im = -3.0 -> -3.0i
        if (re != 0.0 || im == 0.0) sb.append(re);
        if (im != 0.0) {
            if (im < 0.0) sb.append("-");
            else if (re != 0.0) sb.append("+");
            if (im != 1.0 && im != -1.0) sb.append(Math.abs(im));
            if (Double.valueOf(im).isInfinite() || Double.valueOf(im).isNaN()) sb.append(" ");
            sb.append("i");
        }
        return sb.toString();
    }

    public Complex plus(Complex other){
        return new Complex(this.re + other.re, im + other.im);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Complex other){
            return this.re == other.re && this.im == other.im;
        }
        return false;
    }

    @Override
    public int hashCode() {
        var sum = 0;
        sum += 31 * sum + Double.hashCode(re);
        sum += 31 * sum + Double.hashCode(im);
        return sum;
    }
}
