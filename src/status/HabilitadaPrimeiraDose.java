package status;

import governo.Pessoa;

public class HabilitadaPrimeiraDose implements Status{
    public void atualiza(Pessoa pessoa) {
        pessoa.setStatus(new TomouUmaDose());
    }

    public String toString() {
        return "Habilitada para tomar a primeira dose.";
    }
}
