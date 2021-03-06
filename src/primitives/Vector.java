

package primitives;


public class Vector extends Point {

    static public final double ACCURACY = 0.00001;

    protected double lenSquared;
    /**
     * the this of the vector
     */


    /**
     * vector constructor
     *
     * @param x the this x value
     * @param y the this y value
     * @param z the this z value
     */
    public Vector(double x, double y, double z) {
        super(x, y, z);
        if (coordinate.equals(Double3.ZERO)) {
            throw new IllegalArgumentException("WRONG INPUT: cannot receive zero vector");
        }
        this.lenSquared = super.distanceSquared(Point.ZERO);
    }

    /**
     * vector constructor
     *
     * @param h the head of vector
     */
    public Vector(Point h) {
        super(h);
        if (this.coordinate.equals(Double3.ZERO)) {
            throw new IllegalArgumentException("WRONG INPUT: cannot receive zero vector");
        }
        this.lenSquared = super.distanceSquared(Point.ZERO);

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
     * @param d - scalar, the factor of the product
     * @return multiplied vector
     */
    public Vector scale(double d) {
        return new Vector(new Point(this.coordinate.scale(d)));
    }

    /**
     * scalar multiplication between two vectors
     *
     * @param vec - vector, the factor of the dotProduct
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
     * @param vec - vector, the factor of the crossProduct
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
        return this.lenSquared;
    }

    /**
     * length of vector
     *
     * @return length
     */
    public double length() {
        return Math.sqrt(this.lengthSquared());
    }

    /**
     * normalize vector
     *
     * @return a new vector is return
     */
    public Vector normalize() {
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

    /**
     * Rotates the vector around the x axis
     * @param alpha the amount to rotate in degrees
     * @return the current vector
     */
    public Vector rotateX(double alpha) {
        double radianAlpha = alpha * Math.PI / 180;

        double x = this.getX();
        double y = this.getY() * Math.cos(radianAlpha) - this.getZ() * Math.sin(radianAlpha);
        double z = this.getY() * Math.sin(radianAlpha) + this.getZ() * Math.cos(radianAlpha);

        this.setCoordinate(x, y, z);
        return this;
    }


    /**
     * Rotates the vector around the y axis
     * @param alpha the amount to rotate in degrees
     * @return the current vector
     */
    public Vector rotateY(double alpha) {
        double radianAlpha = alpha * Math.PI / 180;

        double x = this.getX() * Math.cos(radianAlpha) + this.getZ() * Math.sin(radianAlpha);
        double y = this.getY();
        double z = -this.getX() * Math.sin(radianAlpha) + this.getZ() * Math.cos(radianAlpha);

        this.setCoordinate(x, y, z);
        return this;
    }


    /**
     * Rotates the vector around the z axis
     * @param alpha the amount to rotate in degrees
     * @return the current vector
     */
    public Vector rotateZ(double alpha) {
        double radianAlpha = alpha * Math.PI / 180;

        double x = this.getX() * Math.cos(radianAlpha) - this.getY() * Math.sin(radianAlpha);
        double y = this.getX() * Math.sin(radianAlpha) + this.getY() * Math.cos(radianAlpha);
        double z = this.getZ();

        this.setCoordinate(x, y, z);
        return this;
    }
}