package com.nemo9955.game;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.Model;
import com.nemo9955.Components.CModelInstance;
import com.nemo9955.Components.CPosition;
import com.nemo9955.Components.CTexture;
import com.nemo9955.utils.UG;

public class EntityCustom extends Entity {

    World world;

    public EntityCustom(World world) {
	this.world = world;
    }

    public EntityCustom addTextureHexCoord(String name, int q, int r) {
	float size = world.hexHeight / 2;

	float x = (float) (size * Math.sqrt(3) * (q + 0.5 * (r & 1)));
	float z = size * 3 / 2 * r;

	CPosition poz = new CPosition(x, 0, z);
	TextureRegion t = UG.atlas.findRegion(name);
	CTexture tex = new CTexture(t);
	add(tex);
	add(poz);
	return this;
    }

    public EntityCustom addModelPosition(Model model, int q, int r) {
	float size = world.hexHeight / 2;

	float x = (float) (size * Math.sqrt(3) * (q + 0.5 * (r & 1)));
	float z = size * 3 / 2 * r;

	CPosition poz = new CPosition(x, 0, z);
	add(new CModelInstance(UG.getTree()));
	add(poz);
	return this;
    }

}
