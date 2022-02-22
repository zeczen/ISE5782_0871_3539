package primitives;


public class Vector extends Point {

    static public final double ACCURACY = 0.00001;
    /**
     * the head of the vector
     */


    /**
     * vector constructor
     *
     * @param x the head x value
     * @param y the head y value
     * @param z the head z value
     */
    public Vector(double x, double y, double z) {
        super(x, y, z);
        if (coordinate.equals(Double3.ZERO)) {
            throw new IllegalArgumentException("WRONG INPUT: cannot receive zero vector");
        }
    }

    /**
     * vector constructor
     *
     * @param head the head of vector
     */
    public Vector(Point head) {
        super(head);
        if (head.coordinate.equals(Double3.ZERO)) {
            throw new IllegalArgumentException("WRONG INPUT: cannot receive zero vector");
        }
    }

    /**
     * vectors addition
     *
     * @param vec
     * @return sum of vectors
     */
    public Vector add(Vector vec) {
        return new Vector(super.add(vec));
    }


    /**
     * vector multiplication by scalar
     *
     * @param d
     * @return multiplied vector
     */
    public Vector scale(double d) {
        return new Vector(new Point(this.coordinate.scale(d)));
    }

    /**
     * scalar multiplication between two vectors
     *
     * @param vec
     * @return scalar
     */
    public double dotProduct(Vector vec) {

        return this.coordinate.d1 * vec.coordinate.d1 +
                this.coordinate.d2 * vec.coordinate.d2 +
                this.coordinate.d3 * vec.coordinate.d3;
    }

    /**
     * vector multiplication between two vectors
     *
     * @param vec
     * @return vector
     */
    public Vector crossProduct(Vector vec) {
        return new Vector(this.coordinate.d2 * vec.coordinate.d3 - this.coordinate.d3 * vec.coordinate.d2,
                this.coordinate.d3 * vec.coordinate.d1 - this.coordinate.d1 * vec.coordinate.d3,
                this.coordinate.d1 * vec.coordinate.d2 - this.coordinate.d2 * vec.coordinate.d1);
    }

    /**
     * squared length of vector
     *
     * @return squared length
     */
    public double lengthSquared() {
        return super.lengthSquared(Point.ZERO);
    }

    /**
     * length of vector
     *
     * @return length
     */
    public double length() {
        return super.length(Point.ZERO);
    }

    /**
     * normalize vector
     *
     * @return a new vector is return
     */
    public Vector normalized() {
        final double size = this.length();
        return new Vector(new Point(this.coordinate.reduce(size)));
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Vector) &&
                this.coordinate.equals(((Vector) o).coordinate);
    }

    @Override
    public String toString() {
        return "Vec{" + coordinate + '}';
    }


}