package com.nemo9955.Components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class CPosition extends Vector3 implements Component {

	public CPosition() {
		super();
	}

	public CPosition(float x, float y, float z) {
		super(x, y, z);
	}

	public CPosition(float[] values) {
		super(values);
	}

	public CPosition(Vector2 vector, float z) {
		super(vector, z);
	}

	public CPosition(Vector3 vector) {
		super(vector);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
