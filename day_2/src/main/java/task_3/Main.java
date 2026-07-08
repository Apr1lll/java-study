package task_3;

class Matrix {
    private double[][] data;
    private int rows;
    private int cols;
    
    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows][cols];
    }
    
    public Matrix(double[][] data) {
        this.rows = data.length;
        this.cols = data[0].length;
        this.data = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.data[i][j] = data[i][j];
            }
        }
    }
    
    public void setValue(int i, int j, double value) {
        if (i >= 0 && i < rows && j >= 0 && j < cols) {
            data[i][j] = value;
        }
    }
    
    public double getValue(int i, int j) {
        if (i >= 0 && i < rows && j >= 0 && j < cols) {
            return data[i][j];
        }
        return 0;
    }
    
    public Matrix add(Matrix other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            System.out.println("Ошибка: размеры матриц не совпадают для сложения");
            return null;
        }
        
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] + other.data[i][j];
            }
        }
        return result;
    }
    
    public Matrix multiplyByNumber(double number) {
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] * number;
            }
        }
        return result;
    }
    
    public Matrix multiply(Matrix other) {
        if (this.cols != other.rows) {
            System.out.println("Ошибка: количество столбцов первой матрицы должно равняться количеству строк второй матрицы");
            return null;
        }
        
        Matrix result = new Matrix(this.rows, other.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                double sum = 0;
                for (int k = 0; k < this.cols; k++) {
                    sum += this.data[i][k] * other.data[k][j];
                }
                result.data[i][j] = sum;
            }
        }
        return result;
    }
    
    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%8.2f ", data[i][j]);
            }
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        double[][] data1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        double[][] data2 = {
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
        };
        
        Matrix matrix1 = new Matrix(data1);
        Matrix matrix2 = new Matrix(data2);
        
        System.out.println("Матрица 1:");
        matrix1.print();
        
        System.out.println("\nМатрица 2:");
        matrix2.print();
        
        System.out.println("\nСложение матриц:");
        Matrix sum = matrix1.add(matrix2);
        if (sum != null) {
            sum.print();
        }
        
        System.out.println("\nУмножение матрицы 1 на число 2.5:");
        Matrix multiplied = matrix1.multiplyByNumber(2.5);
        multiplied.print();
        
        double[][] data3 = {
            {1, 2},
            {3, 4},
            {5, 6}
        };
        
        double[][] data4 = {
            {7, 8, 9},
            {10, 11, 12}
        };
        
        Matrix matrix3 = new Matrix(data3);
        Matrix matrix4 = new Matrix(data4);
        
        System.out.println("\nМатрица 3 (3x2):");
        matrix3.print();
        
        System.out.println("\nМатрица 4 (2x3):");
        matrix4.print();
        
        System.out.println("\nУмножение матриц (3x2 * 2x3):");
        Matrix product = matrix3.multiply(matrix4);
        if (product != null) {
            product.print();
        }
        
        System.out.println("\nДемонстрация метода setValue:");
        Matrix matrix5 = new Matrix(3, 3);
        matrix5.setValue(0, 0, 10);
        matrix5.setValue(1, 1, 20);
        matrix5.setValue(2, 2, 30);
        matrix5.print();
    }
}