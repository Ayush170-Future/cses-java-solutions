
    public static boolean isSafe(int[][] mat, int i, int j) {
        if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || mat[i][j] == -1) {
            return false;
        }

        return true;
    }

    public static int findMaximum(int[][] mat, List<Integer> indices, HashMap<List<Integer>, Integer> cache) {
        int i1 = indices.get(0), j1 = indices.get(1), i2 = indices.get(2), j2 = indices.get(3);
        if (!isSafe(mat, i1, j1) || (!isSafe(mat, i2, j2))) {
            return Integer.MIN_VALUE;
        }

        List<Integer> lastIndex = Arrays.asList(mat.length-1, mat[0].length-1, mat.length-1, mat[0].length-1);
        if (indices.equals(lastIndex)) {
            return mat[i1][j1];
        }

        Integer value = cache.get(indices);
        if (value != null) {
            return value;
        }

        Integer numPoints = mat[i1][j1];
        if (i1 != i2 || j1 != j2) {
            numPoints += mat[i2][j2];
        }
        numPoints += Math.max(
                Math.max(findMaximum(mat, Arrays.asList(i1+1, j1, i2+1, j2), cache),
                        findMaximum(mat, Arrays.asList(i1, j1+1, i2, j2+1), cache)),
                Math.max(findMaximum(mat, Arrays.asList(i1+1, j1, i2, j2+1), cache),
                        findMaximum(mat, Arrays.asList(i1, j1+1, i2+1, j2), cache))
        );
        cache.put(indices, numPoints);

        return numPoints;
    }
    public static int GetMaxMangoes(List<String> a) {
        int n = a.size();
        int m = a.get(0).length();

        int[][] mat = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(a.get(i).charAt(j) == '*') {
                    mat[i][j] = 0;
                } else if(a.get(i).charAt(j) == '$') {
                    mat[i][j] = 1;
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        HashMap<List<Integer>, Integer> cache = new HashMap<List<Integer>, Integer>();
        int ans = findMaximum(mat, Arrays.asList(0, 0, 0, 0), cache);

        cache = new HashMap<>();

        int[][] b = new int[n][m];

        for(int j = n-1; j >= 0; j--) {
            for(int i = 0; i < n; i++) {
                b[n-1-i][n-1-j] = mat[i][j];
            }
        }

        ans += findMaximum(b, Arrays.asList(0,0,0,0), cache);
        return ans;
    }
