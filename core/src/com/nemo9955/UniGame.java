package com.nemo9955;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.decals.CameraGroupStrategy;
import com.badlogic.gdx.graphics.g3d.decals.DecalBatch;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.model.Node;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.nemo9955.game.World;
import com.nemo9955.utils.UG;

public class UniGame extends ApplicationAdapter {

    World			 world;
    public InputMultiplexer	 inputs	= new InputMultiplexer();
    public PerspectiveCamera	 camera;
    private ScreenViewport	 viewport;
    public CameraInputController camController;

    public Environment		 environment;
    public ModelBatch		 modelBatch;
    public Model		 model;

    {
	UG.game = this;
    }

    @Override
    public void create() {
	loadAssets();
	makeTestModel();

	camera = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	camera.position.set(-600f, 500f, -600f);
	camera.lookAt(0, 0, 0);
	camera.near = 1f;
	camera.far = 1000f;
	camera.update();

	viewport = new ScreenViewport(camera);
	viewport.setUnitsPerPixel(2.0f);
	UG.decalBatch = new DecalBatch(new CameraGroupStrategy(camera));

	camController = new CameraInputController(camera);
	camController.scrollFactor = 10 ;
//	camController.fact
	Gdx.input.setInputProcessor(camController);

	UG.spriteBatch = new SpriteBatch();
	// img = new Texture("badlogic.jpg");
	world = new World(8, 8, 110, 128);
    }

    private void makeTestModel() {
	environment = new Environment();
	environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
	environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));
	modelBatch = new ModelBatch();
	ModelBuilder modelBuilder = new ModelBuilder();
	model = modelBuilder.createBox(5f, 5f, 5f, new Material(ColorAttribute.createDiffuse(Color.GREEN)), Usage.Position | Usage.Normal);

    }

    private void loadAssets() {
	UG.assets.load("img/sprites.json", Skin.class);

	UG.assets.load("models/trees-lowpoly.obj", Model.class);

	UG.assets.finishLoading();
	UG.atlas = UG.assets.get("img/sprites.atlas", TextureAtlas.class);
    }

    Matrix4 spriteProj = new Matrix4();

    @Override
    public void render() {
	camController.update();
	spriteProj.set(camera.combined).rotate(Vector3.X, 90);
	UG.spriteBatch.setProjectionMatrix(spriteProj);

	// Gdx.gl.glClearColor(0.9f, 0.9f, 0.9f, 1);
	// Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

	Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

	modelBatch.begin(camera);
	UG.spriteBatch.begin();
	world.update(Gdx.graphics.getRawDeltaTime());
	UG.spriteBatch.end();
	modelBatch.end();
	UG.decalBatch.flush();
    }

    @Override
    public void dispose() {
	// batch.dispose();
	// img.dispose();

	modelBatch.dispose();
	model.dispose();
    }
}
