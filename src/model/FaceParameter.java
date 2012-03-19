package model;

import util.Log;
import util.Log.LogType;


public class FaceParameter {

	private final double[] verticesWeight;
	private final double[] colorWeight;
	private final int modelCount;

	/** @return a random FaceParameter
	 *  @param modelCount the number of face in the morphable model
	 */
	public FaceParameter(int modelCount) {
		this.verticesWeight = new double[modelCount];
		this.colorWeight = new double[modelCount];
		this.modelCount = modelCount;

		for(int x = 0; x < modelCount; x++) {
			verticesWeight[x] = Math.random();
			colorWeight[x] = Math.random();
		}

		normalize();
	}

	/** @return the number of parameter stored. */
	public int getModelCount() {
		return modelCount;
	}

	/** @return the weigth array for the vertices. */
	public double[] getVerticesWeight() {
		return verticesWeight;
	}

	/** @return the weigth array for the colors. */
	public double[] getColorWeight() {
		return colorWeight;
	}

	/** Make sure that the total of each weight array equal 1.0 */
	private void normalize() {
		double totalVertices = 0.0;
		double totalColor = 0.0;
		for(int x = 0; x < modelCount; x++) {
			totalVertices += verticesWeight[x];
			totalColor += colorWeight[x];
		}

		for(int x = 0; x < modelCount; x++) {
			verticesWeight[x] /= totalVertices;
			colorWeight[x] /= totalColor;
		}
		Log.debug(LogType.MODEL, "Normalizing by colors: " + 1/totalColor + " vertices: " + 1/totalVertices);
	}
}
