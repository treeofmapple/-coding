package Others;

public class Others {
	
	public String setArray(int[][] array) {
		return this.printArray(array);
	}

	private String printArray(int[][] array) {
		if (array == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for (int i = 0; i < array.length; i++) {
			sb.append("{");
			if (array[i] != null) {
				for (int j = 0; j < array[i].length; j++) {
					sb.append(array[i][j]);
					if (j < array[i].length - 1) {
						sb.append(", ");
					}
				}
			}
			sb.append("}");
			if (i < array.length - 1) {
				sb.append(", ");
			}
		}
		sb.append("}");
		return sb.toString();
	}
}
