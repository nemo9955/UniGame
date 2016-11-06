package com.nemo9955.Components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

public class CModelInstance extends ModelInstance implements Component {

    public CModelInstance(Model model, Array<String> rootNodeIds) {
	super(model, rootNodeIds);
	// TODO Auto-generated constructor stub
    }

    public CModelInstance(Model model, float x, float y, float z) {
	super(model, x, y, z);
	// TODO Auto-generated constructor stub
    }

    public CModelInstance(Model model, Matrix4 transform, Array<String> rootNodeIds, boolean shareKeyframes) {
	super(model, transform, rootNodeIds, shareKeyframes);
	// TODO Auto-generated constructor stub
    }

    public CModelInstance(Model model, Matrix4 transform, Array<String> rootNodeIds) {
	super(model, transform, rootNodeIds);
	// TODO Auto-generated constructor stub
    }

    public CModelInstance(Model model, Matrix4 transform, String nodeId, boolean recursive, boolean parentTransform, boolean mergeTransform, boolean shareKeyframes) {
	super(model, transform, nodeId, recursive, parentTransform, mergeTransform, shareKeyframes);
	// TODO Auto-generated constructor stub
    }

    public CModelInstance(Model model, Matrix4 transform, String nodeId, boolean recursive, boolean parentTransform, boolean mergeTransform) {
	super(model, transform, nodeId, recursive, parentTransform, mergeTransform);
	// TODO Auto-generated constructor stub
    }

    public CModelInstance(Model model, Matrix4 transform, String nodeId, boolean parentTransform, boolean mergeTransform) {
	super(model, transform, nodeId, parentTransform, mergeTransform);
	// TODO Auto-generated constructor stub
    }

    public CModelInstance(Model model, Matrix4 transform, String nodeId, boolean mergeTransform) {
	super(model, transform, nodeId, mergeTransform);
	// TODO Auto-generated constructor stub
    }

    public CModelInstance(Model model, Matrix4 transform, String... rootNodeIds) {
	super(model, transform, rootNodeIds);
	// TODO Auto-generated constructor stub
    }

    public CModelInstance(Model model, Matrix4 transform) {
	super(model, transform);
	// TODO Auto-generated constructor stub
    }

    public CModelInstance(Model model, String nodeId, boolean recursive, boolean parentTransform, boolean mergeTransform) {
	super(model, nodeId, recursive, parentTransform, mergeTransform);
	// TODO Auto-generated constructor stub
    }

    public CModelInstance(Model model, String nodeId, boolean parentTransform, boolean mergeTransform) {
	super(model, nodeId, parentTransform, mergeTransform);
	// TODO Auto-generated constructor stub
    }

    public CModelInstance(Model model, String nodeId, boolean mergeTransform) {
	super(model, nodeId, mergeTransform);
	// TODO Auto-generated constructor stub
    }

    public CModelInstance(Model model, String... rootNodeIds) {
	super(model, rootNodeIds);
	// TODO Auto-generated constructor stub
    }

    public CModelInstance(Model model, Vector3 position) {
	super(model, position);
	// TODO Auto-generated constructor stub
    }

    public CModelInstance(Model model) {
	super(model);
	// TODO Auto-generated constructor stub
    }

    public CModelInstance(ModelInstance copyFrom, Matrix4 transform, boolean shareKeyframes) {
	super(copyFrom, transform, shareKeyframes);
	// TODO Auto-generated constructor stub
    }

    public CModelInstance(ModelInstance copyFrom, Matrix4 transform) {
	super(copyFrom, transform);
	// TODO Auto-generated constructor stub
    }

    public CModelInstance(ModelInstance copyFrom) {
	super(copyFrom);
	// TODO Auto-generated constructor stub
    }

}
