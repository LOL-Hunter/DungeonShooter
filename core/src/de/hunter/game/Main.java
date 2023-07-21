package de.hunter.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.*;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
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

		Texture grassBlock = new Texture("grass_block.png");


		TextureRegion textureRegionBottom = new TextureRegion(grassBlock, 0, 0, 64, 64);
		TextureRegion textureRegionSide = new TextureRegion(grassBlock, 64, 0, 64, 64);
		TextureRegion textureRegionTop = new TextureRegion(grassBlock, 64*2, 0, 64, 64);

		Material materialGreen = new Material(ColorAttribute.createDiffuse(Color.GREEN));
		Model floorModel = modelBuilder.createLineGrid(20, 20, 5, 5, materialGreen, Usage.Position | Usage.Normal);

		int attr =  Usage.Position | Usage.Normal | Usage.TextureCoordinates;

		// create Grassblock
		modelBuilder.begin();
		float size = 5.0f;
		MeshPartBuilder meshPartBuilder = modelBuilder.part("box", GL20.GL_TRIANGLES, attr, new Material(TextureAttribute.createDiffuse(grassBlock)));

		meshPartBuilder.setUVRange(textureRegionSide); // side
		meshPartBuilder.rect(-size,-size,-size, // 00
							 -size, size,-size, // 10
							  size, size,-size, // 11
							  size,-size,-size, // 01
				0, 0, -1);
		meshPartBuilder.setUVRange(textureRegionTop); // top
		meshPartBuilder.rect(-size, size,-size, // 00
							 -size, size, size, // 10
							  size, size, size, // 11
							  size, size,-size, // 01
				0,1,0);

		meshPartBuilder.setUVRange(textureRegionSide); // side
		meshPartBuilder.rect(-size, size, size, // 00
							 -size,-size, size, // 10
							  size,-size, size, // 11
							  size, size, size, // 01
				0,0,1);

		meshPartBuilder.setUVRange(textureRegionSide); //side
		meshPartBuilder.rect(-size,-size, size, // 00
							 -size, size, size, // 10
							 -size, size,-size, // 11
							 -size,-size,-size, // 01
				-1,0,0);

		meshPartBuilder.setUVRange(textureRegionSide); // side
		meshPartBuilder.rect(size,-size,-size, // 00      size,-size,-size,
							 size, size,-size, // 10      size, size,-size,
							 size, size, size, // 01      size,-size, size,
							 size,-size, size, // 11      size, size, size,
				1,0,0);

		meshPartBuilder.setUVRange(textureRegionBottom); // bot
		meshPartBuilder.rect(-size,-size, size, // 00
							 -size,-size,-size, // 10
							  size,-size,-size, // 11
							  size,-size, size, // 01
				0,-1,0);

		Model boxModel = modelBuilder.end();



		disposables.add(boxModel);
		disposables.add(floorModel);

		ModelInstance floorInstance = new ModelInstance(floorModel);
		ModelInstance boxInstance = new GameObject(boxModel);
		boxInstance.transform.translate(0, 5, 0);


		//modelInstances.add(boxInstance2);
		modelInstances.add(floorInstance);
		modelInstances.add(boxInstance);

		environment = new Environment();
		environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.5f, 0.5f, .5f, 1));
		environment.add(new DirectionalLight().set(1f, 1f, 1f,  .5f, -0.5f, 0.5f));

		OverlyText.init();
		GUI.init(player.getCamera());
	}
	public void onTick(float dt){
		// Movement & Camera update
		player.update();
		if (((GameObject) modelInstances.get(1)).isVisible(player.getCamera())){
			System.out.print(".");
		}
	}
	@Override
	public void render() {
		// OpenGL clear
		gl.glClearColor(.6f, .6f, .6f, 1);
		gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		//gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		player.getViewport().apply();
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
		GUI.render(player);
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
		player.getViewport().update(width, height);
		OverlyText.resize(width, height);
		GUI.resize(width, height);

	}
	@Override
	public void pause() {
		player.getCamera().getController().setMouseCatched(false);
	}
}