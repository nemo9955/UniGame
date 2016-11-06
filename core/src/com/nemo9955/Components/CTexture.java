package com.nemo9955.Components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class CTexture extends TextureRegion implements Component {

    public CTexture() {
	super();
	// TODO Auto-generated constructor stub
    }

    public CTexture(Texture texture, float u, float v, float u2, float v2) {
	super(texture, u, v, u2, v2);
	// TODO Auto-generated constructor stub
    }

    public CTexture(Texture texture, int x, int y, int width, int height) {
	super(texture, x, y, width, height);
	// TODO Auto-generated constructor stub
    }

    public CTexture(Texture texture, int width, int height) {
	super(texture, width, height);
	// TODO Auto-generated constructor stub
    }

    public CTexture(Texture texture) {
	super(texture);
	// TODO Auto-generated constructor stub
    }

    public CTexture(TextureRegion region, int x, int y, int width, int height) {
	super(region, x, y, width, height);
	// TODO Auto-generated constructor stub
    }

    public CTexture(TextureRegion region) {
	super(region);
	// TODO Auto-generated constructor stub
    }

}
