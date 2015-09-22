/**
 *****************************************************************************
 Copyright (c) 2015 IBM Corporation and other Contributors.
 All rights reserved. This program and the accompanying materials
 are made available under the terms of the Eclipse Public License v1.0
 which accompanies this distribution, and is available at
 http://www.eclipse.org/legal/epl-v10.html
 Contributors:
 Sathiskumar Palaniappan - Initial Contribution
 *****************************************************************************
 *
 */

package com.ibm.iotf.devicemgmt.device.resource;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

/**
 * An internal class that represents a Json attribute of the
 * Device
 */
public class JsonResource extends Resource<JsonObject> {

	public JsonResource(String name, JsonObject value) {
		super(name, value);
	}
	
	/**
	 * Returns the value in Json Format
	 */
	@Override
	public JsonElement toJsonObject() {
		return (JsonElement) getValue();
	}
	
	/**
	 * Updates the value of this resource with the given Json value
	 */
	public int update(JsonElement json) {
		return update(json, true);
	}

	/**
	 * Updates the value of this resource with the given Json value
	 */
	public int update(JsonElement json, boolean fireEvent) {
		this.setValue((JsonObject)json, fireEvent);
		return this.getRC();
	}
}
