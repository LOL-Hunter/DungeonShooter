package de.hunter.game;


import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import de.hunter.game.camera.Camera;
import de.hunter.game.gamemath.Rectangle3D;

public class GameObject extends ModelInstance {
    private float radius;
    private final BoundingBox bounds = new BoundingBox();
    private final Vector3 center = new Vector3();
    private final Vector3 dimensions = new Vector3();
    private final Vector3 position = new Vector3(0, 5, 0);
    private final Rectangle3D rectangle3D = new Rectangle3D();
    public GameObject(Model model) {
        super(model);
        this.calculateBoundingBox(bounds);
        bounds.getCenter(center);
        bounds.getDimensions(dimensions);
        System.out.println(dimensions);
        radius = dimensions.len() / 2f;
        //TODO bounds.getCenterX() => 0 | decide if use center or corner coords before coding colliders!
        rectangle3D.setFromCenter(bounds.getCenterX(), bounds.getCenterY(), bounds.getCenterZ(), bounds.getWidth(), bounds.getHeight(), bounds.getDepth());
        System.out.print(rectangle3D);
    }

    public boolean isVisible(Camera cam) {
        return cam.frustum.sphereInFrustum(transform.getTranslation(position).add(center), radius);
    }

    public boolean collide(Rectangle3D rectangle3D){
        return this.rectangle3D.collisionWithRectangle(rectangle3D);
    }
    public float getDistance(){
        return 0;
    }




}
