import android.widget.ProgressBar;

public class simptomat {
    private String simptoma;
    private ProgressBar progresi;

    public String getSimptoma() {
        return simptoma;
    }

    public void setSimptoma(String simptoma) {
        this.simptoma = simptoma;
    }

    public ProgressBar getProgresi() {
        return progresi;
    }

    public void setProgresi(ProgressBar progresi) {
        this.progresi = progresi;
    }

    public simptomat(String simptoma, ProgressBar progresi) {

        this.simptoma = simptoma;
        this.progresi = progresi;
    }
}

