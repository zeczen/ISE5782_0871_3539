package scene;

import geometries.Geometries;
import lighting.AmbientLight;
import primitives.Color;

public class Scene {
    public String name;
    public Color background;
    public AmbientLight ambientLight;
    public Geometries geometries;

    public Scene(String n) {
        this.name = n;
        this.background = Color.BLACK;
        this.ambientLight = new AmbientLight();
        this.geometries = new Geometries();
    }

    public Scene() {
        this.background = Color.BLACK;
        this.ambientLight = new AmbientLight();
        this.geometries = new Geometries();
    }

    public Scene setBackgroundColor(Color c) {
        this.background = c;
        return this;
    }

    public Scene setAmbientLight(AmbientLight al) {
        this.ambientLight = al;
        return this;
    }

    public Scene setGeometries(Geometries g) {
        this.geometries = g;
        return this;
    }

}