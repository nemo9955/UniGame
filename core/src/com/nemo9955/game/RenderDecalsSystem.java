package com.nemo9955.game;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.math.Vector3;
import com.nemo9955.Components.CDecal;
import com.nemo9955.utils.UG;

public class RenderDecalsSystem extends IteratingSystem {
    // private ComponentMapper<CPosition> pm =
    // ComponentMapper.getFor(CPosition.class);
    private ComponentMapper<CDecal> vm = ComponentMapper.getFor(CDecal.class);

    @SuppressWarnings("unchecked")
    public RenderDecalsSystem() {
	super(Family.all(CDecal.class).get());
    }

    public void processEntity(Entity entity, float deltaTime) {
	// CPosition poz = pm.get(entity);
	CDecal dec = vm.get(entity);

	// dec.setPosition(poz);
//	dec.setRotation(Vector3.Y, Vector3.Y);

	UG.decalBatch.add(dec);
	// System.out.println("print");
    }
}
