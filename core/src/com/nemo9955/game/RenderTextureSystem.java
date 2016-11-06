package com.nemo9955.game;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.nemo9955.Components.CPosition;
import com.nemo9955.Components.CTexture;
import com.nemo9955.utils.UG;

public class RenderTextureSystem extends IteratingSystem {
    private ComponentMapper<CPosition> pm = ComponentMapper.getFor(CPosition.class);
    private ComponentMapper<CTexture>  vm = ComponentMapper.getFor(CTexture.class);

    @SuppressWarnings("unchecked")
    public RenderTextureSystem() {
	super(Family.all(CTexture.class).get());
    }

    public void processEntity(Entity entity, float deltaTime) {
	CPosition poz = pm.get(entity);
	CTexture tex = vm.get(entity);

	// dec.setPosition(poz);
	// dec.setRotation(Vector3.Y, Vector3.Y);

	UG.spriteBatch.draw(tex, poz.x, poz.z);
	// System.out.println("print");
    }
}
