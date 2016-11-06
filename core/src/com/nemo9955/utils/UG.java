package com.nemo9955.utils;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.decals.DecalBatch;
import com.nemo9955.UniGame;

public class UG {

    public static SpriteBatch  spriteBatch;
    public static AssetManager assets = new AssetManager();

    public static DecalBatch   decalBatch;
    public static TextureAtlas atlas;
    private static Model       trees;

    public static UniGame      game;

    public static ModelInstance getTree() {
	if (UG.trees == null)
	    UG.trees = UG.assets.get("models/trees-lowpoly.obj", Model.class);

	String bark = UG.trees.nodes.random().id.replaceAll("laeves", "bark");
	String leaves = bark.replaceAll("bark", "laeves");

	return new ModelInstance(UG.trees, bark, leaves);
    }
}
