package org.cloudbus.cloudsim.examples;

/**
 * Can represent a position as well as a velocity.
 */
class Vector {

    public int a, b, c, d, e;
    Vector () {
        this(0, 0, 0,0,0);
    }

    Vector (int a, int b, int c, int d, int e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }

    int getA () {
        return a;
    }

    int getB () {
        return b;
    }

    int getC () {
        return c;
    }
    
    int getD () {
        return d;
    }
    
    int getE () {
        return e;
    }

    void set (int a, int b, int c, int d, int e) {
        setA(a);
        setB(b);
        setC(c);
        setD(d);
        setE(e);
    }

    private void setA (int a) {
        this.a = a;
    }

    private void setB (int b) {
        this.b = b;
    }

    private void setC (int c) {
        this.c = c;
    }
    
    private void setD (int d) {
        this.d = d;
    }
    
    private void setE (int e) {
        this.e = e;
    }

    void add (Vector v) {
        a += v.a;
        b += v.b;
        c += v.c;
        d += v.d;
        e += v.e;
        
    }

    void sub (Vector v) {
    	a -= v.a;
        b -= v.b;
        c -= v.c;
        d -= v.d;
        e -= v.e;
        
    }

    void mul (double s) {
        a *= s;
        b *= s;
        c *= s;
        d *= s;
        e *= s;
        
    }

    void div (double s) {
        a /= s;
        b /= s;
        c /= s;
        d /= s;
        e /= s;
        
    }

    public Vector clone () {
        return new Vector(a, b, c, d, e);
    }

    public String toString () {
        return "(" + a + ", " + b + ", " + c + ", " + d + ", " + e + ")";
    }

}
