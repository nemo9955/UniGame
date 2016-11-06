package com.nemo9955.Components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.decals.Decal;
import com.badlogic.gdx.graphics.g3d.decals.DecalMaterial;

public class CDecal extends Decal implements Component {

    public CDecal() {
	super();
	// TODO Auto-generated constructor stub
    }

    public CDecal(DecalMaterial material) {
	super(material);
	// TODO Auto-generated constructor stub
    }

    /**
     * Creates a decal using the region for texturing
     * 
     * @param width
     *            Width of the decal in world units
     * @param height
     *            Height of the decal in world units
     * @param textureRegion
     *            TextureRegion to use
     * @param hasTransparency
     *            Whether or not this sprite will be treated as having
     *            transparency (transparent png, etc.)
     * @return Created decal
     */
    public CDecal(TextureRegion textureRegion, boolean hasTransparency) {
	this(textureRegion, hasTransparency ? GL20.GL_SRC_ALPHA : DecalMaterial.NO_BLEND, hasTransparency ? GL20.GL_ONE_MINUS_SRC_ALPHA : DecalMaterial.NO_BLEND);
    }

    /**
     * Creates a decal using the region for texturing and the specified blending
     * parameters for blending
     * 
     * @param width
     *            Width of the decal in world units
     * @param height
     *            Height of the decal in world units
     * @param textureRegion
     *            TextureRegion to use
     * @param srcBlendFactor
     *            Source blend used by glBlendFunc
     * @param dstBlendFactor
     *            Destination blend used by glBlendFunc
     * @return Created decal
     */
    public CDecal(TextureRegion textureRegion, int srcBlendFactor, int dstBlendFactor) {
	setTextureRegion(textureRegion);
	setBlending(srcBlendFactor, dstBlendFactor);
	// decal.dimensions.x = width;
	// decal.dimensions.y = height;
	setDimensions(textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
	setColor(1, 1, 1, 1);

    }

    /**
     * Creates a decal assuming the dimensions of the texture region
     * 
     * @param textureRegion
     *            Texture region to use
     * @return Created decal
     */
    public CDecal(TextureRegion textureRegion) {
	this(textureRegion, DecalMaterial.NO_BLEND, DecalMaterial.NO_BLEND);
    }

}
