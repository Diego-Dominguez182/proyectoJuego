package math;

public class Vector2D {
    private double x, y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D(Vector2D v) {
        this.x = v.x;
        this.y = v.y;
    }

    public Vector2D() {
        x = 0;
        y = 0;
    }

    public Vector2D add(Vector2D v) {
        // Devuelve un nuevo Vector2D que es la suma de este Vector2D y otro Vector2D dado
        return new Vector2D(x + v.getX(), y + v.getY());
    }

    public Vector2D subtract(Vector2D v) {
        // Devuelve un nuevo Vector2D que es la resta de este Vector2D y otro Vector2D dado
        return new Vector2D(x - v.getX(), y - v.getY());
    }

    public Vector2D scale(double value) {
        // Devuelve un nuevo Vector2D que es este Vector2D multiplicado por un valor dado
        return new Vector2D(x * value, y * value);
    }

    public Vector2D limit(double value) {
        // Limita la magnitud de este Vector2D al valor dado y devuelve un nuevo Vector2D
        if (getMagnitude() > value) {
            return this.normalize().scale(value);
        }
        return this;
    }

    public Vector2D normalize() {
        // Devuelve un nuevo Vector2D que tiene la misma dirección pero una magnitud de 1
        double magnitude = getMagnitude();
        return new Vector2D(x / magnitude, y / magnitude);
    }

    public double getMagnitude() {
        // Calcula y devuelve la magnitud (longitud) de este Vector2D
        return Math.sqrt(x * x + y * y);
    }

    public Vector2D setDirection(double angle) {
        // Establece la dirección de este Vector2D en base a un ángulo dado y devuelve un nuevo Vector2D
        double magnitude = getMagnitude();
        return new Vector2D(Math.cos(angle) * magnitude, Math.sin(angle) * magnitude);
    }

    public double getAngle() {
        // Calcula y devuelve el ángulo de este Vector2D
        return Math.asin(y / getMagnitude());
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
