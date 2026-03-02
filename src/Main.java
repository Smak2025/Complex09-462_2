void main() {
    var z1 = new Complex();
    var z2 = new Complex(1.0, 2.0);
    System.out.println(z1);
    System.out.println(z2);
    var z3 = z1.plus(z2);
    System.out.println(z3);
}