public class AproximadorPi {

    private int n;
    private double resultadoMonteCarlo;
    private double resultadoLeibniz;

    // constructor
    public AproximadorPi(int n) {
        this.n = n;
    }

    // metodo de montecarlo
    public void calcularMonteCarlo() {
        int dentro = 0;

        for (int i = 0; i < n; i++) {
            double x = Math.random();
            double y = Math.random();

            if (x * x + y * y <= 1) {
                dentro++;
            }
        }

        resultadoMonteCarlo = 4.0 * dentro / n;
    }

    // metodo de leibniz
    public void calcularLeibniz() {
        double suma = 0.0;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                suma += 1.0 / (2 * i + 1);
            } else {
                suma -= 1.0 / (2 * i + 1);
            }
        }

        resultadoLeibniz = 4 * suma;
    }

    // getters
    public int getN() {
        return n;
    }

    public double getResultadoMonteCarlo() {
        return resultadoMonteCarlo;
    }

    public double getResultadoLeibniz() {
        return resultadoLeibniz;
    }

    // setters
    public void setN(int n) {
        this.n = n;
    }

    public void setResultadoMonteCarlo(double resultadoMonteCarlo) {
        this.resultadoMonteCarlo = resultadoMonteCarlo;
    }

    public void setResultadoLeibniz(double resultadoLeibniz) {
        this.resultadoLeibniz = resultadoLeibniz;
    }

    // toString
    @Override
    public String toString() {
        return "Iteraciones: " + n +
               "\nMontecarlo: " + resultadoMonteCarlo +
               "\nLeibniz: " + resultadoLeibniz +
               "\nPI real: " + Math.PI +
               "\nDiferencia Montecarlo: " + Math.abs(resultadoMonteCarlo - Math.PI) +
               "\nDiferencia Leibniz: " + Math.abs(resultadoLeibniz - Math.PI);
    }
}