package com.nemo9955.game;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.IntMap;
import com.nemo9955.Components.CDecal;
import com.nemo9955.Components.CPosition;
import com.nemo9955.Components.CTexture;
import com.nemo9955.utils.UG;

public class World {

    Engine		   engine = new Engine();
    public int		   maxWidth, maxHeight, hexWidht, hexHeight;

    private IntMap<Entity> map;

    public World(int maxWidth, int maxHeight, int hexWidht, int hexHeight) {
	this.maxWidth = maxWidth;
	this.maxHeight = maxHeight;
	this.hexWidht = hexWidht;
	this.hexHeight = hexHeight;
	map = new IntMap<Entity>(maxWidth * maxHeight);

	RenderDecalsSystem rds = new RenderDecalsSystem();
	engine.addSystem(rds);
	RenderTextureSystem rts = new RenderTextureSystem();
	engine.addSystem(rts);

	// makeDecal("Grass", new CPosition(0, 0, 0));
	WorldGenerator.generateNoiseWorld(this);

    }

    public Entity addDecalPosition(String name, CPosition poz) {
	TextureRegion tex = UG.atlas.findRegion(name);
	Entity e = new Entity();
	CDecal dec = new CDecal(tex, true);
	dec.setPosition(poz);
	e.add(dec);
	e.add(poz);
	engine.addEntity(e);
	return e;
    }

    public void update(float delta) {
	engine.update(delta);

    }

    public EntityCustom makeEntity() {
	EntityCustom ent = new EntityCustom(this);
	engine.addEntity(ent);
	return ent;
    }

}
