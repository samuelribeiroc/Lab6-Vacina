package status;

import governo.Pessoa;

public class TomouUmaDose implements Status{
    public void atualiza(Pessoa pessoa) {
        pessoa.setStatus(new HabilitadaSegundaDose());
        pessoa.setDiaPrimeiraDose();
    }

    public String toString() {
        return "Tomou a primeira dose.";
    }
}
