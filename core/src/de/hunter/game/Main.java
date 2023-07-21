package de.hunter.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.*;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.utils.Disposable;
import de.hunter.game.gui.GUI;
import de.hunter.game.gui.OverlyText;

import java.util.ArrayList;
public class Main extends ApplicationAdapter {
	public Player player;
	public ArrayList<ModelInstance> modelInstances = new ArrayList<>();
	public ArrayList<Disposable> disposables = new ArrayList<>();
	public ModelBatch modelBatch;
	public Environment environment;
	public GL20 gl;

	@Override
	public void create() {
		gl = Gdx.gl;
		modelBatch = new ModelBatch();
		player = new Player(this);

		ModelBuilder modelBuilder = new ModelBuilder();

		Material materialGreen = new Material(ColorAttribute.createDiffuse(Color.GREEN));
		Material materialBlue = new Material(ColorAttribute.createDiffuse(Color.BLUE));
		Material materialRed = new Material(ColorAttribute.createDiffuse(Color.RED));

		Model boxModel = modelBuilder.createBox(5f, 5f, 5f, materialRed, Usage.Position | Usage.Normal);
		Model boxModel2 = modelBuilder.createBox(2.5f, 2.5f, 2.5f, materialBlue, Usage.Position | Usage.Normal);
		Model floorModel = modelBuilder.createLineGrid(20, 20, 5, 5, materialGreen, Usage.Position | Usage.Normal);

		disposables.add(boxModel);
		disposables.add(boxModel2);
		disposables.add(floorModel);

		ModelInstance floorInstance = new ModelInstance(floorModel);
		ModelInstance boxInstance = new ModelInstance(boxModel);
		boxInstance.transform.translate(0, 2.5f, 0);
		//boxInstance.transform.rotate(new Vector3(1, 0, 0), 45);

		ModelInstance boxInstance2 = new ModelInstance(boxModel2);
		boxInstance2.transform.translate(0, 6.25f, 0);

		modelInstances.add(boxInstance2);
		modelInstances.add(floorInstance);
		modelInstances.add(boxInstance);

		environment = new Environment();
		environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.5f, 0.5f, .5f, 1));
		environment.add(new DirectionalLight().set(1f, 1f, 1f,  .5f, -0.5f, 0.5f));

		OverlyText.init(player.getCamera());
		GUI.init(player.getCamera());
	}
	public void onTick(float dt){
		// Movement & Camera update
		player.update();
	}
	@Override
	public void render() {
		// OpenGL clear
		gl.glClearColor(.6f, .6f, .6f, 1);
		gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		// onTick
		onTick(Gdx.graphics.getDeltaTime());

		// 3D
		modelBatch.begin(player.getCamera());
		for (ModelInstance i:modelInstances){
			modelBatch.render(i, environment);
		}
		modelBatch.end();

		// 2D
		OverlyText.render();
		GUI.render();
	}
	@Override
	public void dispose() {
		for (Disposable i:disposables){
			i.dispose();
		}
		OverlyText.dispose();
		GUI.dispose();
	}
	@Override
	public void resume() {
		// TODO check for open inventories/menus
		player.getCamera().getController().setMouseCatched(true);
	}
	@Override
	public void resize(int width, int height) {
		OverlyText.resize(width, height);
		GUI.resize(width, height);

	}
	@Override
	public void pause() {
		player.getCamera().getController().setMouseCatched(false);
	}
}