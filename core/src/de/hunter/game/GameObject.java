package de.hunter.game;


import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import de.hunter.game.camera.Camera;

public class GameObject extends ModelInstance {
    private float radius;
    private final BoundingBox bounds = new BoundingBox();
    private final Vector3 center = new Vector3();
    private final Vector3 dimensions = new Vector3();
    private final Vector3 position = new Vector3(0, 5, 0);
    public GameObject(Model model) {
        super(model);
        calculateBoundingBox(bounds);
        bounds.getCenter(center);
        bounds.getDimensions(dimensions);
        System.out.println(dimensions);
        radius = dimensions.len() / 2f;
    }


    public boolean isVisible(Camera cam) {
        return cam.frustum.sphereInFrustum(transform.getTranslation(position).add(center), radius);
    }




}
